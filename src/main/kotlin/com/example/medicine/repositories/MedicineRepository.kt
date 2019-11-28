package com.example.medicine.repositories

import com.example.medicine.entities.Medicine
import com.example.medicine.entities.Medicine2
import java.awt.Color
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class MedicineRepository {
    protected fun createStatement(sql: String): PreparedStatement {
        val url = "jdbc:sqlserver://localhost;database=Medicine;user=sa;password=1234"

        val connection = DriverManager.getConnection(url)

        return connection.prepareStatement(sql)
    }

    protected fun close(statement: PreparedStatement) {
        statement.resultSet?.close()
        statement.connection?.close()
    }

    fun select(name: String, marker: String, type: String, shape: String, color: String): MutableList<Medicine> {
        var sql = "select * from (" +
                "\tselect p.name 약이름, m.name 제약회사, s.name 모양, t.name 제형, p.marker 식별, c.name 색상, p.ingredient, p.effect, p.usage, p.caution \n" +
                "\tfrom Medicine p, Maker m , Shape s, Type t, Color c \n" +
                "\twhere p.makerId = m.makerId and p.shapeId = s.shapeId and p.typeId = t.typeId and p.colorId = c.colorId \n" +
                ") a\n" +
                " where  a.약이름 like ? and a.식별 like ? and a.제형 like ? and a.모양 like ? and a.색상 like ?;"

        val statement = createStatement(sql)
        statement.setString(1, "%$name%")
        statement.setString(2, "%$marker%")
        statement.setString(3, "%$type%")
        statement.setString(4, "%$shape%")
        statement.setString(5, "%$color%")

        val result = statement.executeQuery()

        val medicines = mutableListOf<Medicine>()

        while (result.next()) {
            val medicine= Medicine()
            medicine.name = result.getString(1)
            medicine.maker = result.getString(2)
            medicine.shape = result.getString(3)
            medicine.type = result.getString(4)
            medicine.marker = result.getString(5)
            medicine.color = result.getString(6)
            medicine.ingredient = result.getString(7)
            medicine.effect = result.getString(8)
            medicine.usage = result.getString(9)
            medicine.caution = result.getString(10)

            medicines.add(medicine)

        }
        close(statement)

        return medicines
    }



}