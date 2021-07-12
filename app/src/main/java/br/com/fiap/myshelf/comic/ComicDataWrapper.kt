package br.com.fiap.myshelf.comic

import br.com.fiap.myshelf.model.ComicModel

data class ComicDataWrapper(
    val code: Int? = null,
    val status: String? = null,
    val data: ComicDataContainer? = null
)

data class ComicDataContainer(
    val offset: Int? = null,
    val limit: Int? = null,
    val total: Int? = null,
    val count: Int? = null,
    val results: List<ComicModel>? = null
)
