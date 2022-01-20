package com.example.airlifttest.network

import androidx.lifecycle.MutableLiveData
import com.example.airlifttest.data.models.ProductModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(private val backEndApi: BackEndApi) {


    fun makeApiCall(liveDataList : MutableLiveData<ProductModel>){

        val call : Call<ProductModel> = backEndApi.getProducts()
        call?.enqueue(object : Callback<ProductModel> {
            override fun onResponse(call: Call<ProductModel>, response: Response<ProductModel>) {
                try {

                    if (response?.isSuccessful!!) {
                        liveDataList?.value = response.body()
                    }else {

                    }

                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }

            override fun onFailure(call: Call<ProductModel>, t: Throwable) {
                liveDataList.postValue(null)
            }

        })
    }

}