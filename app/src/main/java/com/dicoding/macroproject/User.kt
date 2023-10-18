package com.dicoding.macroproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val username:String,
    val password:String,
    val level: Int = 23,
    val health: Int = 89,
    val exp: Int = 87
): Parcelable