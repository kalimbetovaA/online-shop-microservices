package kz.iitu.favorites.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer_favorites")
public class CustomerFavorites {
    @javax.persistence.Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated ID")
    private Long id;
    @ApiModelProperty(notes = "The Customer ID")
    private Long customerId;

    @OneToMany(mappedBy = "favorites", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ApiModelProperty(notes = "The Favorites Products list")
    private List<FavProduct> favProducts;
}
