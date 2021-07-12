package br.com.fiap.myshelf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.myshelf.comic.ComicsViewModel
import br.com.fiap.myshelf.adapter.ComicAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var comicRecyclerView: RecyclerView
    private val viewModel: ComicsViewModel by viewModel()
    private val comicAdapter = ComicAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        comicRecyclerView = findViewById(R.id.comicRecyclerView)
        comicRecyclerView.adapter = comicAdapter
        comicRecyclerView.layoutManager = LinearLayoutManager(this)

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.comicsLiveData.observe(this, Observer {
            comicAdapter.updateComics(it)
        })

    }
}