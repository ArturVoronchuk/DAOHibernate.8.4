package daohibernate.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityAuthorize extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Artur")
                .password(encoder().encode("Artur123!"))
                .roles("READ", "WRITE");
        auth.inMemoryAuthentication()
                .withUser("Marina")
                .password(encoder().encode("Marina!@3"))
                .roles("READ");
        auth.inMemoryAuthentication()
                .withUser("Sergey")
                .password(encoder().encode("SeRg!231!"))
                .roles("DELETE");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin().and()
                .authorizeRequests().antMatchers("/persons/by-city").permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/by-age").hasRole("WRITE")
                .and()
                .authorizeRequests().antMatchers("/persons/by-name").hasAnyRole("DELETE","WRITE")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}