package com.josecarlos.springsecurityfilters.config;

import com.josecarlos.springsecurityfilters.filters.AuthenticationLoggingFilter;
import com.josecarlos.springsecurityfilters.filters.RequestValidationFilter;
import com.josecarlos.springsecurityfilters.filters.StaticKeyAuthenticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    private final StaticKeyAuthenticationFilter staticKeyAuthenticationFilter;

    public SpringSecurity(StaticKeyAuthenticationFilter staticKeyAuthenticationFilter) {
        this.staticKeyAuthenticationFilter = staticKeyAuthenticationFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .addFilterBefore(
//                        new RequestValidationFilter(),
//                        BasicAuthenticationFilter.class
//                ).addFilterAfter(
//                        new AuthenticationLoggingFilter(),
//                        BasicAuthenticationFilter.class
//                )
//                .authorizeRequests()
//                .anyRequest().permitAll();

        http.addFilterAt(staticKeyAuthenticationFilter,
                BasicAuthenticationFilter.class)
                .authorizeRequests()
                .anyRequest().permitAll();
    }
}
