package com.thanhnvdn34.uthusapp.presentation.beer

import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thanhnvdn34.uthusapp.R
import com.thanhnvdn34.uthusapp.data.model.Beer
import com.thanhnvdn34.uthusapp.databinding.ListItemBinding
import java.util.ArrayList

class BeerAdapter(var populateView: (Beer, ListItemBinding) -> Unit) : RecyclerView.Adapter<BeerAdapter.MyViewHolder>() {
    private val beerList = ArrayList<Beer>()
    private val beerListDb = ArrayList<Beer>()

    fun setList(beers: List<Beer>) {
        beerList.clear()
        beerList.addAll(beers)
    }

    fun setListDb(beers: List<Beer>) {
        beerListDb.clear()
        beerListDb.addAll(beers)
    }

    fun addMore(beers: List<Beer>) {
        beerListDb.forEach { itemDb ->
            beers.find {
                it.id == itemDb.id
            }.apply {
                this?.isSave = true
                this?.description = itemDb.description
            }
        }
        beerList.addAll(beers)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(beerList[position])
    }

    override fun getItemCount(): Int {
        return beerList.size
    }

    inner class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(beer: Beer) {
            Log.d("BeerAdapter", beer.toString())
            binding.titleTextView.text = beer.name
            if (!beer.description.isNullOrBlank())
                binding.descriptionTextView.text =
                    Editable.Factory.getInstance().newEditable(beer.description)
            val posterUrl: String = beer.image
            Glide.with(binding.imageView.context)
                .load(posterUrl)
                .into(binding.imageView)

            when (beer.isSave) {
                true -> {
                    binding.descriptionTextView.isEnabled = false
                    binding.saveButton.visibility = View.GONE
                }
                else -> {
                    binding.descriptionTextView.isEnabled = true
                    binding.saveButton.visibility = View.VISIBLE
                }
            }
            binding.saveButton.setOnClickListener {
                populateView.invoke(
                    Beer(
                        beer.id,
                        beer.name,
                        beer.image,
                        null,
                        beer.price,
                        binding.descriptionTextView.text.toString()
                    ), binding
                )
            }
        }
    }
}
