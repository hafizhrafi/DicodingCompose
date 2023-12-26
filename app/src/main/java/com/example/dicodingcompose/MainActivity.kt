package com.example.dicodingcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dicodingcompose.ui.theme.DicodingComposeTheme
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // This makes it possible to draw behind the status bar.
        WindowCompat.setDecorFitsSystemWindows(window,false)

        setContent {
            DicodingComposeTheme {

                val navController = rememberNavController()

                ProvideWindowInsets {

                    // A surface container using the 'background' color from the theme
                    androidx.compose.material.Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = androidx.compose.material.MaterialTheme.colors.background
                    ) {

                        NavHost(navController = navController,
                            startDestination = "home"
                        ) {


                            composable("profile") {

                                ProfileScreen(navController)

                            }

                            composable("home") {

                                HomeScreen(navController)

                            }

                            composable("detail") {
                                val index: Int? = navController.previousBackStackEntry?.savedStateHandle?.get("index")
                                if (index != null){
                                    DetailScreen(navController = navController, index = index)
                                }
                            }

                        }


                    }

                }


            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DicodingComposeTheme {
        Greeting("Android")
    }
}