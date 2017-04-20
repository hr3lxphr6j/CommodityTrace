package me.chigusa.web

import me.chigusa.entity.Complaint
import me.chigusa.entity.Product
import me.chigusa.entity.User
import me.chigusa.exception.product.ProductIdNotFoundException
import me.chigusa.services.ComplaintService
import me.chigusa.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * @author Chigusa
 * @function Product Controller
 * @date 2017/4/13
 */
@CrossOrigin(origins = arrayOf("*"), maxAge = 3600)
@RestController
@RequestMapping("product")
class ProductController {
    @Autowired
    var productService: ProductService? = null
    @Autowired
    var complaintService: ComplaintService? = null

    /**
     * 获得所有产品信息
     */
    @GetMapping()
    fun getProducts(): ResponseEntity<List<Product>> {
        return ResponseEntity(productService!!.loadProducts(), HttpStatus.OK)
    }

    /**
     * 增加产品信息
     * 需要 ADMIN 或 PRODUCER 权限
     */
    @PostMapping()
    @PreAuthorize("hasAnyRole('ADMIN','PRODUCER')")
    fun addProduct(@AuthenticationPrincipal user: User, @Valid @RequestBody() product: Product, bindingResult: BindingResult) {
        productService!!.addProduct(product.apply { this.user = user })
    }

    /**
     * 通过ID获得产品信息
     */
    @GetMapping("{id}")
    fun getProductById(@PathVariable("id") id: Long): ResponseEntity<Product> {
        return ResponseEntity(productService!!.loadProductById(id), HttpStatus.OK)
    }

    /**
     * 更新产品信息
     * 需要 ADMIN 权限或者为对应的 product
     */
    @PatchMapping("{id}")
    @PreAuthorize("hasRole('ADMIN') or #product.user.id == principal.id")
    fun patchProductById(@PathVariable("id") id: Long, @Valid @RequestBody product: Product, bindingResult: BindingResult) {
        productService!!.patchProduct(product)
    }

    /**
     * 删除产品信息
     * 需要 ADMIN 权限或者为对应的 product
     */
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN') or #product.user.id == principal.id")
    fun delProductById(@PathVariable("id") id: Long) {
        productService!!.delProduct(id)
    }

    /**
     * 获得该产品所有投诉
     */
    @GetMapping("{id}/complaint")
    fun getComplaints(@PathVariable id: Long): ResponseEntity<List<Complaint>> {
        return ResponseEntity(complaintService!!.loadComplaintsByProduct(productService!!.loadProductById(id)), HttpStatus.OK)
    }

    /**
     * 投诉该产品
     */
    @PostMapping("{id}/complaint")
    fun addComplaint(@PathVariable id: Long, @Valid @RequestBody complaint: Complaint, bindingResult: BindingResult) {
        complaintService!!.addComplaint(complaint.apply { product = productService!!.loadProductById(id) })
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