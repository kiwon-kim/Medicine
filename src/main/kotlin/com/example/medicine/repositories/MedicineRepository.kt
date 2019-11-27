package com.example.medicine.repositories

import com.example.medicine.entities.Medicine
import com.example.medicine.repositories.Repository.medicine
import java.sql.PreparedStatement
import java.sql.ResultSet

class MedicineRepository : SingleKeyEntityRepository<Medicine, Int>() {
    override val entityName get() = "Medicine"
    override val keyNames get() = "MedicineId"

    override fun readEntity(result: ResultSet): Medicine {
        val medicine = Medicine()
        medicine.medicineId = result.getInt(1)
        medicine.name = result.getString(2)
        medicine.makerId = result.getInt(3)

        return medicine
    }

    fun find(name: String): MutableList<Medicine> {
        val statement = createStatement("select MedicineId, Name, MakerId from Medicine where Name like ?")
        statement.setString(1, "%$name%")

        val result = statement.executeQuery()

        val medicines = mutableListOf<Medicine>()
        while (result.next()) {
            val medicine = readEntity(result)

            medicines.add(medicine)
        }

        close(statement)

        return medicines
    }

    override fun insertCore(entity: Medicine): PreparedStatement {
        val statement = createStatement("insert into Medicine values(?, ?)")
        statement.setString(1, entity.name)
        statement.setInt(2, entity.makerId)

        return statement
    }

    override fun updateCore(entity: Medicine): PreparedStatement {
        val statement = createStatement("update Medicne set Name = ?, MakerId = ? where MedicineId = ?")
        statement.setString(1, entity.name)
        statement.setInt(2, entity.makerId)
        statement.setInt(3, entity.medicineId)

        return statement
    }

}