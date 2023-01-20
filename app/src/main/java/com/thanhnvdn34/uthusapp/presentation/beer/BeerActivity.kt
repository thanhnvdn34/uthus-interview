package com.thanhnvdn34.uthusapp.presentation.beer

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thanhnvdn34.uthusapp.R
import com.thanhnvdn34.uthusapp.data.model.Beer
import com.thanhnvdn34.uthusapp.databinding.ActivityDataBinding
import com.thanhnvdn34.uthusapp.databinding.ListItemBinding
import com.thanhnvdn34.uthusapp.presentation.di.Injector
import com.thanhnvdn34.uthusapp.presentation.extension.loadMoreListener
import javax.inject.Inject

class BeerActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: BeerViewModelFactory
    private lateinit var viewModel: BeerViewModel

    private lateinit var binding: ActivityDataBinding
    private val linearLayoutManager =
        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    private var beerAdapter = BeerAdapter(::populateView)

    private var page = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data)
        (application as Injector).createBeerSubComponent()
            .inject(this)

        viewModel = ViewModelProvider(this, factory)[BeerViewModel::class.java]
        page = 0
        initView()
    }

    private fun initView() {
        binding.rcvBeer.apply {
            layoutManager = linearLayoutManager
            adapter = beerAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                }

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    linearLayoutManager.loadMoreListener {
                        displayPopularBeer()
                    }
                }
            })
        }

        initData()
    }

    private fun initData() {
        binding.beerProgressBar.visibility = View.VISIBLE
        val responseData = viewModel.getBeersFromDB()
        responseData.observe(this) {
            Log.d("initData", it.toString())
            beerAdapter.setListDb(it)
            binding.beerProgressBar.visibility = View.GONE
            displayPopularBeer()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayPopularBeer() {
        page++
        when (page > 9) {
            true -> Unit
            else -> {
                binding.beerProgressBar.visibility = View.VISIBLE
                val responseData = viewModel.getBeers(page)
                responseData.observe(this) {
                    Log.d("BeerActivity", it.toString())
                    if (it != null) {
                        beerAdapter.addMore(it)
                        beerAdapter.notifyDataSetChanged()
                    } else {
                        Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG)
                            .show()
                    }
                    binding.beerProgressBar.visibility = View.GONE
                }
            }
        }
    }

    fun populateView(beer: Beer, listItemBinding: ListItemBinding) {
        listItemBinding.saveButton.text = "Saving"
        val responseData = viewModel.saveBeerToDB(beer)
        responseData.observe(this) {
            Log.d("initData", it.toString())
            listItemBinding.saveButton.visibility = View.GONE
            listItemBinding.descriptionTextView.apply {
                this.isEnabled = false
                this.isCursorVisible = false
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
