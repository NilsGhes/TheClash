package net.nilsghesquiere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SpringSecurityWebAppConfig extends WebSecurityConfigurerAdapter {
	private static final String USER ="user";
	private static final String JHADMIN ="jhadmin";
	private static final String APPADMIN ="appadmin";
	
	@Override
	@Autowired
	public void configure(AuthenticationManagerBuilder auth)
	throws Exception {
	auth.inMemoryAuthentication() 
	.withUser("nils").password("test123").authorities(JHADMIN,APPADMIN)
	.and().withUser("lukas").password("test123").authorities(JHADMIN)
	.authorities(JHADMIN, APPADMIN);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception { 
	web.ignoring()
	.antMatchers("/images/**") 
	.antMatchers("/styles/**")
	.antMatchers("/scripts/**")
	.antMatchers("/webjars/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
        .loginPage("/login.html")
        .failureUrl("/login-error.html")
        .and()
        .logout()
        .logoutSuccessUrl("/index.html")
        .and()
        .authorizeRequests().antMatchers("/admin/**").hasAuthority(APPADMIN)
        .antMatchers(HttpMethod.POST, "/").hasAuthority(JHADMIN)
        .antMatchers("/").permitAll()
        .antMatchers("/**").authenticated();

        
       //H2 console
		http.csrf().disable();
        http.headers().frameOptions().disable();
	}
}