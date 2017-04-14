package me.chigusa.services

import me.chigusa.dao.UserRepository
import me.chigusa.entity.User
import me.chigusa.exception.user.UserIdNotFoundException
import me.chigusa.exception.user.UserNameExistException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @author Chigusa
 * @function 用户服务
 * @date 2017/4/1
 */
@Service
@Transactional
class UserService : UserDetailsService {

    @Autowired
    var userRepository: UserRepository? = null
    @Autowired
    private val passwordEncoder: PasswordEncoder? = null

    /**
     * 根据用户名查询用户
     */
    override fun loadUserByUsername(username: String?): UserDetails {
        var user = userRepository!!.findByName(username)
        if (user == null || user.id == -1L) {
            throw UsernameNotFoundException(String.format("用户名：%s，无法被找到 ", username))
        } else {
            return user
        }
    }

    /**
     * 根据id查询是否存在
     */
    private fun exist(id: Long) {
        if (!userRepository!!.exists(id)) {
            throw UserIdNotFoundException(id)
        }
    }

    /**
     * 增加用户
     */
    @CachePut(value = "user", key = "#user.id")
    fun addUser(user: User) {
        if (userRepository!!.findByName(user.name) != null) {
            throw UserNameExistException(user.name!!)
        }
        print(user.name)
        user.pwd = passwordEncoder!!.encode(user.pwd)
        userRepository!!.save(user)
    }

    /**
     * 根据id查询用户
     */
    @Cacheable(value = "user", key = "#id")
    fun loadUserById(id: Long): UserDetails {
        exist(id)
        return userRepository!!.findOne(id)
    }

    /**
     * 修改用户数据
     */
    @CachePut(value = "user", key = "#user.id")
    fun patchUser(user: User) {
        exist(user.id!!)
        userRepository!!.save(user)
    }

    /**
     * 删除用户
     */
    @CacheEvict(value = "user", key = "#id")
    fun delUser(id: Long) {
        exist(id)
        userRepository!!.delete(id)
    }

    /**
     * 返回所有用户
     */
    fun loadUsers(): List<UserDetails> {
        return userRepository!!.findAll()
    }
}


