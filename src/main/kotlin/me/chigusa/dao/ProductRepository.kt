package me.chigusa.dao

import me.chigusa.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author Chigusa
 * @function 产品数据访问接口
 * @date 2017/3/14
 */
interface ProductRepository : JpaRepository<Product, Long> {
}