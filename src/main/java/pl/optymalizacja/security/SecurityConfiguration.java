package pl.optymalizacja.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
	//nieuwierzytelnione dla poniższych
		.antMatchers("/").permitAll()
		.antMatchers("/about").permitAll()
		.antMatchers("/success").permitAll()
		.antMatchers("/registerForm").permitAll()
		.antMatchers("/saveRegister").permitAll()
		.antMatchers("/errorPage").permitAll()
		.antMatchers("/articles").permitAll()
		.antMatchers("/ankieta").permitAll()
		.antMatchers("/add").permitAll()
		//uwierzytelnianie dla każdego innego adresu
		.anyRequest().authenticated()
	.and()
		.formLogin()
		.loginPage("/loginForm").permitAll()
		.loginProcessingUrl("/processlogin").permitAll()
	.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
	

	}
}