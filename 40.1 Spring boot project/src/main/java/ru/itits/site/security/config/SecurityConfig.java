package ru.itits.site.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier(value = "accountUserDetailsService")
    private UserDetailsService userDetailsService;

    // говорим спрингу, чтобы он использовал наш userDetailsService и шифрования пароли
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//
//        http.authorizeRequests()
//                // доступ для всех пользователей
//                .antMatchers("/").permitAll()
//                //доступ для аутентифицированных пользователей
//                .antMatchers("/store/**").authenticated()
//                //доступ для пользователей с ролью ADMIN
//                .antMatchers( "/admin", "/admin/**").hasAnyRole("ADMIN", "USER")
//                .and()
//                .formLogin()
//                .loginPage("/signIn")
//                // spring из view вытаскивает email для проверки
//                .usernameParameter("email")
//                // spring из view вытаскивает password для проверки
//                .passwordParameter("password")
//                //на этот url имеют доступ только те пользователи, которые правильно ввели пароль и email
//                .defaultSuccessUrl("/store")
//                //если пользователь  ввел неправильный пароль и email
//                .failureUrl("/signIn?error")
//                .permitAll();
    }
}
