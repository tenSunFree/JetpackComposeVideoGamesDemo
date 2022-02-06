package com.example.jetpackcomposevideogamesdemo.remote.model.response

import com.example.jetpackcomposevideogamesdemo.domain.entity.home.HomeEntity
import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<HomeResults>
)

data class HomeResults(
    @SerializedName("id")
    val id: Int,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("released")
    val released: String,
    @SerializedName("tba")
    val tba: Boolean,
    @SerializedName("background_image")
    val backgroundImage: String?,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("rating_top")
    val ratingTop: Int,
    @SerializedName("ratings_count")
    val ratingsCount: Int,
    @SerializedName("reviews_text_count")
    val reviewsTextCount: Int,
    @SerializedName("added")
    val added: Int,
    @SerializedName("metacritic")
    val metaCritic: Int,
    @SerializedName("playtime")
    val playTime: Int,
    @SerializedName("suggestions_count")
    val suggestionsCount: Int,
    @SerializedName("updated")
    val updated: String,
    @SerializedName("user_game")
    val userGame: String?,
    @SerializedName("reviews_count")
    val reviewsCount: Int,
    @SerializedName("saturated_color")
    val saturatedColor: String,
    @SerializedName("dominant_color")
    val dominantColor: String,
    @SerializedName("clip")
    val clip: String?
)

fun HomeResults.toEntity() = HomeEntity(id, name, backgroundImage ?: "", rating)

fun List<HomeResults>.toEntity() = map { it.toEntity() }