package uk.ac.solent.sql

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var helper: MyHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        helper = MyHelper(this)

        addbut.setOnClickListener{
            val artist = artisttext.text.toString()
            val title = titletext.text.toString()
            val year = yeartext.text.toString().toLong()
            val id = helper.addSong(artist, title, year)
            idtext.setText("$id")
        }
        searchbut.setOnClickListener{
            val Id = idtext.text.toString()
            val SongObject = helper.findSong(Id)

            val Title = SongObject?.title
            val Artist = SongObject?.artist
            val Year = SongObject?.year

            titletext.setText(Title)
            artisttext.setText(Artist)
            yeartext.setText("$Year")

        }

    }

}
