package br.com.fiap.myshelf.comic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.myshelf.database.ComicDao
import br.com.fiap.myshelf.model.ComicModel
import br.com.fiap.myshelf.service.MarvelService
import br.com.fiap.myshelf.service.PUBLIC_API_KEY
import br.com.fiap.myshelf.service.getApiHash
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class ComicsViewModel(
    private val service: MarvelService,
    private val comicDao: ComicDao
): ViewModel() {

    val comicsLiveData = MutableLiveData<List<ComicModel>>()
    val error = MutableLiveData<Boolean>()

    init {
        getComics()
    }

    private fun getComics() {

        viewModelScope.launch(Dispatchers.IO) {

            try {

                val cacheData = comicDao.getComics()
                comicsLiveData.postValue(cacheData)

                val ts = Date().time.toString()
                val hash = getApiHash(ts)

                val comicDataWrapper = service.getComics(PUBLIC_API_KEY, ts, hash)
                comicsLiveData.postValue(comicDataWrapper.data?.results)

                comicDao.deleteAll()
                comicDao.insertComic(*comicDataWrapper.data?.results?.toTypedArray()!!)

            } catch (t: Throwable) {
                error.postValue(true)
            }
        }
    }
}