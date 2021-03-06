package me.chigusa.services

import me.chigusa.dao.ProductRepository
import me.chigusa.entity.Product
import me.chigusa.exception.product.ProductIdNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping


/**
 * @author Chigusa
 * @function 产品服务
 * @date 2017/4/12
 */
@Service
@Transactional
class ProductService {
    @Autowired
    var productRepository: ProductRepository? = null

    /**
     * 增加产品
     */
    @CachePut(value = "product",key = "#product.id")
    fun addProduct(product: Product) {
        productRepository!!.save(product)
    }

    /**
     * 返回所有产品
     */
    fun loadProducts(): List<Product> {
        return productRepository!!.findAll()
    }

    /**
     * 根据id查询是否存在
     */
    private fun exist(id: Long) {
        if (!productRepository!!.exists(id)) {
            throw ProductIdNotFoundException(id)
        }
    }

    /**
     * 根据ID返回产品
     */
    @Cacheable(value = "product",key = "#id")
    fun loadProductById(id: Long): Product {
        exist(id)
        return productRepository!!.findOne(id)
    }

    /**
     * 修改产品数据
     */
    @CachePut(value = "product",key = "#product.id")
    fun patchProduct(product: Product) {
        exist(product.id!!)
        productRepository!!.save(product)
    }

    /**
     * 删除产品数据
     */
    @CacheEvict(value = "product",key = "#id")
    fun delProduct(id: Long) {
        exist(id)
        productRepository!!.delete(id)
    }

}