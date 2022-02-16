package com.bootcamp.pokemondiamont2022.models


import com.google.gson.annotations.SerializedName

data class SimplePokemon(
    @SerializedName("count")
    var count: Int?,
    @SerializedName("next")
    var next: String?,
    @SerializedName("previous")
    var previous: String?,
    @SerializedName("results")
    var results: List<Result?>?
) {
    data class Result(
        @SerializedName("name")
        var name: String?,
        @SerializedName("url")
        var url: String?
    )
}