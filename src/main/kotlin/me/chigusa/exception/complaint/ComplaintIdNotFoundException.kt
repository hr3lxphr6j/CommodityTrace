package me.chigusa.exception.complaint

/**
 * @author Chigusa
 * @function
 * @date 2017/4/12
 */
class ComplaintIdNotFoundException:RuntimeException {
    constructor(id: Long) : super(String.format("投诉Id：%d，无法被找到 ", id))
}