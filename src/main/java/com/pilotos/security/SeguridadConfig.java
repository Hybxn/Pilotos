package com.pilotos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SeguridadConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl udsi;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(udsi).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/webjars/**", "/css/**", "/h2-console/**", "/public/**", "/auth/**", "/files/**")
				.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/auth/login").permitAll()
				.defaultSuccessUrl("/monoplazas", true).loginProcessingUrl("/auth/login-post")
				.failureUrl("/auth/login?error=true").usernameParameter("username").passwordParameter("password").permitAll()
				.and().logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");

		http.csrf().disable();
		http.headers().frameOptions().disable();
	}

}
