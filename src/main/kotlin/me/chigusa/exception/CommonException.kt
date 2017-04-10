package me.chigusa.exception

/**
 * @author Chigusa
 * @function 公共异常
 * @date 2017/3/14
 */
class CommomException : RuntimeException() {
    val OTHER_EXCEPTION_CODE: Int = -1
    val OTHER_EXCEPTION_MESSAGE: String = "Other Error"

    var eCode: Int = OTHER_EXCEPTION_CODE
    var eMessage: String = OTHER_EXCEPTION_MESSAGE


}