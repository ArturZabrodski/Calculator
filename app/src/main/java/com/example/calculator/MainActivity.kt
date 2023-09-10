package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.*

class MainActivity : AppCompatActivity() {

    lateinit var btnOne: TextView
    lateinit var btnTwo: TextView
    lateinit var btnThree: TextView
    lateinit var btnFour: TextView
    lateinit var btnFive: TextView
    lateinit var btnSix: TextView
    lateinit var btnSeven: TextView
    lateinit var btnEight: TextView
    lateinit var btnNine: TextView
    lateinit var btnZero: TextView
    lateinit var btnDot: TextView
    lateinit var btnClearAll: TextView
    lateinit var btnDeleteLast: TextView
    lateinit var btnOpenBrackets: TextView
    lateinit var btnCloseBrackets: TextView
    lateinit var btnDivide: TextView
    lateinit var btnMultiply: TextView
    lateinit var btnPlus: TextView
    lateinit var btnMinus: TextView
    lateinit var btnEquals: TextView
    lateinit var tvInput: TextView
    lateinit var tvResult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initListeners()
    }

    private fun initViews() {
        btnOne = findViewById(R.id.btn_one)
        btnTwo = findViewById(R.id.btn_two)
        btnThree = findViewById(R.id.btn_three)
        btnFour = findViewById(R.id.btn_four)
        btnFive = findViewById(R.id.btn_five)
        btnSix = findViewById(R.id.btn_six)
        btnSeven = findViewById(R.id.btn_seven)
        btnEight = findViewById(R.id.btn_eight)
        btnNine = findViewById(R.id.btn_nine)
        btnZero = findViewById(R.id.btn_zero)
        btnDot = findViewById(R.id.btn_dot)
        btnClearAll = findViewById(R.id.btn_clean)
        btnDeleteLast = findViewById(R.id.btn_delete_last)
        btnOpenBrackets = findViewById(R.id.btn_open_brackets)
        btnCloseBrackets = findViewById(R.id.btn_close_brackets)
        btnDivide = findViewById(R.id.btn_divide)
        btnMultiply = findViewById(R.id.btn_multiply)
        btnPlus = findViewById(R.id.btn_plus)
        btnMinus = findViewById(R.id.btn_minus)
        btnEquals = findViewById(R.id.btn_equals)
        tvInput = findViewById(R.id.input_view)
        tvResult = findViewById(R.id.result_view)
    }

    private fun initListeners() {
        btnOne.setOnClickListener { addInputNumber(1.toString()) }
        btnTwo.setOnClickListener { addInputNumber(2.toString()) }
        btnThree.setOnClickListener { addInputNumber(3.toString()) }
        btnFour.setOnClickListener { addInputNumber(4.toString()) }
        btnFive.setOnClickListener { addInputNumber(5.toString()) }
        btnSix.setOnClickListener { addInputNumber(6.toString()) }
        btnSeven.setOnClickListener { addInputNumber(7.toString()) }
        btnEight.setOnClickListener { addInputNumber(8.toString()) }
        btnNine.setOnClickListener { addInputNumber(9.toString()) }
        btnZero.setOnClickListener { addInputNumber(0.toString()) }

        btnDot.setOnClickListener { addInputNumber(".") }
        btnOpenBrackets.setOnClickListener { addInputNumber("(") }
        btnCloseBrackets.setOnClickListener { addInputNumber(")") }
        btnDivide.setOnClickListener { addInputNumber("/") }
        btnMultiply.setOnClickListener { addInputNumber("*") }
        btnPlus.setOnClickListener { addInputNumber("+") }
        btnMinus.setOnClickListener { addInputNumber("-") }

        btnClearAll.setOnClickListener {
            tvInput.text = ""
            tvResult.text = ""
        }

        btnDeleteLast.setOnClickListener {
            val tvInputText = tvInput.text.toString()
            if (tvInputText.isNotEmpty())
                tvInput.text = tvInputText.substring(0, tvInputText.length - 1)
        }

        btnEquals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvInput.text.toString()).build()
                val result = expression.evaluate()

                tvResult.text = if (result == result.toLong().toDouble()) {
                    result.toLong().toString()
                } else {
                    result.toString()
                }
            } catch (e: Exception) {
                Log.e("ERROR_TAG", e.message.toString())
            }
        }
    }

    private fun addInputNumber(number: String) {
        tvInput.text = StringBuilder().append(tvInput.text.toString()).append(number)
    }
}