package me.chigusa.config

import me.chigusa.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
 * @author Chigusa
 * @function 配置Spring Security
 * @date 2017/4/1
 */
@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    var userService: UserService? = null

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.userDetailsService(userService)
    }

    override fun configure(web: WebSecurity?) {
        super.configure(web)
    }

    /**
     * 权限配置
     */
    override fun configure(http: HttpSecurity?) {
        http!!.authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and().exceptionHandling()
    }
}