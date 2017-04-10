package me.chigusa.entity

import javax.persistence.*

/**
 * @author Chigusa
 * @function 投诉
 * @date 2017/3/14
 */
@Entity
data class Complaint(
        /**
         * 投诉ID，主键非空，唯一
         */
        @Id @GeneratedValue @Column(nullable = false, unique = true) var id: Long? = -1,

        /**
         * 投诉产品，非空
         */
        @ManyToOne @JoinColumn(nullable = false) var product: Product? = null,

        /**
         * 投诉者联系电话，非空
         */
        @Column(nullable = false) var phone: String? = null,

        /**
         * 投诉内容，非空
         */
        @Column(nullable = false) var content: String? = null
) {
}