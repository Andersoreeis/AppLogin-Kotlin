package br.senai.sp.jandira.loginpage

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginpage.components.bottomShape
import br.senai.sp.jandira.loginpage.components.topShape
import br.senai.sp.jandira.loginpage.model.User
import br.senai.sp.jandira.loginpage.repository.UserRepository
import br.senai.sp.jandira.loginpage.ui.theme.LoginPageTheme
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageTheme {
                SignUp()
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUp() {
    var usernameState = rememberSaveable() {
        mutableStateOf("")
    }
    var phoneState = rememberSaveable() {
        mutableStateOf("")
    }
    var emaiState = rememberSaveable() {
        mutableStateOf("")
    }
    var passwordState = rememberSaveable() {
        mutableStateOf("")
    }
    var checkBoxState = rememberSaveable() {
        mutableStateOf(false)
    }
    var context = LocalContext.current

// Obter a foto da galeria de imagens
    var photoUrl by remember {
       mutableStateOf<Uri?>(null)
    }
    // criar o objeto que abrirá a galeria e retornará a URl da imagem selecionada

    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()){
        photoUrl = it
    }
    var painter = rememberAsyncImagePainter(ImageRequest.Builder(LocalContext.current).data(photoUrl).build() )


    Surface(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .weight(0.07f)
                , horizontalArrangement = Arrangement.End
            ) {
                topShape()

            }
            Spacer(modifier = Modifier.height(19.dp))
            Column(modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .weight(weight = 1f)) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(17.dp, 0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Sign Up",
                        modifier = Modifier,
                        fontSize = 32.sp,
                        fontWeight = FontWeight(700),
                        color = Color(207, 6, 240)
                    )
                    Text(
                        text = "Create a new account",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(160, 156, 156)
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.size(110.dp)) {
                        Card(
                            modifier = Modifier
                                .size(110.dp)
                                .align(Alignment.TopCenter),
                            shape = CircleShape,
                            border = BorderStroke(
                                width = 2.dp,
                                brush = Brush.horizontalGradient(
                                    colors = listOf(Color(207, 6, 240), Color.White),

                                    )

                            )
                        ) {
                            Image(
                                painter = painter,
                                contentDescription = null,
                                modifier = Modifier.clickable { launcher.launch("image/*") },


                            )

                        }
                        Card(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .size(35.dp)
                                .offset(75.dp, 5.dp),
                            shape = CircleShape
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_photo_camera_24),
                                contentDescription = null,
                                tint = Color(207, 6, 240),
                            )
                        }

                    }


                    Spacer(modifier = Modifier.height(15.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        OutlinedTextField(
                            value = usernameState.value,
                            onValueChange = {
                                usernameState.value = it
                            },
                            label = { Text(text = "Username") },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(R.drawable.baseline_person_24),
                                    contentDescription = "Icon de User",
                                    tint = Color(207, 6, 240)
                                )
                            }, modifier = Modifier
                                .width(370.dp)
                                .height(58.dp),
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),


                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = phoneState.value,
                            onValueChange = {
                                phoneState.value = it
                            },
                            label = { Text(text = "Phone") },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(R.drawable.baseline_phone_android_24),
                                    contentDescription = "Icon de Phone",
                                    tint = Color(207, 6, 240),


                                    )
                            },
                            modifier = Modifier
                                .width(370.dp)
                                .height(58.dp),
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        )




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
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = checkBoxState.value,
                            onCheckedChange = { checkBoxState.value }
                        )
                        Text(text = "Over 18?")

                    }


                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Button(
                            onClick = { userSave(context, emaiState.value, usernameState.value, phoneState.value, passwordState.value, true) },
                            colors = ButtonDefaults.buttonColors(Color(207, 6, 240)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(
                                text = "CREATE ACCOUNT ",
                                color = Color.White,
                                fontWeight = FontWeight(700)
                            )

                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(horizontalArrangement = Arrangement.End) {
                            Text(
                                text = "Already have an account?  ",
                                fontSize = 12.sp,
                                color = Color(60, 156, 156)
                            )
                            Text(
                                text = "Sign in",
                                modifier = Modifier.clickable { },
                                color = Color(207, 6, 240),
                                fontWeight = FontWeight(700)
                            )
                        }
                    }

                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .weight(0.09f),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
            ) {
                bottomShape()
            }
        }

    }
}

fun userSave(context: Context, email: String, userName: String, phone: String, password: String, isOver: Boolean) {
    val userRepository = UserRepository(context)
    var user= userRepository.getUserByEmail(email)
    // Recupera no banco o usuário que tenha o email inserido
    // Se user for null, gravamos o novo usuário, se nao avisamos que o usuario existe
    if(user == null){
        val newUser = User(
        userName = userName,
        phone = phone,
        email = email,
        password = password,
        isOver18 = isOver
        )
        val id = userRepository.save(newUser)
        Toast.makeText(context, "User Created #$id", Toast.LENGTH_LONG).show()

    }
}



