package uk.ac.solent.sql

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.view.View.OnClickListener
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.SearchView
import android.view.Menu

class MainActivity : AppCompatActivity() {


    lateinit var helper: MyHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        helper = MyHelper(this)
        setSupportActionBar(toolbar1)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu);
        val item = menu?.findItem(R.id.action_search)
        if(menu==null) {
            Toast.makeText(this, "HELP! menu is null", Toast.LENGTH_SHORT).show()
        } else {
            val sv = MenuItemCompat.getActionView(item) as SearchView

            sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String?): Boolean {
                    return true
                }

                override fun onQueryTextSubmit(query: String?): Boolean {

                    return true
                }
            })
        }
        return true
    }
}
