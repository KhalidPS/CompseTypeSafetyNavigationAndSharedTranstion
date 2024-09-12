package com.k.sekiro.composetypesafenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.*
import androidx.navigation.compose.*
import com.k.sekiro.animationssharedelement.*
import com.k.sekiro.composetypesafenavigation.ui.*
import com.k.sekiro.composetypesafenavigation.ui.theme.*
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalSharedTransitionApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTypeSafeNavigationTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   SharedTransitionLayout {
                       NavHost(
                           navController = navController,
                           startDestination = Home,
                           modifier = Modifier.padding(innerPadding)
                       ){

                           composable<Home> {
                                HomeScreen(
                                    animatedVisibilityScope = this,
                                    onMovieClick = {
                                        navController.navigate(it)
                                    }
                                )
                           }

                           composable<Movie> {navBackStack ->
                               val movie = navBackStack.toRoute<Movie>()

                               DetailsScreen(movie,this)
                           }
                       }
                   }
                }
            }
        }
    }
}



