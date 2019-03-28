package com.processexcel.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class UsersSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Value("${spring.queries.users-query}")
    private String userQuery;

    @Value("${spring.queries.roles-query}")
    private String roleQuery;


    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(userQuery)
                .authoritiesByUsernameQuery(roleQuery);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/home").hasAnyRole("ROLE_USER", "ROLE_ADMIN")
                .antMatchers("/addExcel").hasAnyRole("ROLE_USER", "ROLE_ADMIN").antMatchers("/addUser")
                .hasAnyRole("ROLE_ADMIN").anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll();

        http.csrf().disable();

        // /**/*.js","/**/*.css
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/**/*.js","/**/*.css","/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}
