package com.example.whynotcompmat3

import GalleryOfArtworksScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whynotcompmat3.feature.artItemdetails.ArtItemDetailsScreen
import com.example.whynotcompmat3.ui.theme.Whynotcompmat3Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Whynotcompmat3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainComposable()
                }
            }
        }
    }

    @Composable
    private fun MainComposable() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "gallery") {
            composable("gallery") { GalleryOfArtworksScreen(navController) }
            composable("artItemDetails/{imageId}") { backStackEntry ->
                ArtItemDetailsScreen(backStackEntry.arguments?.getString("imageId") ?: "") }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Whynotcompmat3Theme {
        Greeting("Android")
    }
}