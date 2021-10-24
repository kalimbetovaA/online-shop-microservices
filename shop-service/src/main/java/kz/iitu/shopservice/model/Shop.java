package kz.iitu.shopservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Shop ID")
    private Long id;
    @ApiModelProperty(notes = "The Shop name")
    private String name;
    @ApiModelProperty(notes = "The Shop address")
    private String address;
    @ApiModelProperty(notes = "The Shop contact phone number")
    private String contactPhone;
}
