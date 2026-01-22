package com.example.mydictonaryapp.model

import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryAPI {
    @GET(value = "api/v2/entries/en/{word}")

    suspend fun getWordMeaning(
        @Path(value = "word") word: String
    ): List<DictionaryData>
}