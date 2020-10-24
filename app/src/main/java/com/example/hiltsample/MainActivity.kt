package com.example.hiltsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.hiltsample.retrofit.ApiService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var truck: Truck

    @Inject
    lateinit var retrofit: Retrofit

    private val viewModel: MyViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Show how to use Hilt in simple way.
        truckDeliverBtn.setOnClickListener {
            truck.deliver()
        }
        // Show how to use Hilt with 3rd party libraries.
        networkRequestBtn.setOnClickListener {
            val apiService = retrofit.create(ApiService::class.java)
            lifecycleScope.launch(Dispatchers.IO) {
                val provinces = apiService.getProvinces()
                for (province in provinces) {
                    println(province.name)
                }
            }
        }
        // Show how to use Hilt with ViewModel.
        viewModelWorkBtn.setOnClickListener {
            viewModel.doWork()
        }
    }

}