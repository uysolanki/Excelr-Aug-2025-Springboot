package com.excelr.shopping.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfiguration {
//	  @Bean
//	    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	        http
//	            .csrf(csrf -> csrf.disable())
//	            .authorizeHttpRequests(auth -> auth
//	                .requestMatchers(
//	                    "/swagger-ui/**",
//	                    "/v3/api-docs/**"
//	                ).permitAll()
//	                .anyRequest().authenticated()
//	            )
//	            .httpBasic();
//
//	        return http.build();
//	    }
	  
	  @Bean
		public AuthenticationProvider myAuthenticationProvider() {
			DaoAuthenticationProvider daoProvider=new DaoAuthenticationProvider();
			daoProvider.setUserDetailsService(myUserDetailsService());
			daoProvider.setPasswordEncoder(myPasswordEncoder());
			return daoProvider;
		}

		@Bean
		public PasswordEncoder myPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}

		@Bean
		public UserDetailsService myUserDetailsService() {
			return new MySecurityUserDetailsService();
		}
		
		@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.authenticationProvider(myAuthenticationProvider());
	        
	        http.authorizeRequests()
	      .requestMatchers("/amazon/all-products","/amazon/add-product-form").hasAnyAuthority("USER","ADMIN")
	      .requestMatchers("/amazon/update-product-form/**","/amazon/delete-product/**").hasAuthority("ADMIN")
	      .anyRequest().authenticated()
	      .and()
	      .formLogin().loginProcessingUrl("/login").successForwardUrl("/amazon/all-products").permitAll()
	      .and()
	      .logout().logoutSuccessUrl("/login").permitAll()
	      .and()
	      .exceptionHandling().accessDeniedPage("/amazon/403")
	      .and()
	      .cors().and().csrf().disable();
	        
	        return http.build();
	    }
}
