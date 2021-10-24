package kz.iitu.shoppingcartservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Cart Item ID")
    private Long id;
    @ApiModelProperty(notes = "The ID of Product in Cart Item")
    private Long productId;
    @ApiModelProperty(notes = "The Product count in Cart Item")
    private int count;
    @ApiModelProperty(notes = "The price of Cart Item")
    private double price;
    @ApiModelProperty(notes = "The description of Cart Item")
    private String description;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    @JsonIgnore
    private Cart cart;

}
