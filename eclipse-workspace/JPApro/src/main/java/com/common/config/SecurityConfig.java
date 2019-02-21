package com.common.config;

import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/**")
//                .authorizeRequests()
//                .antMatchers("/", "/h2-console/**", "/favicon.ico").permitAll()
//                .anyRequest().authenticated()
//                .and().logout().logoutSuccessUrl("/").permitAll()
//                .and().headers().frameOptions().sameOrigin()
//                .and().csrf().disable();
//    }
//}