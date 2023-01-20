package com.thanhnvdn34.uthusapp.presentation.favorite

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.thanhnvdn34.uthusapp.R
import com.thanhnvdn34.uthusapp.databinding.ActivityFavoriteBinding
import com.thanhnvdn34.uthusapp.databinding.ListFavoriteItemBinding
import com.thanhnvdn34.uthusapp.presentation.di.Injector
import javax.inject.Inject

class FavoriteActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: FavoriteViewModelFactory
    private lateinit var viewModel: FavoriteViewModel

    private lateinit var binding: ActivityFavoriteBinding
    private val linearLayoutManager =
        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    
    private var beerFavoriteAdapter = BeerFavoriteAdapter(::updateBeer, ::deleteBeer)
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_favorite)
        (application as Injector).createFavoriteSubComponent()
            .inject(this)

        viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]
        initView()
    }

    private fun initView() {
        binding.rcvFavorite.apply {
            layoutManager = linearLayoutManager
            adapter = beerFavoriteAdapter
        }
        displayFavoriteBeer()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayFavoriteBeer() {
        binding.favoriteProgressBar.visibility = View.VISIBLE
        val responseData = viewModel.getBeersFromDB()
        responseData.observe(this) {
            Log.d("FavoriteActivity", it.toString())
            beerFavoriteAdapter.setList(it)
            binding.favoriteProgressBar.visibility = View.GONE
        }
    }

    fun updateBeer(id: Int, description: String, listFavoriteItemBinding: ListFavoriteItemBinding) {
        binding.favoriteProgressBar.visibility = View.VISIBLE
        val responseData = viewModel.updateBeer(id, description)
        responseData.observe(this) {
            Log.d("FavoriteActivity", "updateBeer")
            binding.favoriteProgressBar.visibility = View.GONE
            listFavoriteItemBinding.descriptionTextView.isCursorVisible = false
        }
    }

    fun deleteBeer(id: Int) {
        binding.favoriteProgressBar.visibility = View.VISIBLE
        val responseData = viewModel.deleteBeer(id)
        responseData.observe(this) {
            Log.d("FavoriteActivity", "deleteBeer")
            binding.favoriteProgressBar.visibility = View.GONE
            displayFavoriteBeer()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}



