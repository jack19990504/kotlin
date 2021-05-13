package com.kotlin.jpa.service.impl

import com.kotlin.jpa.entity.Product
import com.kotlin.jpa.repository.ProductRepository
import com.kotlin.jpa.service.ProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(val productRepository: ProductRepository) : ProductService{

    override fun getAll(): MutableList<Product> = productRepository.findAll()

    override fun getProductByName(name: String): MutableList<Product>? = productRepository.findByName(name)

    override fun getProductById(id: Long): Product? = productRepository.queryById(id)

    override fun insertProduct(product: Product): Product = Product(name = product.name.trim()).run {
        return productRepository.save(this)
    }

    override fun updateProduct(product: Product): Product = Product(id = product.id, name = product.name).run {
        return productRepository.save(this)
    }

    override fun deleteProduct(product: Product) : Unit = productRepository.delete(product)
}
