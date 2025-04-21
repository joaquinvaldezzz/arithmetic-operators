package com.valdez.arithmeticoperators

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    private lateinit var etFirstNumber: EditText
    private lateinit var etSecondNumber: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etFirstNumber = findViewById(R.id.et_first_number)
        etSecondNumber = findViewById(R.id.et_second_number)
        tvResult = findViewById(R.id.tv_result)
        btnAdd = findViewById(R.id.btn_add)
        btnSubtract = findViewById(R.id.btn_subtract)
        btnMultiply = findViewById(R.id.btn_multiply)
        btnDivide = findViewById(R.id.btn_divide)

        btnAdd.setOnClickListener {
            add(etFirstNumber.text.toString(), etSecondNumber.text.toString())
        }

        btnSubtract.setOnClickListener {
            subtract(etFirstNumber.text.toString(), etSecondNumber.text.toString())
        }

        btnMultiply.setOnClickListener {
            multiply(etFirstNumber.text.toString(), etSecondNumber.text.toString())
        }

        btnDivide.setOnClickListener {
            divide(etFirstNumber.text.toString(), etSecondNumber.text.toString())
        }
    }

    @SuppressLint("SetTextI18n")
    private fun add(firstNumber: String, secondNumber: String) {
        try {
            val result = (firstNumber.toDouble() + secondNumber.toDouble()).toString()
            tvResult.text = result
        } catch (error: NumberFormatException) {
            tvResult.text = "Error: Invalid number format."
        } catch (error: Exception) {
            tvResult.text = "An unexpected error occurred."
            println("Unexpected error: $error")
        }
    }

    @SuppressLint("SetTextI18n")
    private fun subtract(firstNumber: String, secondNumber: String) {
        try {
            val result = (firstNumber.toDouble() - secondNumber.toDouble()).toString()
            tvResult.text = result
        } catch (error: NumberFormatException) {
            tvResult.text = "Error: Invalid number format."
        } catch (error: Exception) {
            tvResult.text = "An unexpected error occurred."
            println("Unexpected error: $error")
        }
    }

    @SuppressLint("SetTextI18n")
    private fun multiply(firstNumber: String, secondNumber: String) {
        try {
            val result = (firstNumber.toDouble() * secondNumber.toDouble()).toString()
            tvResult.text = result
        } catch (error: NumberFormatException) {
            tvResult.text = "Error: Invalid number format."
        } catch (error: Exception) {
            tvResult.text = "An unexpected error occurred."
            println("Unexpected error: $error")
        }
    }

    @SuppressLint("SetTextI18n")
    private fun divide(firstNumber: String, secondNumber: String) {
        try {
            val result = (firstNumber.toDouble() / secondNumber.toDouble()).toString()
            tvResult.text = result
        } catch (error: NumberFormatException) {
            tvResult.text = "Error: Invalid number format."
        } catch (error: Exception) {
            tvResult.text = "An unexpected error occurred."
            println("Unexpected error: $error")
        }
    }
}
