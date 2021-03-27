package com.example.task1

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
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
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home->{
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

}


