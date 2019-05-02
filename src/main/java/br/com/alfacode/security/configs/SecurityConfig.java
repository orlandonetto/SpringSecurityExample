package br.com.alfacode.security.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UsuarioDetailService userDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// Para qualquer requisição (anyRequest) é preciso estar
				// autenticado (authenticated).
				.anyRequest().authenticated().and().httpBasic();
	}
	
	@Override
	  protected void configure(AuthenticationManagerBuilder builder) throws Exception {
	    builder.userDetailsService(userDetailService)
	    .passwordEncoder(new BCryptPasswordEncoder());
	  }
	
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("@LFACode5789"));
	}

}
