package br.senai.sp.jandira.loginpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.loginpage.ui.theme.LoginPageTheme

class InitPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageTheme {
                page()

            }
        }
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun page() {
   Surface(modifier = Modifier.fillMaxSize()) {
       Column(modifier = Modifier.fillMaxWidth()) {
           Card(modifier = Modifier
               .fillMaxWidth()
               .height(197.dp)) {
               Image(painter = painterResource(id = R.drawable.foto_inicio), contentDescription = "")
           }
       }
   }
}