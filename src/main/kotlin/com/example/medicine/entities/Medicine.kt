package com.example.medicine.entities

class Medicine : SingleKeyEntity<Int>() {
    var medicineId: Int = 0
    var name: String = ""
    var makerId: Int = 0

    override fun toString(): String = "$medicineId / $name / $makerId"

    override val keyValue1: Int
        get() = medicineId
}