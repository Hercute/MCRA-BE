package com.hercute.mcrabe.domain.categories.model

import jakarta.persistence.*


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
   // cart 와의 1대 다 관계 설정
//    @OneToMany(
//        mappedBy = "category",
//        fetch = FetchType.LAZY,
//        cascade = [CascadeType.ALL],
//        orphanRemoval = true
//    )
//    var carts : MutableList<Cart> = mutableListOf()

    // Frideges와의 1대 다 관계 설정
//    @OneToMany(
//        mappedBy = "category",
//        fetch = FetchType.LAZY,
//        cascade = [CascadeType.ALL],
//        orphanRemoval = true
//    )
//    var fridges : MutableList<Fridges> = mutableListOf()
}
