package com.k.sekiro.composetypesafenavigation.ui

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Movie(val name:String,val description:String,val img:Int)
