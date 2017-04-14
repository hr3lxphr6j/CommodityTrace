package me.chigusa.services

import me.chigusa.dao.ComplaintRepository
import me.chigusa.entity.Complaint
import me.chigusa.entity.Product
import me.chigusa.exception.complaint.ComplaintIdNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @author Chigusa
 * @function 投诉服务
 * @date 2017/4/12
 */
@Service
@Transactional
class ComplaintService {
    @Autowired
    var complaintRepository: ComplaintRepository? = null

    /**
     * 判断是否存在
     */
    private fun exist(id: Long) {
        if (!complaintRepository!!.exists(id)) {
            throw ComplaintIdNotFoundException(id)
        }
    }

    /**
     * 返回所有投诉
     */
    fun loadComplaints(): List<Complaint> {
        return complaintRepository!!.findAll()
    }

    /**
     * 增加投诉
     */
    fun addComplaint(complaint: Complaint) {
        complaintRepository!!.save(complaint)
    }

    /**
     * 修改投诉
     */
    fun patchComplaint(complaint: Complaint) {
        exist(complaint.id!!)
        complaintRepository!!.save(complaint)
    }

    /**
     * 删除投诉
     */
    fun delComplaint(complaint: Complaint) {
        exist(complaint.id!!)
        complaintRepository!!.delete(complaint)
    }

    /**
     * 根据ID查询投诉
     */
    fun loadComplaintById(id: Long): Complaint {
        exist(id)
        return complaintRepository!!.findOne(id)
    }

    /**
     * 根据被投诉产品查询
     */
    fun loadComplaintsByProduct(product: Product): List<Complaint> {
        return complaintRepository!!.findByProduct(product)
    }

}