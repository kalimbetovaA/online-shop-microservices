package kz.iitu.customerservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Customer ID")
    private Long id;
    @Column(unique = true)
    @ApiModelProperty(notes = "The Customer username")
    private String username;
    @ApiModelProperty(notes = "The Customer firstname")
    private String firstname;
    @ApiModelProperty(notes = "The Customer lastname")
    private String lastname;
    @ApiModelProperty(notes = "The Customer password")
    private String password;
    @ApiModelProperty(notes = "The Customer address")
    private String address;
    @ApiModelProperty(notes = "The Customer email")
    private String email;
    @ApiModelProperty(notes = "The Customer chosen wallet")
    private String wallet;
}
