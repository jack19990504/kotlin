package com.kotlin.jpa.entity

import javax.persistence.*

@Entity
@Table(name="PRODUCT")
data class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id : Long = 0,

    @Column(name = "NAME")
    var name : String = "name"

)
