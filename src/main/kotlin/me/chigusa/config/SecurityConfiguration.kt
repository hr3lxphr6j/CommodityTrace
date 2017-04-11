package me.chigusa.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import me.chigusa.security.CustomAuthenticationEntryPoint
import me.chigusa.services.UserService
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy


/**
 * @author chigusa
 */
@Configuration
@EnableWebSecurity
class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    private val REALM = "MY_TEST_REALM"
    @Autowired
    var authenticationEntryPoint: CustomAuthenticationEntryPoint? = null

    @Autowired
    var userService: UserService? = null

    override fun configure(auth: AuthenticationManagerBuilder?) {
//        auth!!.userDetailsService(userService)
        auth!!.inMemoryAuthentication()
                .withUser("user").password("user")
                .authorities("ADMIN")
    }

    override fun configure(web: WebSecurity?) {
        web!!.ignoring().antMatchers(HttpMethod.OPTIONS, "/**")
    }


    override fun configure(http: HttpSecurity?) {
        http!!
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**").hasRole("ADMIN")
                .and().httpBasic()
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)


    }
}