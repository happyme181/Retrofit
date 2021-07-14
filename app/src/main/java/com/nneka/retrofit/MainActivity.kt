package com.nneka.retrofit

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.nneka.retrofit.RetrofitProvider.service
import com.nneka.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        todoAdapter = TodoAdapter(listOf())
        binding.recycView.adapter = todoAdapter

        viewModel = ViewModelProvider (this) [MainViewModel::class.java]

        viewModel.apply {
            getAllTodos()
            items.observe(this@MainActivity,){todos ->
                todoAdapter.lists = todos
                todoAdapter.notifyDataSetChanged()
            }
        }

    }
}