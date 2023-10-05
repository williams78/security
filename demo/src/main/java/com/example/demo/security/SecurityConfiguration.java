package com.example.demo.security;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

		
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
		
        .authorizeHttpRequests((authz) -> authz
            .requestMatchers("/public/**").permitAll()
            .requestMatchers("/private/**").authenticated()
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated()
        );
		
		http.httpBasic(withDefaults());
		http.formLogin(withDefaults());
		http.logout(logout -> {
			try {
				logout                                                
		            .logoutUrl("/logout").permitAll()                                            
		            .logoutSuccessUrl("/public")                                      
		            .invalidateHttpSession(true)                                        
		            .deleteCookies("JSESSIONID");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
    return http.build();
									
		
		
		
	}
	
}
