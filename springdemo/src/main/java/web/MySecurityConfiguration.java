package web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
 
@Configuration
public class MySecurityConfiguration {

	@Bean public UserDetailsService users() {
	// The builder will ensure the passwords are encoded before
	// saving in memory
	UserBuilder	users = User.withDefaultPasswordEncoder();
	UserDetails	user = users.username("user").password("user").roles("USER").build();
	UserDetails	admin = users.username("admin").password("admin").roles("USER", "ADMIN").build();
	return new	InMemoryUserDetailsManager (user,admin);
	}

}
