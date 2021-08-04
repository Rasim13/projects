package ru.itits.site.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itits.site.models.Product;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String name;

    private Integer price;

    public static ProductDto from(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public static List<ProductDto> from(List<Product> products) {
        return products.stream().map(ProductDto::from).collect(Collectors.toList());
    }
}
