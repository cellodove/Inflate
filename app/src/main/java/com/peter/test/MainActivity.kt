package com.peter.test

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.peter.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        super.onCreate(savedInstanceState)
        setListener()
    }

    private fun setListener() {
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.value.text = "onProgressChanged : $progress"
                binding.progressBar.progress = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                binding.value.text = "onStartTrackingTouch : ${seekBar!!.progress}"
                binding.progressBar.progress = seekBar.progress
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                binding.value.text = "onStopTrackingTouch : ${seekBar!!.progress}"
                binding.progressBar.progress = seekBar.progress
            }

        })

    }
}