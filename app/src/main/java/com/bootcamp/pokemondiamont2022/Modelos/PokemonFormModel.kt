package com.bootcamp.pokemondiamont2022.Modelos

import com.google.gson.annotations.SerializedName

data class PokemonFormsModel(
    @SerializedName("form_name")
    var formName: String?,
    @SerializedName("form_names")
    var formNames: List<Any?>?,
    @SerializedName("form_order")
    var formOrder: Int?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("is_battle_only")
    var isBattleOnly: Boolean?,
    @SerializedName("is_default")
    var isDefault: Boolean?,
    @SerializedName("is_mega")
    var isMega: Boolean?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("names")
    var names: List<Any?>?,
    @SerializedName("order")
    var order: Int?,
    @SerializedName("pokemon")
    var pokemon: Pokemon?,
    @SerializedName("sprites")
    var sprites: Sprites?,
    @SerializedName("types")
    var types: List<Type?>?,
    @SerializedName("version_group")
    var versionGroup: VersionGroup?
) {
    data class Pokemon(
        @SerializedName("name")
        var name: String?,
        @SerializedName("url")
        var url: String?
    )

    data class Sprites(
        @SerializedName("back_default")
        var backDefault: String?,
        @SerializedName("back_female")
        var backFemale: String?,
        @SerializedName("back_shiny")
        var backShiny: String?,
        @SerializedName("back_shiny_female")
        var backShinyFemale: String?,
        @SerializedName("front_default")
        var frontDefault: String?,
        @SerializedName("front_female")
        var frontFemale: String?,
        @SerializedName("front_shiny")
        var frontShiny: String?,
        @SerializedName("front_shiny_female")
        var frontShinyFemale: String?
    )

    data class Type(
        @SerializedName("slot")
        var slot: Int?,
        @SerializedName("type")
        var type: Type?
    ) {
        data class Type(
            @SerializedName("name")
            var name: String?,
            @SerializedName("url")
            var url: String?
        )
    }

    data class VersionGroup(
        @SerializedName("name")
        var name: String?,
        @SerializedName("url")
        var url: String?
    )
}