package br.senai.sp.jandira.loginpage.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.loginpage.model.User

@Database(entities = [User::class], version = 1)
abstract class tripDb : RoomDatabase() {
    abstract  fun userDao(): UserDao
    companion object { // estático ou seja compartilha um valor em outros lugares sem ser alterado
        private lateinit var instanceDb: tripDb
        fun getDataBase(context: Context): tripDb {
            if (!::instanceDb.isInitialized) {
                instanceDb = Room.databaseBuilder(context, tripDb::class.java,"db_trip").allowMainThreadQueries().build()
            }
            return instanceDb

        }
    }
}