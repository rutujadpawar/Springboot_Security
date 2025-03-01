package com.rutuja.Security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
	{
		return httpSecurity.authorizeHttpRequests(resistry->{
			resistry.requestMatchers("/security/public").permitAll();
			resistry.requestMatchers("/security/admin").hasRole("admin");
			resistry.requestMatchers("/security/user").hasRole("user");
		}).formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetails userDetails1=User.builder().username("Rutuja").password(passwordEncoder().encode("Rutuja@123")).roles("admin").build();
		UserDetails userDetails2=User.builder().username("Omkar").password(passwordEncoder().encode("Omkar@123")).roles("user").build();
		return new InMemoryUserDetailsManager(userDetails1,userDetails2);
	}

}
