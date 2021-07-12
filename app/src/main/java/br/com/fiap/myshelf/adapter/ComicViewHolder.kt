package br.com.fiap.myshelf.adapter

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.myshelf.DescriptionActivity
import br.com.fiap.myshelf.R
import br.com.fiap.myshelf.model.ComicModel
import kotlinx.android.synthetic.main.activity_description.view.*

class ComicViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val comicTitle = itemView.findViewById<TextView>(R.id.comicTitle)

    fun bind(comic: ComicModel) {
        comicTitle.text = comic.title

        itemView.comicLayout.setOnClickListener {
            val intent = Intent(it.context, DescriptionActivity::class.java).apply {
                putExtra("comicTitle", comic.title)
                putExtra("comicDescription", comic.description)
            }
            itemView.context.startActivity(intent)
        }
    }

}