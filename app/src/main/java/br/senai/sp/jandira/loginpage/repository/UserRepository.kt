package br.senai.sp.jandira.loginpage.repository

import android.content.Context
import br.senai.sp.jandira.loginpage.dao.tripDb
import br.senai.sp.jandira.loginpage.model.User

class UserRepository(context: Context) {

    private val db = tripDb.getDataBase(context)

    fun save(user: User): Long{
        return db.userDao().save(user)
    }
    fun getUserByEmail(email: String): User{
        return  db.userDao().getUserByEmail(email)
    }
    fun authenticate(email: String, password: String): User{
        return db.userDao().authenticate(email,password)
    }
}