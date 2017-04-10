package me.chigusa.services

import me.chigusa.dao.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

/**
 * @author Chigusa
 * @function
 * @date 2017/4/1
 */
class UserService : UserDetailsService {

    @Autowired
    var userRepository: UserRepository? = null

    override fun loadUserByUsername(username: String?): UserDetails {
        var user = userRepository!!.findByUserName(username)
        if (user == null || user.id == -1L) {
            throw UsernameNotFoundException(String.format("用户名：%s，无法被找到 ", username))
        } else {
            return user
        }
    }
}