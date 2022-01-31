package com.example.penghitungvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtWidth: EditText
    private lateinit var edtHeigth: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvHasil: TextView

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.edt_width)
        edtHeigth = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_lenght)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvHasil = findViewById(R.id.tv_hasil)

        btnCalculate.setOnClickListener(this)
        if(savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvHasil.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvHasil.text.toString())
    }

    override fun onClick(v: View?) {
        if(v?.id==R.id.btn_calculate){
            val inputLength = edtLength.text.toString().trim()
            val inputHeight = edtHeigth.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()

            var isEmptyField = false
            if(inputLength.isEmpty()){
                isEmptyField = true
                edtLength.error = "kolom tidak boleh kosong"
            }
            if(inputHeight.isEmpty()){
                isEmptyField = true
                edtHeigth.error = "kolom tidak boleh kososng"
            }
            if(inputWidth.isEmpty()){
                isEmptyField = true
                edtWidth.error = "kolom tidak boleh kosong"
            }
            if(isEmptyField==false){
                val hasil = inputHeight.toDouble()*inputLength.toDouble()*inputWidth.toDouble()
                tvHasil.text = hasil.toString()
            }
        }
    }
}