package com.example.adv160421001week6.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.adv160421001week6.model.Food
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListViewModel(application: Application): AndroidViewModel(application){
    val foodLivesData = MutableLiveData<ArrayList<Food>>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        Log.d("Cek Masuk", "masukvolley")
        queue = Volley.newRequestQueue( getApplication() )

        val url = "http://10.0.2.2/anmp/food.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Food>>() { }.type
                val result = Gson().fromJson<List<Food>>(it, sType)
                foodLivesData.value = result as ArrayList<Food>?
                Log.d("showvoley", it)
            },
            {
                Log.d("showvoley", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}