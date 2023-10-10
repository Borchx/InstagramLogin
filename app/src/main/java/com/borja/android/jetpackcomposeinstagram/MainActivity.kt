package com.borja.android.jetpackcomposeinstagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.borja.android.jetpackcomposeinstagram.login.ui.LoginScreen
import com.borja.android.jetpackcomposeinstagram.login.ui.LoginViewModel
import com.borja.android.jetpackcomposeinstagram.ui.theme.JetpackComposeInstagramTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //inyectar los viewmodel
    private val loginViewModel:LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeInstagramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF161D26))

                ) {
                    LoginScreen(loginViewModel)
                    //TwitterScreen()
                    //TuitDivider()
                }
            }
        }
    }
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeInstagramTheme {
        //Greeting("Android")
    }
}