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
    private lateinit var adapter:Adapter
    data class Product(
         var name:String,
         var image:Int,
         var url:String
    )
    private  var productList= arrayListOf(
                Product("Paneer Tikka",R.drawable.panner,"https://www.cookwithmanali.com/paneer-tikka/"),
                Product("Tandoori Chicken",R.drawable.chicken,"https://www.britannica.com/topic/tandoori-chicken"),
                Product("Juice",R.drawable.jucie,"https://www.all-about-juicing.com/"),
                Product("Pizza",R.drawable.pizza,"https://www.eatthis.com/pizza-facts/"),
                Product("Burger",R.drawable.burger,"https://en.wikipedia.org/wiki/Burger"),
                Product("Chowmien",R.drawable.chowmien,"https://en.wikipedia.org/wiki/Chow_mein"),
                Product("French Fries", R.drawable.fries,"https://en.wikipedia.org/wiki/French_fries"),
                Product("Pasta",R.drawable.pasta,"https://www.cookwithmanali.com/paneer-tikka/"),
                Product("Caramel Chicken",R.drawable.caramelchicken,"https://hebbarskitchen.com/masala-pasta-recipe-indian-pasta-recipes/"),
                Product("Dosa",R.drawable.dosa,"https://en.wikipedia.org/wiki/Dosa"),
                Product("Milk Shake",R.drawable.shake,"https://en.wikipedia.org/wiki/Milkshake"),
                Product("Chole Batura",R.drawable.cholebatura,"https://www.vegrecipesofindia.com/chole-bhature/"),
                Product("Veg Thali",R.drawable.vegthali,"https://cookpad.com/in/recipes/4232834-veg-thali"),
                Product("Biryani",R.drawable.biryani,"https://en.wikipedia.org/wiki/Biryani")


    )





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)
        recylerView.layoutManager=layoutManager
        adapter= Adapter(productList)
        recylerView.adapter=adapter
        val displayHomeAsUpEnabled = actionBar?.setDisplayHomeAsUpEnabled(true)

        food_search.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?) :Boolean{
                adapter.filter.filter(newText)
                return false
            }
        })
        val cancelIcon = food_search.findViewById<ImageView>(R.id.search_close_btn)
        cancelIcon.setColorFilter(Color.BLUE)
        val textView = food_search.findViewById<TextView>(R.id.search_src_text)
        textView.setTextColor(Color.RED)
        val searchIcon = food_search.findViewById<ImageView>(R.id.search_mag_icon)
        searchIcon.setColorFilter(Color.BLUE)


    }




    }





