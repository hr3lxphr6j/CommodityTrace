package me.chigusa.entity


/**
 * @author Chigusa
 * @function 返回对象
 * @date 2017/3/14
 */
data class Result<T>(
        var eCode: Int,
        var eMessage: String? = null,
        var data: T? = null
) {
}