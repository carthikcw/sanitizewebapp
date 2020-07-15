package com.cutomer.sanitize.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*@Configuration*/
@EnableWebSecurity
@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{ 

 	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }
	/* @Autowired
	private DataSource dataSource;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	} */

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {*/
		/*auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
				.usersByUsernameQuery("SELECT username, password, enabled from users where username = ?")
				.authoritiesByUsernameQuery("SELECT u.username, a.authority " + "FROM user_authorities a, users u "
						+ "WHERE u.username = ? " + "AND u.id = a.user_id");*/
	/* } */
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {*/

		/*
		 * http.authorizeRequests().antMatchers("/getRequests").hasAnyRole("ADMIN").
		 * antMatchers("/requestWash") .hasAnyRole("ADMIN", "USER",
		 * "VENDOR").antMatchers("/register").permitAll().and().formLogin();
		 */
	/*
	 * http.authorizeRequests().antMatchers("/").hasRole("manager").and().
	 * formLogin();
	 */
		 
		/*
		 * http .cors().and() .csrf().disable().authorizeRequests()
		 * .antMatchers("/register").anyRequest().authenticated()
		 * .and();
		 */
	/* } */
	

}
