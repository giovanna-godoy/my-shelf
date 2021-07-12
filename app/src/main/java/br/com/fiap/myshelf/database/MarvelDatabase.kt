package br.com.fiap.myshelf.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.fiap.myshelf.model.ComicModel

@Database(entities = [ComicModel::class], version = 1)
abstract class MarvelDatabase: RoomDatabase() {
    abstract fun comicDao() : ComicDao
}