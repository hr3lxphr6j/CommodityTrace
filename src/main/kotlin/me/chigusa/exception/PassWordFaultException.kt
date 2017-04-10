package me.chigusa.exception

/**
 * @author Chigusa
 * @function
 * @date 2017/3/14
 */
class PassWordFaultException : CommonException {
    val PASSWORD_FAULT_EXCEPTION_CODE: Int = 10
    val PASSWORD_FAULT_EXCEPTION_Message: String = "密码错误"

    constructor()
}