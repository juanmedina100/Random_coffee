package com.example.randomcoffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.randomcoffee.databinding.ActivityMainBinding
import com.example.randomcoffee.ui.CaffeeViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    val viewModel:CaffeeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.loading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })

        viewModel.getRamdom()
        viewModel.caffee.observe(this, Observer {
            Picasso.get().load(it.file).error(R.drawable.nocaffee).into(binding.imageCaffee)
        })

        binding.imageCaffee.setOnClickListener {
            viewModel.getRamdom()
        }


    }
}