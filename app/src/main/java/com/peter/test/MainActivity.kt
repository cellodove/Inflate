package com.peter.test

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.peter.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var message :String = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        super.onCreate(savedInstanceState)
        setListener()
    }

    private fun setListener() {
        binding.apply {
            dialogButton.setOnClickListener {
                showMessage()
            }
        }
    }

    private fun showMessage(){
        var builder : AlertDialog.Builder = AlertDialog.Builder(this)
                .setTitle("안내").setMessage("종료하시겠습니까?").setIcon(android.R.drawable.ic_dialog_alert)

                .setPositiveButton("예", DialogInterface.OnClickListener {
                    dialog, which ->
                    message= "예버튼이 눌렸습니다"
                    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
                })

                .setNegativeButton("아니오", DialogInterface.OnClickListener {
                    dialog, which ->
                    message= "아니오 버튼이 눌렸습니다"
                    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()

                })
                .setNeutralButton("취소", DialogInterface.OnClickListener {
                    dialog, which ->
                    message= "취소 버튼이 눌렸습니다"
                    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
                })
        var dialog : AlertDialog = builder.create()
        dialog.show()
    }


}