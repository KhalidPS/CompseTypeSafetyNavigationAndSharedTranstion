package com.k.sekiro.animationssharedelement

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.k.sekiro.composetypesafenavigation.ui.*


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.DetailsScreen(
    movie: Movie ,
    animatedVisibilityScope: AnimatedVisibilityScope
) {


    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(id = movie.img),
            contentDescription = null,
            modifier = Modifier
                .sharedBounds(
                    sharedContentState = rememberSharedContentState(key = "image-${movie.img}"),
                    animatedVisibilityScope = animatedVisibilityScope,
                    boundsTransform = {initialRec , targetRec ->

                        tween(
                            durationMillis = 500
                        )
 /*                       spring(
                            dampingRatio = 0.8f,
                            stiffness = 380f
                        )*/
                    },
                    resizeMode = SharedTransitionScope.ResizeMode.RemeasureToBounds,

                )
                .fillMaxWidth()
                .height(350.dp),
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ){

            Text(
                text = "name:",
                fontSize = 24.sp
            )

            Text(
                text = movie.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
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
                    .padding(start = 8.dp)
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ){

            Text(
                text = "date:",
                fontSize = 24.sp
            )

            Text(
                text = "22/2/2025",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
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
                    .padding(start = 8.dp),
                textAlign = TextAlign.Center
            )

        }

        Spacer(modifier = Modifier.height(16.dp))


        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ){

            Text(
                text = "time:",
                fontSize = 24.sp
            )

            Text(
                text = "2:30:00",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .sharedBounds(
                        sharedContentState = rememberSharedContentState(key = "time-${movie.img}"),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
                    .padding(start = 8.dp)
            )

        }


        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "about:",
            fontSize = 24.sp,
            modifier = Modifier.padding(start = 8.dp)
        )


        Text(
            text = movie.description,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )




    }







}