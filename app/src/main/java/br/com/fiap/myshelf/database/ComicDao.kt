package br.com.fiap.myshelf.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.fiap.myshelf.model.ComicModel

@Dao
interface ComicDao {

    @Query("SELECT * FROM COMIC")
    suspend fun getComics() : List<ComicModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComic(vararg comic: ComicModel)

    @Query("DELETE FROM COMIC")
    suspend fun deleteAll()

}