package me.chigusa.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @author Chigusa
 * @function 用户角色
 * @date 2017/4/10
 */
@Entity
data class Role(
        @Id @GeneratedValue
        var id: Long? = -1,
        var name: String? = ""
) {
}