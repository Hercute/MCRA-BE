package com.hercute.mcrabe.domain.categories.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "categories")
class Categories(
    @Column(name = "main", unique = true)
    var main: String,

    @Column(name = "sub")
    var sub : String,
)


{
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
val id : Long? = null
}
