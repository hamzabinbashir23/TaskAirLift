package com.example.airlifttest.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.airlifttest.data.models.ProductModel
import com.example.airlifttest.network.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelHome @Inject constructor(private val repository: ProductRepository): ViewModel() {

    lateinit var liveDataList : MutableLiveData<ProductModel>
    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver() : MutableLiveData<ProductModel> {
        return liveDataList
    }

    fun loadListOfData(){
        repository.makeApiCall(liveDataList)
    }

}