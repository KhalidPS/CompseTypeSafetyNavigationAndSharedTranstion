package com.k.sekiro.composetypesafenavigation.ui.theme

import androidx.compose.animation.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import com.k.sekiro.composetypesafenavigation.R
import com.k.sekiro.composetypesafenavigation.ui.*

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.HomeScreen(
    animatedVisibilityScope: AnimatedVisibilityScope,
    onMovieClick:(Movie) -> Unit
) {

    val movies = remember {
        listOf(
            Movie(name = "Extraction 3","Sunt armariumes quaestio ferox, varius finises.Impositios sunt silvas de festus contencio.", R.drawable.extraction_3_movie),
            Movie(name = "Spider Man","Sunt armariumes quaestio ferox, varius finises.Impositios sunt silvas de festus contencio.",R.drawable.spider_man_movie_poster),
            Movie(name = "Wei Ji Hang","Sunt armariumes quaestio ferox, varius finises.Impositios sunt silvas de festus contencio.",R.drawable.wei_ji_hang_xian_chinese_movie),
            Movie(name = "It's Whats inside","Sunt armariumes quaestio ferox, varius finises.Impositios sunt silvas de festus contencio.",R.drawable.its_whats_inside_movie),
            Movie(name = "Gyeongseong","Sunt armariumes quaestio ferox, varius finises.Impositios sunt silvas de festus contencio.",R.drawable.gyeongseong_creature_movie),
        )
    }

    LazyColumn {
        items(movies){
            MovieItem(it,animatedVisibilityScope){
                onMovieClick(it)
            }
        }
    }
}