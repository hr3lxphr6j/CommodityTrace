package me.chigusa.entity

import javax.persistence.*

/**
 * @author Chigusa
 * @function 产品
 * @date 2017/3/14
 */
@Entity
data class Product(
        /**
         * 产品ID，非空主键，暂定自增，唯一
         */
        //todo:决定主键增加算法
        @Id @GeneratedValue @Column(nullable = false, unique = true) var id: Long? = -1,

        /**
         * 产品名称，非空
         */
        @Column(nullable = false) var name: String? = "",

        /**
         * 规格，非空
         */
        @Column(nullable = false) var standard: String? = "",

        /**
         * 产地，非空
         */
        @Column(nullable = false) var producingArea: String? = "",

        /**
         * 生产者，非空，外键
         */
        @ManyToOne @JoinColumn(nullable = false) var user: User? = null,

        /**
         * 是否为转基因
         * 0：不是
         * 1：是
         * 2：未知
         */
        @Column(nullable = false) var isGM: Int? = 2
) {
}