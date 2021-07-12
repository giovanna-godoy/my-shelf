package br.com.fiap.myshelf.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.myshelf.R
import br.com.fiap.myshelf.model.ComicModel

class ComicAdapter: RecyclerView.Adapter<ComicViewHolder>() {

    private var comics = listOf<ComicModel>()

    fun updateComics(newComics: List<ComicModel>){
        comics = newComics
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.comic_layout, parent, false)

        return ComicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return comics.size
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
       holder.bind(comics[position])
    }

}