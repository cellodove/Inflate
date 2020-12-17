package com.peter.test

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.peter.test.databinding.ActivityMainBinding
import com.peter.test.databinding.Sub1Binding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        super.onCreate(savedInstanceState)
        setListener()
    }

    private fun setListener() {
        binding.apply {
            button.setOnClickListener {
                var inflater : LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                inflater.inflate(R.layout.sub1,container,true)
            }
        }
    }
}