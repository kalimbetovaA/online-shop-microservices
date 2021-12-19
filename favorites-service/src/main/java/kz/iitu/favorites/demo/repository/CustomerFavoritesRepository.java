package kz.iitu.favorites.demo.repository;

import kz.iitu.favorites.demo.model.CustomerFavorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerFavoritesRepository extends JpaRepository <CustomerFavorites, Long> {
    CustomerFavorites findByCustomerId(Long customerId);
}
