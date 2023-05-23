package br.senai.sp.jandira.loginpage.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.loginpage.R
import br.senai.sp.jandira.loginpage.dao.Category

class CategoryRepository {
    companion object{
        @Composable
        fun getCategories(): List<Category>{
            return listOf(
                Category(
                    id = 1,
                    name = "Montain",
                    icon = painterResource(id = R.drawable.montain)
                ),
                Category(
                    id = 1,
                    name = "Snow",
                    icon = painterResource(id = R.drawable.snow)
                ),
                Category(
                    id = 1,
                    name = "Beach",
                    icon = painterResource(id = R.drawable.beach)
                )
            )
        }
    }

}