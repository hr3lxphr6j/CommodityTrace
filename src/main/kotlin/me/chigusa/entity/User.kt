package me.chigusa.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Size


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
        @Column(nullable = false, unique = true) @NotEmpty(message = "用户名不能为空")
        var name: String? = "",

        /**
         * 密码，非空，最低6位
         */
        @Column(nullable = false) @Size(min = 6, max = 24, message = "密码必须在6-24位") @JsonIgnore
        var pwd: String? = "",
        /**
         * 联系电话
         */
        var phone: String? = "",

        /**
         * 邮箱
         */
        @Email(message = "邮箱格式不正确")
        var email: String? = "",
        /**
         * 用户角色
         */
        @ManyToMany(cascade = arrayOf(CascadeType.REFRESH), fetch = FetchType.EAGER) @JsonIgnore
        var roles: List<Role>? = null


) : UserDetails, Serializable {
    @JsonIgnore
    override fun getUsername(): String {
        return name!!
    }

    @JsonIgnore
    override fun getPassword(): String {
        return pwd!!
    }

    /**
     * 重写 getAuthorities 方法，将用户角色作为权限
     */
    @JsonIgnore
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return roles!!.mapTo(ArrayList<GrantedAuthority>()) { SimpleGrantedAuthority(it.name) }
    }

    @JsonIgnore
    override fun isEnabled(): Boolean {
        return true
    }

    @JsonIgnore
    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    @JsonIgnore
    override fun isAccountNonExpired(): Boolean {
        return true
    }

    @JsonIgnore
    override fun isAccountNonLocked(): Boolean {
        return true
    }
}