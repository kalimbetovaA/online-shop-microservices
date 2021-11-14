package kz.iitu.authservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.iitu.authservice.model.Customer;
import kz.iitu.authservice.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private CustomerServiceImpl customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ObjectMapper mapper=new ObjectMapper();
        List<Customer> users = mapper.convertValue(
                customerService.getUsers(),
                new TypeReference<List<Customer>>(){}
        );

        for (Customer user: users) {
            if (user.getUsername().equals(username)) {

                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList("ROLE_" + user.getRole());
                return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
            }
        }

        throw new UsernameNotFoundException("Username: " + username + " not found");
    }
}
