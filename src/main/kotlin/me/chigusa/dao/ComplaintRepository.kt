package me.chigusa.dao

import me.chigusa.entity.Complaint
import me.chigusa.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author Chigusa
 * @function 投诉数据访问接口
 * @date 2017/3/14
 */
interface ComplaintRepository : JpaRepository<Complaint, Long> {
    fun findByProduct(product: Product): List<Complaint>
}