package me.chigusa.dao

import me.chigusa.entity.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author Chigusa
 * @function 用户数据访问接口
 * @date 2017/4/6
 */
interface UserRepository : JpaRepository<User, Long> {
    fun findByName(userName: String?): User?
}