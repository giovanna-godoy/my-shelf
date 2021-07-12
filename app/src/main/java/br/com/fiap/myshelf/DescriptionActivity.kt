package br.com.fiap.myshelf

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class DescriptionActivity : AppCompatActivity() {

    private lateinit var comicDescriptionText: TextView
    private lateinit var comicTitleText: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val comicTitle = intent.getStringExtra("comicTitle")
        val comicDescription = intent.getStringExtra("comicDescription")

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setHomeButtonEnabled(true);
        supportActionBar?.title = comicTitle;

        comicTitleText = findViewById(R.id.comicTitleText)
        comicDescriptionText = findViewById(R.id.comicDescriptionText)

        comicTitleText.text = "$comicTitle"
        comicDescriptionText.text = "$comicDescription"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
            else -> {
            }
        }
        return true
    }

    override fun onBackPressed() {
        finish()
    }
}