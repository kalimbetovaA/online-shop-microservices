package kz.iitu.productservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Product ID")
    private Long id;
    @Column(unique = true)
    @ApiModelProperty(notes = "The Product name")
    private String name;
    @ApiModelProperty(notes = "The id of the Shop where Product assigned")
    private Long shopId;
    @ApiModelProperty(notes = "The id of the Category where product assigned")
    private Long categoryId;
    @ApiModelProperty(notes = "The Product price")
    private double price;
    @ApiModelProperty(notes = "The Product description")
    private String description;
    @ApiModelProperty(notes = "The column responds to product availability")
    private boolean in_stock;
    private int count;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
