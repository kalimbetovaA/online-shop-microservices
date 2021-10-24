package kz.iitu.productcategoryservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Product Category ID")
    private Long id;
    @ApiModelProperty(notes = "The Product Category name")
    private String name;
}
