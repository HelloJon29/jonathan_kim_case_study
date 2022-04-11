package com.jonathankim.monster_factory.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        // the order of matchers is important, have the most generic at the top
        http.authorizeRequests()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/deleteMonster/**").hasAnyRole("SUPERADMIN")
                .mvcMatchers("/showFormForUpdate/**").hasAnyRole("ADMIN", "SUPERADMIN")
                .mvcMatchers("/showNewMonsterForm/**").hasAnyRole("ADMIN", "SUPERADMIN")
                .mvcMatchers("/saveMonster/**").hasAnyRole("ADMIN", "SUPERADMIN")
                .mvcMatchers("/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        // @formatter:on
    }

    // specify how to save users, currently using in memory database that auto gens tables
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder.encode("user")).roles("USER").and()
                .withUser("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN").and()
                .withUser("superadmin").password(passwordEncoder.encode("superadmin")).roles("USER", "ADMIN", "SUPERADMIN");

    }


}
