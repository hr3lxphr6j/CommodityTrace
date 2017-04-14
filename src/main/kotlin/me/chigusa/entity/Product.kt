package me.chigusa.entity


import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.validator.constraints.NotEmpty
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotNull

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
        @Id @GeneratedValue @Column(nullable = false, unique = true) var id: Long? = -1,

        /**
         * 产品名称，非空
         */
        @Column(nullable = false) @NotEmpty var name: String? = "",

        /**
         * 规格，非空
         */
        @Column(nullable = false) @NotEmpty var standard: String? = "",

        /**
         * 产地，非空
         */
        @Column(nullable = false) @NotEmpty var producingArea: String? = "",

        /**
         * 生产者，非空，外键
         */
        @ManyToOne @JoinColumn(nullable = false) @NotNull @JsonIgnore var user: User? = null,

        /**
         * 是否为转基因
         * 0：不是
         * 1：是
         * 2：未知
         */
        @Column(nullable = false) var isGM: Int? = 2
) : Serializable {
}