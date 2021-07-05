package com.sungbin.mvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.sungbin.mvvmdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val viewModel: TextViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.currentNumber.observe(this, Observer {
            binding.numberTv.text = it.toString()
        })
        viewModel.currentBoolean.observe(this, Observer {
            binding.boolTv.text = it.toString()
        })

        increatmnetText()
    }

    private fun increatmnetText(){
       binding.startBtn.setOnClickListener {
           viewModel.currentNumber.value = ++viewModel.number
           viewModel.currentBoolean.value = viewModel.number % 2 == 0
       }
    }
}