package com.example.medicine.controllers

import com.example.medicine.repositories.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/medicine")
class MedicineController {
    @GetMapping
    fun getAll() = Repository.medicine.select(null, null, null, null)

}