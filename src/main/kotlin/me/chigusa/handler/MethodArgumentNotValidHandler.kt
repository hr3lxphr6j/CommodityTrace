package me.chigusa.handler

import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * @author Chigusa
 * @function MethodArgumentNotValidException 异常统一处理
 * @date 2017/4/15
 */
@ControllerAdvice
class MethodArgumentNotValidHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun processValidationError(exception: MethodArgumentNotValidException): String {
        return exception.bindingResult.allErrors.toString()
    }
}