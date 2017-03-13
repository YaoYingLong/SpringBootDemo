package com.nokia.example.config;

import com.nokia.example.security.CustomPasswordEncoder;
import com.nokia.example.security.CustomUserDetailsService;
import com.nokia.example.security.CustomizeAuthCodeService;
import com.nokia.example.security.CustomizePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomizeAuthCodeService authCodeService;

    @Autowired
    private CustomUserDetailsService detailsService;

    @Autowired
    private CustomPasswordEncoder passwordEncoder;

    @Autowired
    private CustomizePermission customizePermission;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/AuthCode").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/static/resource").permitAll()
                .antMatchers("/static/resource/**").permitAll()
                .anyRequest().authenticated()
                .antMatchers("/**").fullyAuthenticated()
                .and()
                .formLogin().loginPage("/login")
                    .defaultSuccessUrl("/index")
                    .failureUrl("/login?error")
                /*.usernameParameter("username").passwordParameter("password")*/
                .and()
                /*.rememberMe().tokenValiditySeconds(1209600).key("myKey")
                .and()*/
                .logout().logoutUrl("/logout")/*.logoutSuccessUrl("")*/
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(authCodeService);
    }

    /*@Autowired
    protected void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        //CustomUserDetailsService detailsService = appContext.getBean("userDetailsService" , CustomUserDetailsService.class);
        auth
                .userDetailsService(detailsService).passwordEncoder(passwordEncoder);
    }*/
}
