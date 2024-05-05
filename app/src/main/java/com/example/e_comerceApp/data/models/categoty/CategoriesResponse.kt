package com.example.e_comerceApp.data.models.categoty

data class CategoriesResponse (
    val results: Int? = null,
    val metadata: Metadata? = null,
    val data: List<Category?>? = null,
)