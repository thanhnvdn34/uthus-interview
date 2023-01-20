package com.thanhnvdn34.uthusapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.thanhnvdn34.uthusapp.R
import com.thanhnvdn34.uthusapp.databinding.ActivityMainBinding
import com.thanhnvdn34.uthusapp.presentation.beer.BeerActivity
import com.thanhnvdn34.uthusapp.presentation.favorite.FavoriteActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setContentView(binding.root)

        binding.uthusButton.setOnClickListener{
            val intent = Intent(this, BeerActivity::class.java)
            startActivity(intent)
        }

        binding.favoriteButton.setOnClickListener{
            val intent = Intent(this, FavoriteActivity::class.java)
            startActivity(intent)
        }

    }

}