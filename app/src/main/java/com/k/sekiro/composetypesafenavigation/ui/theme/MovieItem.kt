package com.k.sekiro.composetypesafenavigation.ui.theme

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import com.k.sekiro.composetypesafenavigation.ui.*

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.MovieItem(
    movie: Movie,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onClickMovie: (Movie) -> Unit = {}
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClickMovie(movie) }
    ) {

        Image(
            painter = painterResource(id = movie.img),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .sharedBounds(
                    sharedContentState = rememberSharedContentState(key = "image-${movie.img}"),
                    animatedVisibilityScope = animatedVisibilityScope,
                    boundsTransform = { initialRec, targetRec ->
                        tween(
                            durationMillis = 500
                        )

                    },
                    resizeMode = SharedTransitionScope.ResizeMode.RemeasureToBounds
                )
                .size(150.dp)
                .clip(RoundedCornerShape(12.dp))
        )


        Spacer(modifier = Modifier.width(16.dp))


        Column(
            modifier = Modifier.height(150.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = movie.name,
                modifier = Modifier
                    .sharedBounds(
                        sharedContentState = rememberSharedContentState(key = "name-${movie.img}"),
                        animatedVisibilityScope = animatedVisibilityScope,
                        boundsTransform = { initialRec, targetRec ->
                            tween(
                                durationMillis = 500
                            )

                        }
                    )
                    .padding(bottom = 12.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = movie.description,
                fontSize = 16.sp,
                modifier = Modifier
                    .sharedBounds(
                        sharedContentState = rememberSharedContentState(key = "date-${movie.img}"),
                        animatedVisibilityScope = animatedVisibilityScope,
                        boundsTransform = { initialRec, targetRec ->
                            tween(
                                durationMillis = 500
                            )

                        }
                    )
                    .padding(bottom = 12.dp),
            )

        }

    }

}