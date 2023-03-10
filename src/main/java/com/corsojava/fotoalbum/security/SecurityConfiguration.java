package com.corsojava.fotoalbum.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()

				.requestMatchers("/foto/create", "/foto/edit/**").hasAuthority("ADMIN") // per creare o modificare una
																						// pizza bisogna essere
																						// ADMIN
				.requestMatchers(HttpMethod.POST, "/foto/**").hasAuthority("ADMIN") // per fare il POST su /pizze
																					// (richiesto per eliminare una
																					// pizza) bisogna essere ADMIN
				.requestMatchers("/commenti", "/commenti/**").hasAuthority("ADMIN") // per accedere agli
																					// ingredienti bisogna
																					// essere ADMIN
				.requestMatchers("/categorie", "/categorie/**").hasAuthority("ADMIN") // per accedere alle offerte
																						// bisogna
																						// essere ADMIN
				.requestMatchers("/foto", "/foto/**").hasAnyAuthority("USER", "ADMIN") // per accedere all'elenco
																						// delle pizze (/pizze) o
																						// dettaglio pizza
																						// (/pizze/**) bisogna esser
																						// USER o ADMIN
				.requestMatchers("/**").permitAll() // chiunque può accedere alla Home
				.and().formLogin() // abilita il supporto al form login (auto generato)
				.loginPage("/login").permitAll().and().logout() // abilita il supporto al form logout (auto generato)
				.and().csrf().disable();
		// .and().exceptionHandling().accessDeniedPage("/access-denied.html"); // pagina
		// personalizzata in caso di
		// accesso negato

		return http.build();
	}

	@Bean
	DatabaseUserDetailsService userDetailsService() {
		return new DatabaseUserDetailsService();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		System.out.println("USER: " + passwordEncoder().encode("user"));
		System.out.println("ADMIN: " + passwordEncoder().encode("admin"));

		return authProvider;
	}
	
	

}
