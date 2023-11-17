package com.innova.spring.advancedspring.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final BCryptPasswordEncoder passwordEncoder;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurityParam,
                                                       MyUserDetailService userDetailServiceParam) throws Exception {
        return httpSecurityParam.getSharedObject(AuthenticationManagerBuilder.class)
                                .userDetailsService(userDetailServiceParam)
                                .passwordEncoder(passwordEncoder)
                                .and()
                                .build();
    }

    @Bean
    public JWTFilter jwtFilter() {
        return new JWTFilter();
    }

    @Bean
    public SecurityFilterChain configureSec(HttpSecurity httpSecurityParam) throws Exception {
        return httpSecurityParam.authorizeRequests()
//                                .antMatchers("/hello/**")
//                                .anonymous()
//                                .antMatchers("/actuator/**")
//                                .hasAnyRole("ADMIN")
                                .antMatchers("/sec/v1/security/login",
                                             "/sec/v1/user/**",
                                             "/actuator/**",
                                             "/counter/**",
                                             "/h2-console/**")
                                .anonymous()
                                .antMatchers("/api/**")
                                .hasAnyRole("USER",
                                            "ADMIN",
                                            "XYZ")
                                .anyRequest()
                                .authenticated()
                                .and()
                                .httpBasic()
                                .and()
                                .cors()
                                .disable()
                                .csrf()
                                .disable()
                                .addFilterBefore(jwtFilter(),
                                                 UsernamePasswordAuthenticationFilter.class)
                                .sessionManagement()
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                                .and()
                                .headers()
                                .frameOptions()
                                .disable()
                                .and()
                                .build();
    }

    @Bean
    public JWTService jwtService() {
        return new JWTService();
    }

}
