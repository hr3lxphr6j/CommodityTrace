package me.chigusa.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.awt.font.ShapeGraphicAttribute
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull


/**
 * @author Chigusa
 * @function 用户
 * @date 2017/4/1
 */
@Entity
data class User(
        @Id @GeneratedValue @Column(nullable = true, unique = true)
        var id: Long? = -1,
        @Column(nullable = true) @NotNull
        var name: String? = "",
        var pwd: String? = "",
        @ManyToMany(cascade = arrayOf(CascadeType.REFRESH), fetch = FetchType.EAGER)
        var roles: List<Role>? = null

) : UserDetails {
    override fun getUsername(): String {
        return name!!
    }

    override fun getPassword(): String {
        return pwd!!
    }

    // 重写 getAuthorities 方法，将用户角色作为权限
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