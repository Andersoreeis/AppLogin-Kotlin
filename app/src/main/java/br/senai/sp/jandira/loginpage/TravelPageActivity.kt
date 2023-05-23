package br.senai.sp.jandira.loginpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.loginpage.dao.Category
import br.senai.sp.jandira.loginpage.repository.CategoryRepository
import br.senai.sp.jandira.loginpage.ui.theme.LoginPageTheme

class TravelPageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageTheme {

                lobyScreen()

            }
        }
    }
}


@Composable
fun Travelpage(categories: List<Category>) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }) {
           Icon(imageVector = Icons.Default.Add , contentDescription = "", tint = Color.White)
        }
    }) {
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            Column() {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    backgroundColor = Color.LightGray,
                    shape = RectangleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.foto_inicio),
                        contentDescription = "Logo",
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    text = stringResource(id = R.string.categories),
                    modifier = Modifier.padding(top = 14.dp, start = 16.dp)
                )
                LazyRow() {
                    items(categories) { category ->

                        Card(
                            modifier = Modifier
                                .size(125.dp, 80.dp)
                                .padding(4.dp),
                            backgroundColor = Color(207, 6, 240)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                Icon(painter = category.icon!!, contentDescription = category.name, modifier = Modifier.size(50. dp))
                                Text(text = "${category.name}")
                            }

                        }

                    }


                }
            }

        }
    }
    }


@Preview(showBackground = true)
@Composable
fun lobyScreen() {
    Travelpage(categories = CategoryRepository.getCategories())
}



