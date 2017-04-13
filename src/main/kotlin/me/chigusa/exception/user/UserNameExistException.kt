package me.chigusa.exception.user

/**
 * @author Chigusa
 * @function 自定异常类，用户名已存在
 * @date 2017/4/12
 */
class UserNameExistException : RuntimeException {
    constructor(username: String) : super(String.format("用户名：%s，已存在 ", username))
}