package com.example.task1

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private  var layoutManager: RecyclerView.LayoutManager?= null
    private  var adapter: RecyclerView.Adapter<com.example.task1.Adapter.FoodViewHolder>? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)
        recylerView.layoutManager=layoutManager
        adapter=Adapter()
        recylerView.adapter=adapter
        val displayHomeAsUpEnabled = actionBar?.setDisplayHomeAsUpEnabled(true)

        food_search.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?) :Boolean{
                (adapter as Adapter).filter.filter(newText)
                return false
            }
        })
        val cancelIcon = food_search.findViewById<ImageView>(R.id.search_close_btn)
        cancelIcon.setColorFilter(Color.BLUE)
        val textView = food_search.findViewById<TextView>(R.id.search_src_text)
        textView.setTextColor(Color.WHITE)
        val searchIcon = food_search.findViewById<ImageView>(R.id.search_mag_icon)
        searchIcon.setColorFilter(Color.BLUE)


    }




    }





