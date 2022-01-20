package com.example.airlifttest.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.airlifttest.R
import com.example.airlifttest.data.models.ProductModelItem
import com.example.airlifttest.databinding.ActivityHomeBinding
import com.example.airlifttest.home.adapter.HomeAdapter
import com.example.airlifttest.home.viewmodel.ViewModelHome
import com.facebook.shimmer.ShimmerFrameLayout
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHomeBinding


    var vmProduct : ViewModelHome? = null

    private val mShimmerViewContainer: ShimmerFrameLayout? = null

    lateinit var homeAdapter: HomeAdapter

   // lateinit var recyclerViewAdapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vmProduct = ViewModelProvider(this).get(ViewModelHome::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        //   init()
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        //  binding.kiosProductRv.layoutManager = LinearLayoutManager(this)
        homeAdapter = HomeAdapter(this)
        binding.kiosProductRv.adapter = homeAdapter
    }


    private fun initViewModel() {
        val viewModel:ViewModelHome = ViewModelProvider(this).get(ViewModelHome::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if(it != null) {
                binding.shimmerViewContainer.stopShimmer()
                binding.shimmerViewContainer.visibility = View.GONE
                homeAdapter.setlistData(it)
                homeAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "error in getting data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.loadListOfData()

    }

//    private fun init() {
//        try {
//
//
//
//            vmProduct?.getLiveDataObserver()?.observe(this, {
//                if (it !=null){
//                    homeAdapter.setListData(it)
//                    homeAdapter.notifyDataSetChanged()
//
//                }else {
//                    Toast.makeText(this,"error", Toast.LENGTH_SHORT)
//                }
//            })
//            vmProduct?.loadListOfData()
//            binding.shimmerViewContainer.stopShimmer()
//            binding.shimmerViewContainer.visibility = View.GONE
//
//        } catch (ex: Exception) {
//            ex.printStackTrace()
//        }
//    }

    override fun onClick(v: View) {

        when (v.id) {


        }
    }

    override fun onResume() {
        super.onResume()
        binding.shimmerViewContainer.startShimmer()
    }

    override fun onPause() {
        binding.shimmerViewContainer.stopShimmer()
        super.onPause()
    }
}