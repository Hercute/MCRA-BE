package com.hercute.mcrabe.domain.categories.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table


@Entity
@Table(name = "categories")
class Categories(
    @Column(name = "main", unique = true)
    val main: String,

    @Column(name = "sub")
)
