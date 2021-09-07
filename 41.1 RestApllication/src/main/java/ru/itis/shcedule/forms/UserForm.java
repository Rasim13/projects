package ru.itis.shcedule.forms;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Форма пользователя")
@Data
public class UserForm {

    @ApiModelProperty(value = "Email пользователя")
    private String email;
    @ApiModelProperty(value = "Имя пользователя")
    private String name;
    @ApiModelProperty(value = "пароль пользователя")
    private String hashPassword;

}
