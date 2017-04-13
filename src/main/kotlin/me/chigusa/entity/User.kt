package me.chigusa.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull


/**
 * @author Chigusa
 * @function 用户实体
 * @date 2017/4/1
 */
@Entity
data class User(
        /**
         * 用户ID，自增主键，不可为空，唯一
         */
        @Id @GeneratedValue @Column(nullable = false, unique = true)
        var id: Long? = -1,

        /**
         * 用户名，唯一，非空
         */
        @Column(nullable = false, unique = true) @NotNull
        var name: String? = "",

        /**
         * 密码，非空，最低6位
         */
        @Column(nullable = false) @Min(6) @JsonIgnore
        var pwd: String? = "",
        /**
         * 联系电话
         */
        var phoneNum: String? = "",

        /**
         * 邮箱
         */
        var eMail: String? = "",
        /**
         * 用户角色
         */
        @ManyToMany(cascade = arrayOf(CascadeType.REFRESH), fetch = FetchType.EAGER)
        var roles: List<Role>? = null

) : UserDetails {
    override fun getUsername(): String {
        return name!!
    }

    override fun getPassword(): String {
        return pwd!!
    }

    /**
     * 重写 getAuthorities 方法，将用户角色作为权限
     */
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return roles!!.mapTo(ArrayList<GrantedAuthority>()) { SimpleGrantedAuthority(it.name) }
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }


    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}