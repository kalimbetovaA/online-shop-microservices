package kz.iitu.orderservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Order ID")
    private Long id;
    @ApiModelProperty(notes = "The ID of the Customer who owns the Order")
    private Long customerId;
    @ApiModelProperty(notes = "The total price of Order")
    private Double totalPrice;
    @ApiModelProperty(notes = "The delivery address of Order")
    private String deliverAddress;
    @ApiModelProperty(notes = "The delivery status of Order")
    private Boolean deliverStatus;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}
