package ru.itits.site.service;

import ru.itits.site.dto.ProductDto;
import ru.itits.site.forms.ProductForm;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();
    ProductDto addProduct(ProductForm form);
}
