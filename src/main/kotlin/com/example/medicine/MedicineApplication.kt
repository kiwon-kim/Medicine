package com.example.medicine

import com.example.medicine.repositories.Repository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.sql.DriverManager

@SpringBootApplication
class MedicineApplication : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("hello world")
//        println(Repository.medicine.count())
        println(Repository.medicine.select("트루", "TS3", "정제", "타원", "하양"))
        println(Repository.medicine.select("트루", "TS3", "정제", "타원", "하양"))
//        println(Repository.medicine.getAll())
//        println(Repository.medicine.getByPK(1))

    }
}

fun main(args: Array<String>) {
    runApplication<MedicineApplication>(*args)
}
