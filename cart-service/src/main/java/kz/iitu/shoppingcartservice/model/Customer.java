package kz.iitu.shoppingcartservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Customer {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String address;
    private String email;
    private String wallet;
}
