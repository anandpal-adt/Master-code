package com.amazin.nayra.security;

//import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.AuthenticationEntryPoint;
//
//@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebSecurity
//public class AmazinSecurity extends WebSecurityConfigurerAdapter {
//	
//	
//	protected void configure(HttpSecurity http) throws Exception {
//		http.headers().frameOptions().deny().and().httpBasic().and().authorizeRequests().antMatchers("/*").hasRole("USER").antMatchers("/admin")
//				.hasRole("ADMIN").and().csrf().disable();
//		
//		System.out.println("=====================hello");
//	}
////	
////	@Autowired
////	private AuthenticationEntryPoint authEntryPoint;
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.csrf().disable().authorizeRequests()
////				.anyRequest().authenticated()
////				.and().httpBasic()
////				.authenticationEntryPoint(authEntryPoint);
////	}
//	
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("amazin").password(passwordEncoder().encode("abc123")).roles("USER").and()
//				.withUser("admin").password(passwordEncoder().encode("admin")).roles("USER", "ADMIN");
//		//System.out.println("=====================hi");
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AmazinSecurity  {

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails admin = User.withUsername("admin").password(encoder.encode("admin")).roles("ADMIN").build();
		UserDetails user = User.withUsername("user").password(encoder.encode("user")).roles("USER").build();
		return new InMemoryUserDetailsManager(admin, user);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeHttpRequests().antMatchers("/").permitAll().and()
				.authorizeHttpRequests().antMatchers("/di/save").authenticated().and().formLogin().and().build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.headers().frameOptions().deny().and().httpBasic().and().authorizeRequests().antMatchers("/*").hasRole("USER").antMatchers("/admin")
//				.hasRole("ADMIN").and().csrf().disable();
//	}
//
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("plms").password(passwordEncoder().encode("abc123")).roles("USER").and()
//				.withUser("admin").password(passwordEncoder().encode("admin")).roles("USER", "ADMIN");
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
}
