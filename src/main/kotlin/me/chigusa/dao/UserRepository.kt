package me.chigusa.dao

import me.chigusa.entity.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author Chigusa
 * @function
 * @date 2017/4/6
 */
interface UserRepository : JpaRepository<User, Long> {
    fun findByUserName(userName: String?): User
}