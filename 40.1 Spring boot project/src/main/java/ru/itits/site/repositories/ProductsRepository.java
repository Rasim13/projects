package ru.itits.site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itits.site.models.Product;

public interface ProductsRepository extends JpaRepository<Product, Long> {
}
