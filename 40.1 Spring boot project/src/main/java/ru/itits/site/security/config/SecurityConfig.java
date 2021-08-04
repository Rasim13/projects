package ru.itits.site.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
        http.csrf().disable();

        http.authorizeRequests()
                // доступ для всех пользователей
                .antMatchers("/", "/shop/**","/addToCart/**","/signIn","/signUp").permitAll()
                //доступ для аутентифицированных пользователей
                .antMatchers("/shop/**").authenticated()
                //доступ для пользователей с ролью ADMIN
                .antMatchers( "/admin", "/admin/**").hasAuthority("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/signIn")
                .permitAll()
                .failureUrl("/signIn?error=true")
                .defaultSuccessUrl("/shop")
                .usernameParameter("email")
                .passwordParameter("password");
    }
}
