package ru.itits.site.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itits.site.dto.ProductDto;

import javax.persistence.*;
import java.util.Optional;

public class Items {

    private Product product = new Product();

    private Integer quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Items(Product product, Integer quantity) {
        super();
        this.product = product;
        this.quantity = quantity;
    }

    public Items() {
        super();
    }
}
