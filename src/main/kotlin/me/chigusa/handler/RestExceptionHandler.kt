package me.chigusa.handler

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

/**
 * @author Chigusa
 * @function 异常处理器。该类会处理所有在执行标有@RequestMapping注解的方法时发生的异常
 * @date 2017/4/13
 */
@ControllerAdvice
class RestExceptionHandler: ResponseEntityExceptionHandler() {
    override fun handleExceptionInternal(ex: Exception?, body: Any?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleExceptionInternal(ex, body, headers, status, request)
    }
}