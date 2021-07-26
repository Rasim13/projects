package ru.itits.site.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itits.site.models.Account;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String hashPassword;
    private Account.Role role;

    public static AccountDto from(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .email(account.getEmail())
                .hashPassword(account.getHashPassword())
                .role(account.getRole())
                .build();
    }

    public static List<AccountDto> from(List<Account> accounts) {
        return accounts.stream().map(AccountDto::from).collect(Collectors.toList());
    }
}
