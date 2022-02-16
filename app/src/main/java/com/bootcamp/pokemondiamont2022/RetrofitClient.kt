package com.bootcamp.pokemondiamont2022

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


class RetrofitClient {

    companion object {
        private val BASE_URL = "https://pokeapi.co"
        private var INSTANCE: PokeApi? = null

        @Synchronized
        fun getInstance(): PokeApi {
            if (INSTANCE == null)
                INSTANCE = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(PokeApi::class.java)
            return INSTANCE as PokeApi
        }
    }
}
interface PokeApi{

    @GET("/api/v2/pokemon/{name}/")
    fun getPokemon(@Path("name") name: String): Call<PokemonModel>

    @GET("/api/v2/pokemon-form/{name}/")
    fun getPokemonForms(@Path("name") name: String): Call<PokemonFormsModel>

    @GET("/api/v2/pokemon/")
    fun getPokemons(@Query("limit") limit: Int,@Query("offset")offset: Int): Call<Pokemons>//ver documentacion de retrofit/querys
}

data class PokemonModel(
    @SerializedName("abilities")
    var abilities: List<Ability?>?,
    @SerializedName("base_experience")
    var baseExperience: Int?,
    @SerializedName("forms")
    var forms: List<Form?>?,
    @SerializedName("game_indices")
    var gameIndices: List<GameIndice?>?,
    @SerializedName("height")
    var height: Int?,
    @SerializedName("held_items")
    var heldItems: List<HeldItem?>?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("is_default")
    var isDefault: Boolean?,
    @SerializedName("location_area_encounters")
    var locationAreaEncounters: String?,
    @SerializedName("moves")
    var moves: List<Move?>?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("order")
    var order: Int?,
    @SerializedName("past_types")
    var pastTypes: List<PastType?>?,
    @SerializedName("species")
    var species: Species?,
    @SerializedName("sprites")
    var sprites: Sprites?,
    @SerializedName("stats")
    var stats: List<Stat?>?,
    @SerializedName("types")
    var types: List<Type?>?,
    @SerializedName("weight")
    var weight: Int?
) {
    data class Ability(
        @SerializedName("ability")
        var ability: Ability?,
        @SerializedName("is_hidden")
        var isHidden: Boolean?,
        @SerializedName("slot")
        var slot: Int?
    ) {
        data class Ability(
            @SerializedName("name")
            var name: String?,
            @SerializedName("url")
            var url: String?
        )
    }

    data class Form(
        @SerializedName("name")
        var name: String?,
        @SerializedName("url")
        var url: String?
    )

    data class GameIndice(
        @SerializedName("game_index")
        var gameIndex: Int?,
        @SerializedName("version")
        var version: Version?
    ) {
        data class Version(
            @SerializedName("name")
            var name: String?,
            @SerializedName("url")
            var url: String?
        )
    }

    data class HeldItem(
        @SerializedName("item")
        var item: Item?,
        @SerializedName("version_details")
        var versionDetails: List<VersionDetail?>?
    ) {
        data class Item(
            @SerializedName("name")
            var name: String?,
            @SerializedName("url")
            var url: String?
        )

        data class VersionDetail(
            @SerializedName("rarity")
            var rarity: Int?,
            @SerializedName("version")
            var version: Version?
        ) {
            data class Version(
                @SerializedName("name")
                var name: String?,
                @SerializedName("url")
                var url: String?
            )
        }
    }

    data class Move(
        @SerializedName("move")
        var move: Move?,
        @SerializedName("version_group_details")
        var versionGroupDetails: List<VersionGroupDetail?>?
    ) {
        data class Move(
            @SerializedName("name")
            var name: String?,
            @SerializedName("url")
            var url: String?
        )

        data class VersionGroupDetail(
            @SerializedName("level_learned_at")
            var levelLearnedAt: Int?,
            @SerializedName("move_learn_method")
            var moveLearnMethod: MoveLearnMethod?,
            @SerializedName("version_group")
            var versionGroup: VersionGroup?
        ) {
            data class MoveLearnMethod(
                @SerializedName("name")
                var name: String?,
                @SerializedName("url")
                var url: String?
            )

            data class VersionGroup(
                @SerializedName("name")
                var name: String?,
                @SerializedName("url")
                var url: String?
            )
        }
    }

    data class PastType(
        @SerializedName("generation")
        var generation: Generation?,
        @SerializedName("types")
        var types: List<Type?>?
    ) {
        data class Generation(
            @SerializedName("name")
            var name: String?,
            @SerializedName("url")
            var url: String?
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
    }

    data class Species(
        @SerializedName("name")
        var name: String?,
        @SerializedName("url")
        var url: String?
    )

    data class Sprites(
        @SerializedName("back_default")
        var backDefault: String?,
        @SerializedName("back_female")
        var backFemale: Any?,
        @SerializedName("back_shiny")
        var backShiny: String?,
        @SerializedName("back_shiny_female")
        var backShinyFemale: Any?,
        @SerializedName("front_default")
        var frontDefault: String?,
        @SerializedName("front_female")
        var frontFemale: Any?,
        @SerializedName("front_shiny")
        var frontShiny: String?,
        @SerializedName("front_shiny_female")
        var frontShinyFemale: Any?,
        @SerializedName("other")
        var other: Other?,
        @SerializedName("versions")
        var versions: Versions?
    ) {
        data class Other(
            @SerializedName("dream_world")
            var dreamWorld: DreamWorld?,
            @SerializedName("home")
            var home: Home?,
            @SerializedName("official-artwork")
            var officialArtwork: OfficialArtwork?
        ) {
            data class DreamWorld(
                @SerializedName("front_default")
                var frontDefault: String?,
                @SerializedName("front_female")
                var frontFemale: Any?
            )

            data class Home(
                @SerializedName("front_default")
                var frontDefault: String?,
                @SerializedName("front_female")
                var frontFemale: Any?,
                @SerializedName("front_shiny")
                var frontShiny: String?,
                @SerializedName("front_shiny_female")
                var frontShinyFemale: Any?
            )

            data class OfficialArtwork(
                @SerializedName("front_default")
                var frontDefault: String?
            )
        }

        data class Versions(
            @SerializedName("generation-i")
            var generationI: GenerationI?,
            @SerializedName("generation-ii")
            var generationIi: GenerationIi?,
            @SerializedName("generation-iii")
            var generationIii: GenerationIii?,
            @SerializedName("generation-iv")
            var generationIv: GenerationIv?,
            @SerializedName("generation-v")
            var generationV: GenerationV?,
            @SerializedName("generation-vi")
            var generationVi: GenerationVi?,
            @SerializedName("generation-vii")
            var generationVii: GenerationVii?,
            @SerializedName("generation-viii")
            var generationViii: GenerationViii?
        ) {
            data class GenerationI(
                @SerializedName("red-blue")
                var redBlue: RedBlue?,
                @SerializedName("yellow")
                var yellow: Yellow?
            ) {
                data class RedBlue(
                    @SerializedName("back_default")
                    var backDefault: String?,
                    @SerializedName("back_gray")
                    var backGray: String?,
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_gray")
                    var frontGray: String?
                )

                data class Yellow(
                    @SerializedName("back_default")
                    var backDefault: String?,
                    @SerializedName("back_gray")
                    var backGray: String?,
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_gray")
                    var frontGray: String?
                )
            }

            data class GenerationIi(
                @SerializedName("crystal")
                var crystal: Crystal?,
                @SerializedName("gold")
                var gold: Gold?,
                @SerializedName("silver")
                var silver: Silver?
            ) {
                data class Crystal(
                    @SerializedName("back_default")
                    var backDefault: String?,
                    @SerializedName("back_shiny")
                    var backShiny: String?,
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_shiny")
                    var frontShiny: String?
                )

                data class Gold(
                    @SerializedName("back_default")
                    var backDefault: String?,
                    @SerializedName("back_shiny")
                    var backShiny: String?,
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_shiny")
                    var frontShiny: String?
                )

                data class Silver(
                    @SerializedName("back_default")
                    var backDefault: String?,
                    @SerializedName("back_shiny")
                    var backShiny: String?,
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_shiny")
                    var frontShiny: String?
                )
            }

            data class GenerationIii(
                @SerializedName("emerald")
                var emerald: Emerald?,
                @SerializedName("firered-leafgreen")
                var fireredLeafgreen: FireredLeafgreen?,
                @SerializedName("ruby-sapphire")
                var rubySapphire: RubySapphire?
            ) {
                data class Emerald(
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_shiny")
                    var frontShiny: String?
                )

                data class FireredLeafgreen(
                    @SerializedName("back_default")
                    var backDefault: String?,
                    @SerializedName("back_shiny")
                    var backShiny: String?,
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_shiny")
                    var frontShiny: String?
                )

                data class RubySapphire(
                    @SerializedName("back_default")
                    var backDefault: String?,
                    @SerializedName("back_shiny")
                    var backShiny: String?,
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_shiny")
                    var frontShiny: String?
                )
            }

            data class GenerationIv(
                @SerializedName("diamond-pearl")
                var diamondPearl: DiamondPearl?,
                @SerializedName("heartgold-soulsilver")
                var heartgoldSoulsilver: HeartgoldSoulsilver?,
                @SerializedName("platinum")
                var platinum: Platinum?
            ) {
                data class DiamondPearl(
                    @SerializedName("back_default")
                    var backDefault: String?,
                    @SerializedName("back_female")
                    var backFemale: Any?,
                    @SerializedName("back_shiny")
                    var backShiny: String?,
                    @SerializedName("back_shiny_female")
                    var backShinyFemale: Any?,
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_female")
                    var frontFemale: Any?,
                    @SerializedName("front_shiny")
                    var frontShiny: String?,
                    @SerializedName("front_shiny_female")
                    var frontShinyFemale: Any?
                )

                data class HeartgoldSoulsilver(
                    @SerializedName("back_default")
                    var backDefault: String?,
                    @SerializedName("back_female")
                    var backFemale: Any?,
                    @SerializedName("back_shiny")
                    var backShiny: String?,
                    @SerializedName("back_shiny_female")
                    var backShinyFemale: Any?,
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_female")
                    var frontFemale: Any?,
                    @SerializedName("front_shiny")
                    var frontShiny: String?,
                    @SerializedName("front_shiny_female")
                    var frontShinyFemale: Any?
                )

                data class Platinum(
                    @SerializedName("back_default")
                    var backDefault: String?,
                    @SerializedName("back_female")
                    var backFemale: Any?,
                    @SerializedName("back_shiny")
                    var backShiny: String?,
                    @SerializedName("back_shiny_female")
                    var backShinyFemale: Any?,
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_female")
                    var frontFemale: Any?,
                    @SerializedName("front_shiny")
                    var frontShiny: String?,
                    @SerializedName("front_shiny_female")
                    var frontShinyFemale: Any?
                )
            }

            data class GenerationV(
                @SerializedName("black-white")
                var blackWhite: BlackWhite?
            ) {
                data class BlackWhite(
                    @SerializedName("animated")
                    var animated: Animated?,
                    @SerializedName("back_default")
                    var backDefault: String?,
                    @SerializedName("back_female")
                    var backFemale: Any?,
                    @SerializedName("back_shiny")
                    var backShiny: String?,
                    @SerializedName("back_shiny_female")
                    var backShinyFemale: Any?,
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_female")
                    var frontFemale: Any?,
                    @SerializedName("front_shiny")
                    var frontShiny: String?,
                    @SerializedName("front_shiny_female")
                    var frontShinyFemale: Any?
                ) {
                    data class Animated(
                        @SerializedName("back_default")
                        var backDefault: String?,
                        @SerializedName("back_female")
                        var backFemale: Any?,
                        @SerializedName("back_shiny")
                        var backShiny: String?,
                        @SerializedName("back_shiny_female")
                        var backShinyFemale: Any?,
                        @SerializedName("front_default")
                        var frontDefault: String?,
                        @SerializedName("front_female")
                        var frontFemale: Any?,
                        @SerializedName("front_shiny")
                        var frontShiny: String?,
                        @SerializedName("front_shiny_female")
                        var frontShinyFemale: Any?
                    )
                }
            }

            data class GenerationVi(
                @SerializedName("omegaruby-alphasapphire")
                var omegarubyAlphasapphire: OmegarubyAlphasapphire?,
                @SerializedName("x-y")
                var xY: XY?
            ) {
                data class OmegarubyAlphasapphire(
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_female")
                    var frontFemale: Any?,
                    @SerializedName("front_shiny")
                    var frontShiny: String?,
                    @SerializedName("front_shiny_female")
                    var frontShinyFemale: Any?
                )

                data class XY(
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_female")
                    var frontFemale: Any?,
                    @SerializedName("front_shiny")
                    var frontShiny: String?,
                    @SerializedName("front_shiny_female")
                    var frontShinyFemale: Any?
                )
            }

            data class GenerationVii(
                @SerializedName("icons")
                var icons: Icons?,
                @SerializedName("ultra-sun-ultra-moon")
                var ultraSunUltraMoon: UltraSunUltraMoon?
            ) {
                data class Icons(
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_female")
                    var frontFemale: Any?
                )

                data class UltraSunUltraMoon(
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_female")
                    var frontFemale: Any?,
                    @SerializedName("front_shiny")
                    var frontShiny: String?,
                    @SerializedName("front_shiny_female")
                    var frontShinyFemale: Any?
                )
            }

            data class GenerationViii(
                @SerializedName("icons")
                var icons: Icons?
            ) {
                data class Icons(
                    @SerializedName("front_default")
                    var frontDefault: String?,
                    @SerializedName("front_female")
                    var frontFemale: Any?
                )
            }
        }
    }

    data class Stat(
        @SerializedName("base_stat")
        var baseStat: Int?,
        @SerializedName("effort")
        var effort: Int?,
        @SerializedName("stat")
        var stat: Stat?
    ) {
        data class Stat(
            @SerializedName("name")
            var name: String?,
            @SerializedName("url")
            var url: String?
        )
    }

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
}


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