package ru.itis.manageUsers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Вспомогательный класс, для передачи токена между подсистемами
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {

    /**
     * Поле значение токена
     */
    private String value;
}
