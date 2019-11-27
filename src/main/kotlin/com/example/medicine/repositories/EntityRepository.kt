package com.example.medicine.repositories

import com.example.medicine.entities.Entity
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

abstract class EntityRepository<T: Entity> {
        protected fun createStatement(sql: String): PreparedStatement {
                val url = "jdbc:sqlserver://localhost;database=Medicine;user=sa;password=1234"

                val connection = DriverManager.getConnection(url)

                return connection.prepareStatement(sql)
        }

        protected fun close(statement: PreparedStatement) {
                statement.resultSet?.close()
                statement.connection?.close()
        }

        protected abstract val entityName: String

        protected abstract val keyNames: String

        fun count(): Int {
                val statement = createStatement("select count(*) from $entityName")
                val result = statement.executeQuery()
                result.next()

                val count = result.getInt(1)

                close(statement)

                return count
        }

        protected abstract fun readEntity(result: ResultSet): T

        fun getAll(): MutableList<T> {
                val statement = createStatement("select * from $entityName")
                val result = statement.executeQuery()

                val entities = mutableListOf<T>()
                while (result.next()) {
                        val entity = readEntity(result)
                        entities.add(entity)
                }

                close(statement)

                return entities
        }

        protected abstract fun insertCore(entity: T): PreparedStatement

        fun insert(entity: T) {
                val statement = insertCore(entity)

                statement.executeUpdate()

                close(statement)
        }

        protected abstract fun updateCore(entity: T): PreparedStatement

        fun update(entity: T) {
                val statement = updateCore(entity)

                statement.executeUpdate()

                close(statement)
        }

        protected open val getLastQuery = "select top 1 * from $entityName order by $keyNames desc"

        fun getLast(): T?{
                val statement = createStatement(getLastQuery)

                val result = statement.executeQuery()
                result.next()
                val entity = readEntity(result)

                close(statement)

                return entity
        }
}