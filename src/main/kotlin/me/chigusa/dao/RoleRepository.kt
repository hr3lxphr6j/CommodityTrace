package me.chigusa.dao

import me.chigusa.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author Chigusa
 * @function
 * @date 2017/4/14
 */
interface RoleRepository : JpaRepository<Role, Long> {
}