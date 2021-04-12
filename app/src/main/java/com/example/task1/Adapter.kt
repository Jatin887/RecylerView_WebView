package com.example.task1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import java.util.*

// adapter code
class Adapter() :RecyclerView.Adapter<Adapter.FoodViewHolder>(),Filterable{
    private val itemTiles = arrayListOf<String>("Paneer Tikka","Tandoori Chicken","Juice","Pizza","Burger","Chowmien","French Fries","Pasta","Caramel Chicken","Dosa","Milk Shake","Chole Batura","Veg Thali","Biryani")
    var foodFilterList = itemTiles

    private val itemImages = intArrayOf(
            R.drawable.panner,
            R.drawable.chicken,
            R.drawable.jucie,
            R.drawable.pizza,
            R.drawable.burger,
            R.drawable.chowmien,
            R.drawable.fries,
            R.drawable.pasta,
            R.drawable.caramelchicken,
            R.drawable.dosa,
            R.drawable.shake,
            R.drawable.cholebatura,
            R.drawable.vegthali,
            R.drawable.biryani

    )
    private val itemUrls = arrayOf(
            "https://www.cookwithmanali.com/paneer-tikka/",
            "https://www.britannica.com/topic/tandoori-chicken",
            "https://www.all-about-juicing.com/",
            "https://www.eatthis.com/pizza-facts/",
            "https://en.wikipedia.org/wiki/Burger",
            "https://en.wikipedia.org/wiki/Chow_mein",
            "https://en.wikipedia.org/wiki/French_fries",
            "https://hebbarskitchen.com/masala-pasta-recipe-indian-pasta-recipes/",
            "https://therecipecritic.com/caramel-chicken/",
            "https://en.wikipedia.org/wiki/Dosa",
            "https://en.wikipedia.org/wiki/Milkshake",
            "https://www.vegrecipesofindia.com/chole-bhature/",
            "https://cookpad.com/in/recipes/4232834-veg-thali",
            "https://en.wikipedia.org/wiki/Biryani"
    )
    override fun getFilter():Filter{
        return object :Filter(){
            override fun performFiltering(constraint:CharSequence?):FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()){
                    foodFilterList=itemTiles
                }
                else{
                    val resultList = arrayListOf<String>()
                    for (row in itemTiles){
                        if (row.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT)))
                            resultList.add(row)
                    }
                    foodFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values=foodFilterList
                return filterResults
            }
            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                foodFilterList = results?.values as ArrayList<String>
                notifyDataSetChanged()
            }
        }
    }
    // View holder
    
    inner class FoodViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var image : ImageView
        var Titletext:TextView


        init {
             image = itemView.findViewById(R.id.image1)
             Titletext  =  itemView.findViewById(R.id.text1)
        }




    }

    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int): FoodViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.row,parent,false) // this will pass the xml file as variable in view holder

        return FoodViewHolder(v)
    }

    override fun getItemCount(): Int { // this will return size of item
        return foodFilterList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) { // this will bind view holder and size
        holder.Titletext.text= itemTiles[position]
        holder.image.setImageResource(itemImages[position])
        val urlss = itemUrls[position]

        holder.itemView.setOnClickListener{v:View -> Unit // click listner for each item
            Toast.makeText(v.context,"You clicked on  ${itemTiles[position]} ", Toast.LENGTH_SHORT).show()
            val intent = Intent(holder.itemView.context,NewActivity::class.java) // this will pass particular url attach with item
            intent.putExtra("URI",urlss)
            holder.itemView.context.startActivity(intent)

        }

    }


}







