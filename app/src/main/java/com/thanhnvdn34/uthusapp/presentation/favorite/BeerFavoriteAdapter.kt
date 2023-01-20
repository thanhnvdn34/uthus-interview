package com.thanhnvdn34.uthusapp.presentation.favorite

import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thanhnvdn34.uthusapp.R
import com.thanhnvdn34.uthusapp.data.model.Beer
import com.thanhnvdn34.uthusapp.databinding.ListFavoriteItemBinding
import java.util.ArrayList

class BeerFavoriteAdapter(
    var updateBeer: (Int, String, ListFavoriteItemBinding) -> Unit,
    var deleteBeer: (Int) -> Unit
) : RecyclerView.Adapter<BeerFavoriteAdapter.MyFavoriteViewHolder>() {

    private val beerList = ArrayList<Beer>()

    fun setList(beers: List<Beer>) {
        beerList.clear()
        beerList.addAll(beers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFavoriteViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListFavoriteItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_favorite_item, parent, false)
        return MyFavoriteViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: MyFavoriteViewHolder, position: Int) {
        holder.bind(beerList[position])
    }

    override fun getItemCount(): Int {
        return beerList.size
    }

    inner class MyFavoriteViewHolder(val binding: ListFavoriteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(beer: Beer) {
            Log.d("BeerFavoriteAdapter", beer.toString())
            binding.titleTextView.text = beer.name
            if (!beer.description.isNullOrBlank())
                binding.descriptionTextView.text =
                    Editable.Factory.getInstance().newEditable(beer.description)
            val posterUrl: String = beer.image
            Glide.with(binding.imageView.context)
                .load(posterUrl)
                .into(binding.imageView)

            binding.updateButton.setOnClickListener {
                updateBeer.invoke(beer.id, binding.descriptionTextView.text.toString(), binding)
            }
            binding.deleteButton.setOnClickListener {
                deleteBeer.invoke(beer.id)
            }
        }
    }
}
