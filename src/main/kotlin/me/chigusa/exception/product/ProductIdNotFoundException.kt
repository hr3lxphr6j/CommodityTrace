package me.chigusa.exception.product

/**
 * @author Chigusa
 * @function 自定异常类，产品ID不存在
 * @date 2017/4/12
 */
class ProductIdNotFoundException : RuntimeException {

    constructor(id: Long) : super(String.format("产品Id：%d，无法被找到 ", id))
}