package me.chigusa.handle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author Chigusa
 * @function 全局异常处理
 * @date 2017/3/15
 */
class ExceptionHandle : HandlerExceptionResolver {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)
    override fun resolveException(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, ex: Exception?): ModelAndView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}