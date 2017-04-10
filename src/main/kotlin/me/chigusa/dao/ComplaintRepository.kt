package me.chigusa.dao

import me.chigusa.entity.Complaint
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author Chigusa
 * @function
 * @date 2017/3/14
 */
interface ComplaintRepository : JpaRepository<Complaint, Long> {
}