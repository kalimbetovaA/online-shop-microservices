package kz.iitu.authservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class Customer implements Serializable {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String address;
    private String email;
    private String wallet;
    private String role;
}
