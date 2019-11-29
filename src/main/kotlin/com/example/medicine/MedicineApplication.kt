package com.example.medicine

import com.example.medicine.repositories.Repository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.sql.DriverManager
import java.util.*

@SpringBootApplication
class MedicineApplication : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("hello world")
//        println(Repository.medicine.count())
//        println(Repository.medicine.select("트루", "TS3", "정제", "타원", "하양"))
//        println(Repository.medicine.select("트루", "TS3", "정제", "타원", "하양"))
//        println(Repository.medicine.getAll())
//        println(Repository.medicine.getByPK(1))

        var marker: String? = ""
        var type: String? = ""
        var shape: String? = ""
        var color: String? = ""


//    fun toString() = "$marker/ $type/ $shape/ $color"
        print("marker: ")
        marker = readLine()

        print("type: ")
        type = readLine()

        print("shape: ")
        shape = readLine()

        print("color: ")
        color = readLine()

        var allNullIdentifier = marker + type + shape + color

        if(allNullIdentifier == "")
            println("값을 입력하세요")
        else
            println(Repository.medicine.select(marker, type, shape, color))

    }
}

fun main(args: Array<String>) {
    runApplication<MedicineApplication>(*args)
}
