package com.kotlin.jpa.service

import com.kotlin.jpa.entity.Product

interface ProductService {

    fun getAll() : MutableList<Product>

    fun getProductByName (name : String) :MutableList<Product>?

    fun getProductById(id : Long) : Product?

    fun insertProduct(product: Product) : Product

    fun updateProduct(product: Product) : Product

    fun deleteProduct(product: Product) : Unit
}
