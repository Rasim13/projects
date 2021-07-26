package ru.itits.site.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itits.site.models.Account;

import java.util.Collection;
import java.util.Collections;

public class AccountUserDetails implements UserDetails {

    private Account account;

    public AccountUserDetails(Account account) {
        this.account = account;
    }

    // данный метод говорит какие права есть у пользователя
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(account.getRole().name());
        return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return account.getHashPassword();
    }

    @Override
    public String getUsername() {
        return account.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !account.getState().equals(Account.State.BANNED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // когда state подвержден, тогда аккаунт confirmed
    @Override
    public boolean isEnabled() {
        return account.getState().equals(Account.State.CONFIRMED);
    }
}
