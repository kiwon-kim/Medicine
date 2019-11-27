package com.example.medicine.entities

class Maker: SingleKeyEntity<Int>() {
    var makerId = 0
    var name = ""

    override fun toString(): String = "$makerId / $name"

    override val keyValue1: Int
        get() = makerId
}