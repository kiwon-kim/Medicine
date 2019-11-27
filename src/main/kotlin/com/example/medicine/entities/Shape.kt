package com.example.medicine.entities

class Shape: SingleKeyEntity<Int>() {
    var shapeId: Int = 0
    var name: String =""

    override fun toString(): String = "$shapeId / $name"

    override val keyValue1: Int
        get() = shapeId

}