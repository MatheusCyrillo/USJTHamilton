package br.usjt.hamilton.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("application").password("mooSe2oesus2aera").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Ant matchers e para falar para o spring configurar autenticacao somente se
		// der match nessa requisicao
		http.csrf().disable().
		authorizeRequests().
		anyRequest().authenticated().and().httpBasic().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// nao quero que codifique ou criiptografe a minha senha
		return NoOpPasswordEncoder.getInstance();
	}
}
