package kz.iitu.review.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review")
public class Review {
    @javax.persistence.Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated ID")
    private Long id;
    @ApiModelProperty(notes = "The Customer ID")
    private Long customerId;
    @ApiModelProperty(notes = "The Product ID")
    private Long productId;
    @ApiModelProperty(notes = "The Review message")
    private String message;
}
