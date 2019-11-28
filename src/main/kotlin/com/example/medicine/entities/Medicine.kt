package com.example.medicine.entities

class Medicine {
    var name:String = ""
    var maker:String = ""
    var shape:String = ""
    var type:String = ""
    var marker:String = ""
    var ingredient:String = ""
    var color: String = ""
    var effect:String = ""
    var usage:String = ""
    var caution:String = ""

    override fun toString(): String = "$name/ $maker/ $shape/ $type/ $marker/ $ingredient/ $effect/ $usage/ $caution "
}