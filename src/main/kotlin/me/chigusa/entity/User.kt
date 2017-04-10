package me.chigusa.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotNull


/**
 * @author Chigusa
 * @function
 * @date 2017/4/1
 */
data class User(
        @Id @GeneratedValue @Column(nullable = true, unique = true)
        var id: Long = -1,
        @Column(nullable = true) @NotNull
        var userName: String,
        var passWord: String

) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isEnabled(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUsername(): String {
        return userName
    }

    override fun isCredentialsNonExpired(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPassword(): String {
        return passWord
    }

    override fun isAccountNonExpired(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isAccountNonLocked(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}