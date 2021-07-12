package br.com.fiap.myshelf.service

import br.com.fiap.myshelf.comic.ComicDataWrapper
import retrofit2.http.GET
import retrofit2.http.Query
import java.security.MessageDigest

val PUBLIC_API_KEY = "a49a1176b9b7bd856631c63768aebb61"
val PRIVATE_API_KEY = "d68545b72a88824201b89256b590304f9248edd2"

interface MarvelService {

    @GET("v1/public/comics")
    suspend fun getComics(
        @Query("apikey") apikey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String
    ) : ComicDataWrapper
}

fun getApiHash(ts: String): String {
    val bytes = MessageDigest
        .getInstance("MD5")
        .digest("${ts}$PRIVATE_API_KEY$PUBLIC_API_KEY".toByteArray())

    return bytes.joinToString("") { "%02x".format(it) }
}
