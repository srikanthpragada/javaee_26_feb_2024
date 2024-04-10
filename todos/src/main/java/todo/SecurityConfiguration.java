package todo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public UserDetailsService userService(UserRepo repo) {
		return username -> {
			var userOpt = repo.findById(username);
			if (userOpt.isEmpty())
				 throw new UsernameNotFoundException("Username is invalid!");

			return userOpt.get().asUser(); // return UserDetails 
		};
	}

	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf( c -> c.disable());
		http.authorizeHttpRequests( request -> 
		           request.requestMatchers("/register","/login","/view/**").permitAll()
		                  .anyRequest().authenticated())
		    .formLogin( form -> form.loginPage("/login").permitAll()
		    		                 .defaultSuccessUrl("/home"))
		    
		    .logout( logout -> logout.permitAll());
		    		            

		return http.build();

	}

}
