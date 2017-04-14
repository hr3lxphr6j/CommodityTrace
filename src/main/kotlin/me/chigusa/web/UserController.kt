package me.chigusa.web

import me.chigusa.dao.RoleRepository
import me.chigusa.entity.Role
import me.chigusa.entity.User
import me.chigusa.services.UserService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

/**
 * @author Chigusa
 * @function User Controller
 * @date 2017/4/13
 */
@RestController
@RequestMapping("user")
class UserController {


    @Autowired
    val userService: UserService? = null
    @Autowired
    val roleRepository: RoleRepository? = null

    /**
     * 增加用户
     */
    @PostMapping()
    fun addUser(@Valid @RequestBody user: User, bindingResult: BindingResult) {
        user.roles = ArrayList<Role>().apply { add(roleRepository!!.findOne(1)) }
        userService!!.addUser(user)
    }

    /**
     * 获得所有用户
     * 需要 ADMIN 权限
     */
    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    fun getUsers(): ResponseEntity<List<UserDetails>> {
        return ResponseEntity(userService!!.loadUsers(), HttpStatus.OK)
    }

    /**
     * 根据ID查询用户
     * 需要 ADMIN 权限 或 通过HttpBasic验证
     */
    @GetMapping("{id}")
    @PreAuthorize("hasRole('ADMIN') or #id == principal.id")
    fun getUser(@PathVariable id: Long): ResponseEntity<UserDetails> {
        return ResponseEntity(userService!!.loadUserById(id), HttpStatus.OK)
    }

    /**
     * 根据ID更新用户信息
     * 需要 ADMIN 权限 或为当前用户
     */
    @PatchMapping("{id}")
    @PreAuthorize("hasRole('ADMIN') or #id == principal.id")
    fun patchUserById(@PathVariable id: Long, @Valid @RequestBody user: User) {
        userService!!.patchUser(user)
    }

    /**
     * 根据ID删除用户信息
     * 需要 ADMIN 权限 或为当前用户
     */
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN') or #id == principal.id")
    fun delUserById(@PathVariable id: Long) {
        userService!!.delUser(id)
    }

    /**
     * 异常处理
     * 返回 404
     */
    @ExceptionHandler()
    fun exceptionHandler(e: Exception): ResponseEntity<String?> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND)
    }
}