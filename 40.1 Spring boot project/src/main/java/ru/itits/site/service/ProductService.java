package ru.itits.site.service;

import ru.itits.site.dto.ProductDto;
import ru.itits.site.forms.ProductForm;
import ru.itits.site.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> getAll();
    ProductDto addProduct(ProductForm form);
    void deleteProductById(Long id);
    Optional<Product> findById(Long id);
}
