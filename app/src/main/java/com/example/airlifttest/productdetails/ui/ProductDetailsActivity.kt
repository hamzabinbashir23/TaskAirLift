package com.example.airlifttest.productdetails.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.airlifttest.data.models.ProductModelItem
import com.example.airlifttest.databinding.ActivityProductDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivityProductDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        try {
            val  pop = intent?.getSerializableExtra("ITEM") as ProductModelItem
            binding.itemName.text = pop.title
            binding.itemPrice.text = pop.price.toString()
            binding.itemDetail.text = pop.description
            Glide.with(this)
                .load(pop.image)
                .into(binding.itemImg)
        }
        catch (ex:Exception)
        {ex.printStackTrace()}
    }

    override fun onClick(v: View) {

    }
}