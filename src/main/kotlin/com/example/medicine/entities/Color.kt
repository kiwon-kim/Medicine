package com.example.medicine.entities

class Color: SingleKeyEntity<Int>() {
    var ColorId: Int = 0
    var name: String = ""

    override fun toString(): String = "$ColorId / $name"

    override val keyValue1: Int
        get() = ColorId
}