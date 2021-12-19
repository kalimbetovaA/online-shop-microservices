package kz.iitu.favorites.demo.repository;

import kz.iitu.favorites.demo.model.FavProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FavProductRepository extends JpaRepository <FavProduct, Long> {
}
