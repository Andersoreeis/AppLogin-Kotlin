package br.senai.sp.jandira.loginpage

import android.graphics.ColorSpace.Rgb
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginpage.ui.theme.LoginPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageTheme {
                LoginPage()
            }
        }
    }
}


@Preview
@Composable
fun LoginPage() {
    var emaiState = rememberSaveable() {
        mutableStateOf("")
    }
    var passwordState = rememberSaveable() {
        mutableStateOf("")
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp), horizontalArrangement = Arrangement.End
            ) {
                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .fillMaxHeight()
                        .background(
                            Color(207, 6, 240),
                            shape = RoundedCornerShape(bottomStart = 16.dp)
                        )
                )
            }
            Spacer(modifier = Modifier.height(164.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(17.dp, 0.dp)
            ) {
                Text(
                    text = "Login",
                    modifier = Modifier,
                    fontSize = 48.sp,
                    fontWeight = FontWeight(700),
                    color = Color(207, 6, 240)
                )
                Text(
                    text = "Please sign in to continue.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(160, 156, 156)
                )
            }
            Spacer(modifier = Modifier.height(87.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedTextField(
                    value = emaiState.value,
                    onValueChange = {
                                    emaiState.value = it
                    },
                    label = { Text(text = "E-mail") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.baseline_email_24),
                            contentDescription = "Icon de Email",
                            tint = Color(207, 6, 240)
                        )
                    }, modifier = Modifier
                        .width(370.dp)
                        .height(58.dp),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    visualTransformation = PasswordVisualTransformation()

                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = passwordState.value,
                    onValueChange = {
                                    passwordState.value = it
                    },
                    label = { Text(text = "Password") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.baseline_lock_24),
                            contentDescription = "Icon de Email",
                            tint = Color(207, 6, 240),


                            )
                    },
                    modifier = Modifier
                        .width(370.dp)
                        .height(58.dp),
                    shape = RoundedCornerShape(16.dp),
                    visualTransformation = PasswordVisualTransformation()
                )
            }
            Spacer(modifier = Modifier.height(31.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalAlignment = Alignment.End
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color(207, 6, 240)),
                    modifier = Modifier
                        .width(134.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "SIGN IN ", color = Color.White, fontWeight = FontWeight(700))
                    Icon(
                        painter = painterResource(R.drawable.baseline_arrow_forward_24),
                        contentDescription = "Icon de Email",
                        tint = Color(255, 255, 255),


                        )
                }
                Spacer(modifier = Modifier.height(31.dp))
                Row(horizontalArrangement = Arrangement.End) {
                    Text(
                        text = "Don’t have an account?  ",
                        fontSize = 12.sp,
                        color = Color(60, 156, 156)
                    )
                    Text(
                        text = "Sign up",
                        modifier = Modifier.clickable { },
                        color = Color(207, 6, 240),
                        fontWeight = FontWeight(700)
                    )
                }
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.Bottom
            ) {
                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .height(40.dp)
                        .background(
                            Color(207, 6, 240),
                            shape = RoundedCornerShape(topEnd = 16.dp)
                        )
                )
            }
        }
    }
}