package com.example.adv160421001week6.model

data class Food(
    val id:String?,
    val name:String?,
    val description:String?,
    val ingredients:List<String>?,
    val images:String?,
    val nutrition: Nutrition?
)

data class Nutrition(
    val calories:String?,
    val protein:String?
)