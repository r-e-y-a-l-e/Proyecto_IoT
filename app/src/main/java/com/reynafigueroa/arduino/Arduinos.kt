package com.reynafigueroa.arduino

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Arduinos(
    val id: Int,
    val model: String,
    val description: String,
    val characteristics: String,
    val image: String
) : Parcelable
