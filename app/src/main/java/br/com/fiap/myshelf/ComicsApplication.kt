package br.com.fiap.myshelf

import android.app.Application
import android.content.Context
import androidx.room.Room
import br.com.fiap.myshelf.comic.ComicsViewModel
import br.com.fiap.myshelf.service.MarvelService
import br.com.fiap.myshelf.database.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ComicsApplication: Application() {

    private val comicsModule = module {
        single { provideRetrofit() }
        single { provideMarvelService(get()) }
        single { provideMarvelDatabase(get()) }
        single { provideComicDao(get()) }
        viewModel { ComicsViewModel(get(), get()) }
    }

    private fun provideRetrofit() : Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com:443/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }

    private fun provideMarvelService(retrofit: Retrofit) : MarvelService {
        return retrofit.create(MarvelService::class.java)
    }

    private fun provideMarvelDatabase(context: Context): MarvelDatabase {
        return Room
            .databaseBuilder(context, MarvelDatabase::class.java,"marveldatabase")
            .build()
    }

    private fun provideComicDao(database: MarvelDatabase): ComicDao {
        return database.comicDao()
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ComicsApplication)
            modules(comicsModule)
        }
    }
}