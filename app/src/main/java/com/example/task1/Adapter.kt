package com.example.task1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

// adapter code
class Adapter(private var item: ArrayList<MainActivity.Product>) :RecyclerView.Adapter<Adapter.FoodViewHolder>(),Filterable{
    private var mProductList:ArrayList<MainActivity.Product> =item

    override fun getFilter():Filter{
        return object :Filter(){
            override fun performFiltering(constraint:CharSequence?):FilterResults {
                val charSearch = constraint?.toString()?.toLowerCase()
                val filterResult = Filter.FilterResults()
                filterResult.values = if (charSearch == null || charSearch.isEmpty())
                    mProductList
                else
                    item.filter {
                        it.name.toLowerCase().contains(charSearch)
                    }
                return filterResult
            }



            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                item = results?.values as ArrayList<MainActivity.Product>
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
        return item.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) { // this will bind view holder and size
        holder.Titletext.text=item[position].name
        holder.image.setImageResource(item[position].image)
        val urlss = item[position].url

        holder.itemView.setOnClickListener{v:View -> Unit // click listner for each item
            Toast.makeText(v.context,"You clicked on  ${item[position].image} ", Toast.LENGTH_SHORT).show()
            val intent = Intent(holder.itemView.context,NewActivity::class.java) // this will pass particular url attach with item
            intent.putExtra("URI",urlss)
            holder.itemView.context.startActivity(intent)

        }

    }


}







