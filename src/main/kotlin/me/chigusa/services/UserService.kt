package me.chigusa.services

import me.chigusa.dao.UserRepository
import me.chigusa.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * @author Chigusa
 * @function
 * @date 2017/4/1
 */
@Service
class UserService : UserDetailsService {

    @Autowired
    var userRepository: UserRepository? = null

    override fun loadUserByUsername(username: String?): UserDetails {
        var user = userRepository!!.findByName(username)
        if (user == null || user.id == -1L) {
            throw UsernameNotFoundException(String.format("用户名：%s，无法被找到 ", username))
        } else {
            return user
        }
    }
}