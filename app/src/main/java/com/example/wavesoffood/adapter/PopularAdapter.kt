package com.example.wavesoffood.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.DetailsActivity
import com.example.wavesoffood.databinding.PopularItemListBinding

class PopularAdapter(private val items: List<String>,private val price: List<String>,private val image:List<Int>, private val requireContext: Context): RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {
    class PopularViewHolder (private val binding: PopularItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imageView = binding.imageView6
        fun bind(item: String,image: Int, price: String) {
            binding.foodNamePopular.text = item
            binding.PricePopular.text = price
            imageView.setImageResource(image)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val price = price[position]
        val image = image[position]
        holder.bind(item,image,price)
        holder.itemView.setOnClickListener {
            val intent = Intent(requireContext, DetailsActivity::class.java)
            intent.putExtra("MenuItemName",item)
            intent.putExtra("MenuItemImage",image)
            requireContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}