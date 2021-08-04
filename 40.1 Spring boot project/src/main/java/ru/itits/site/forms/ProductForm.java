package ru.itits.site.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductForm {
    private String name;

    @Positive(message = "{error.price.negative}")
    private Integer price;
}
