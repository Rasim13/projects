package ru.itis.site.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.site.validation.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpForm {

    @Size(min = 4, max = 20, message = "{error.firstName.size}")
    private String firstName;

    @Size(min = 4, max = 20, message = "{error.lastName.size}")
    private String lastName;

    @Email(message = "{error.email.format}")
    private String email;

    @ValidPassword (message = "{error.password.format}")
    @NotEmpty(message = "{error.password.empty}")
    private String password;
}
