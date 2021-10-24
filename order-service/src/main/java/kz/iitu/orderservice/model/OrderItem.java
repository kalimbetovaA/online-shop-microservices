package kz.iitu.orderservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Order Item ID")
    private Long id;
    @ApiModelProperty(notes = "The Product ID of the Order Item")
    private Long productId;
    @ApiModelProperty(notes = "The Product quantity of the Order Item")
    private int quantity;
    @ApiModelProperty(notes = "The price of the Order Item")
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @JsonIgnore
    private Order order;
}
