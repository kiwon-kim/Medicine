package com.example.medicine.entities

class Type: SingleKeyEntity<Int>() {
    var typeId: Int = 0
    var name: String = ""

    override fun toString(): String = "$typeId / $name"

    override val keyValue1: Int
        get() = typeId
}