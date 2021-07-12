package br.com.fiap.myshelf.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "COMIC")
data class ComicModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String? = null,
    val description: String? = null
)