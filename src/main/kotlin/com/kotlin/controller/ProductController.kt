package com.kotlin.controller

import com.kotlin.jpa.entity.Product
import com.kotlin.jpa.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/product")
class ProductController(val productService: ProductService ) {

    @GetMapping("")
    fun getAll() : MutableList<Product> =  productService.getAll()


    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Long) : ResponseEntity<Product?> = productService.getProductById(id).let {
        return ResponseEntity(it, HttpStatus.OK)
    }

    @GetMapping("/search/{name}")
    fun searchByName(@PathVariable name : String) : ResponseEntity<List<Product>?> =
        productService.getProductByName(name).let {
            it ?: return ResponseEntity(it, HttpStatus.NOT_FOUND)
            return ResponseEntity(it, HttpStatus.OK)
        }

    @PostMapping("")
    fun insert(@RequestBody product: Product) = productService.insertProduct(product)

    @PutMapping("/{id}")
    fun put(@PathVariable id: Long ,@RequestBody product: Product) : ResponseEntity<Product?> =
        productService.getProductById(id).run {
            this ?: return ResponseEntity(null, HttpStatus.NOT_FOUND)
        }.run {
            product.id = id
            return ResponseEntity(productService.updateProduct(product), HttpStatus.OK)
        }

    @PatchMapping("/{id}")
    fun patch(@PathVariable id: Long ,@RequestBody product: Product) : ResponseEntity<Product?> =
        productService.getProductById(id).run {
            this ?: return ResponseEntity(null, HttpStatus.NOT_FOUND)
        }.run {
            Product(this.id,product.name)
        }.run {
            return ResponseEntity(productService.updateProduct(this), HttpStatus.OK)
        }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id :Long) : ResponseEntity<Any> = productService.getProductById(id).run {
        this ?: return ResponseEntity<Any>(null, HttpStatus.NOT_FOUND)
    }.run {
        return ResponseEntity<Any>(productService.deleteProduct(this), HttpStatus.NO_CONTENT)
    }


}
