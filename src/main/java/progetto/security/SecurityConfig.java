package progetto.security;




//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import progetto.service.ResponsabileUserDetailsService;


@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    

	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	return new BCryptPasswordEncoder(); }
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new ResponsabileUserDetailsService();
	}
	
    
   
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(bCryptPasswordEncoder());
	}
    
    @Override
    public void configure(WebSecurity web) {
    web .ignoring()
    .antMatchers("/static/**", "/css/**", "/images/**", "/js/**", "/vendor/**"); }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	http .csrf().disable()
    	.authorizeRequests()
    	.antMatchers("/login").permitAll() 
    	.antMatchers("/direttore/**").hasRole("DIRETTORE") 
    	.antMatchers("/responsabile/**").hasRole("RESPONSABILE")  
    	.and()
    	.formLogin()
    	.loginPage("/login")
    	.and()
    	.logout()
    	.logoutSuccessUrl("/login").permitAll()
    	.and()
	    .csrf().disable();
    	
    	
    	
    } 
}