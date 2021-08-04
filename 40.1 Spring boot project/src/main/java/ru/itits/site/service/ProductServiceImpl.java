package ru.itits.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itits.site.dto.ProductDto;
import ru.itits.site.forms.ProductForm;
import ru.itits.site.models.Product;
import ru.itits.site.repositories.ProductsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public List<ProductDto> getAll() {
        return ProductDto.from(productsRepository.findAll());
    }

    @Override
    public ProductDto addProduct(ProductForm form) {
        Product product = Product.builder()
                .name(form.getName())
                .price(form.getPrice())
                .build();
        productsRepository.save(product);
        return ProductDto.from(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productsRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productsRepository.findById(id);
    }
}

