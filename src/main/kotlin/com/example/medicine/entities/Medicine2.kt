package com.example.medicine.entities

class Medicine2 : SingleKeyEntity<Int>() {
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
    var maker:String = ""
    var shape:String = ""
    var type:String = ""
    var color: String = ""

    override fun toString(): String = "$medicineId / $name / $makerId/ $maker / $typeId/ $type / $shapeId/ $shape / $colorId/ $color / $marker / $ingredient / $effect / $usage / $caution"

    override val keyValue1: Int
        get() = medicineId





}