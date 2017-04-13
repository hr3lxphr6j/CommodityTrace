package me.chigusa.exception.user

/**
 * @author Chigusa
 * @function 自定异常类，用户ID不存在
 * @date 2017/4/12
 */
class UserIdNotFoundException : RuntimeException {
    constructor(id: Long) : super(String.format("用户Id：%d，无法被找到 ", id))
}