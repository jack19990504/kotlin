package com.kotlin.jpa.repository

import com.kotlin.jpa.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product,Long> ,JpaSpecificationExecutor<Product>{

    fun findByName(name : String) : MutableList<Product>?

    @Query("SELECT * FROM PRODUCT WHERE id = :id",nativeQuery=true)
    fun queryById(@Param("id") id : Long) : Product?
}
