package me.chigusa.web

import me.chigusa.entity.User
import me.chigusa.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * @author Chigusa
 * @function
 * @date 2017/3/15
 */
@RestController
class Test {
    @Autowired
    var userService: UserService? = null

    @GetMapping("producer/123")
    fun test(): String {
        return "hello"
    }

    @GetMapping("/123/{name}")
    fun test2(@PathVariable() name: String): ResponseEntity<UserDetails> {
        var user = userService!!.loadUserByUsername(name)
        return ResponseEntity(user, HttpStatus.OK)
    }

    @GetMapping("tool/pwdEnc/{pwd}")
    fun encPwd(@PathVariable pwd: String): ResponseEntity<String> {
        return ResponseEntity(BCryptPasswordEncoder().encode(pwd), HttpStatus.OK)
    }

}