package me.chigusa.security

import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author chigusa
 */
@Component
class CustomAuthenticationEntryPoint : BasicAuthenticationEntryPoint() {
    override fun afterPropertiesSet() {
        realmName = "Baeldung"
        super.afterPropertiesSet()
    }

    override fun commence(request: HttpServletRequest?, response: HttpServletResponse?, authException: AuthenticationException?) {
        response!!.addHeader("WWW-Authenticate", String.format("Basic realm=\"%s\"", realmName))
        response.status = HttpServletResponse.SC_UNAUTHORIZED
        var writer = response.writer
        writer.println("HTTP Status 401 - " + authException!!.message)
    }
}