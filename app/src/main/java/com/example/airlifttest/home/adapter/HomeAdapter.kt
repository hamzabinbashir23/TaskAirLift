package com.example.airlifttest.home.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.airlifttest.R
import com.example.airlifttest.data.models.ProductModelItem
import com.example.airlifttest.productdetails.ui.ProductDetailsActivity
import kotlinx.android.synthetic.main.item_kios_products.view.*

class HomeAdapter ( private val mContext: Context) : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    private var listData: List<ProductModelItem>? = null




    fun setlistData(listData: List<ProductModelItem>?) {
        this.listData = listData
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeAdapter.MyViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_kios_products, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)

        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, ProductDetailsActivity::class.java)
            intent.putExtra("ITEM", listData?.get(position))
            mContext?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        if(listData ==null)return 0
        return listData?.size!!
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val thumbImage = view.itemImg
        val tvName = view.itemName
        val tvDesc = view.itemPrice

        fun bind(data: ProductModelItem) {
            tvName.text = data.title
            tvDesc.text = data.price.toString()

            Glide.with(thumbImage)
                .load(data.image)
                .into(thumbImage)
        }
    }
}