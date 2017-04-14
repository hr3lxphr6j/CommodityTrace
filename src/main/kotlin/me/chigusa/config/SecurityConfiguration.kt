package me.chigusa.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import me.chigusa.services.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


/**
 * @author chigusa
 * @function 配置Spring Security
 * @date 2017/4/12
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, proxyTargetClass = true)
class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    @Autowired
    var userService: UserService? = null

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider {
        val authenticationProvider = DaoAuthenticationProvider()
        authenticationProvider.setUserDetailsService(userService)
        authenticationProvider.setPasswordEncoder(passwordEncoder())
        return authenticationProvider
    }

    /**
     * 配置自定义UserService和密码加密方式
     */
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.userDetailsService(userService)
        auth.authenticationProvider(authenticationProvider())
    }


    override fun configure(http: HttpSecurity?) {
        http!!
                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/producer/**").hasAnyRole("PRODUCER", "ADMIN")
                .httpBasic()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }
}