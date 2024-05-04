package com.example.e_comerceApp.data.models.categoty

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val id: String? = null,
    val name: String? = null,
    val slug: String? = null,
    val image: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
) : Parcelable