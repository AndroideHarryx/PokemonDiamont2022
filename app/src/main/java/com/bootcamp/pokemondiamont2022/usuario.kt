package com.bootcamp.pokemondiamont2022

import android.content.Context
import androidx.room.*
import java.sql.Date

@Entity(tableName = "users")
data class usuario(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var user: String,
    var pass: String,
    var email: String,
    var fecha: String
)

@Dao
interface userDao {

    @Insert
    fun insertUser(persona: usuario)

    @Query("Select * from users")
    fun getAllUser(): List<usuario>

    @Update
    fun updateUser(persona: usuario)

    @Delete
    fun deleteUser(persona: usuario)

    @Query("Select * from users where user=:usuario and pass=:password")
    fun getByUser(usuario: String, password: String): usuario
}


@Database(entities = [usuario::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usersDao(): userDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "usuarios").allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
