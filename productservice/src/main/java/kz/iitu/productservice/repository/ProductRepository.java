package kz.iitu.productservice.repository;

import kz.iitu.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByShopId(Long shopId);
    List<Product> findByCategoryId(Long categoryId);
}
