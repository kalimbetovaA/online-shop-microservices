package kz.iitu.productcategoryservice.repository;

import kz.iitu.productcategoryservice.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
