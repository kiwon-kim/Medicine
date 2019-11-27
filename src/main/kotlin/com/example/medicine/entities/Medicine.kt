package com.example.medicine.entities

class Medicine : SingleKeyEntity<Int>() {
    var medicineId: Int = 0
    var name: String = ""
    var makerId: Int = 0
    var typeId: Int = 0
    var shapeId: Int = 0
    var colorId: Int = 0
    var marker: String = ""
    var ingredient: String = ""
    var effect: String = ""
    var usage: String = ""
    var caution: String = ""


    override fun toString(): String = "$medicineId / $name / $makerId / $typeId / $shapeId / $colorId / $marker / $ingredient / $effect / $usage / $caution"

    override val keyValue1: Int
        get() = medicineId
}