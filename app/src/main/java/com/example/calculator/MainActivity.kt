package com.example.calculator

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {
    var reset : Boolean = true
    var input : String = ""
    var operand1: String = ""
    var operand2 : String = ""
    var operation : String = ""

    var finalResult : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn1 : Button = findViewById(R.id.button1)
        var btn2 : Button = findViewById(R.id.button2)
        var btn3 : Button = findViewById(R.id.button3)
        var btn4 : Button = findViewById(R.id.button4)
        var btn5 : Button = findViewById(R.id.button5)
        var btn6 : Button = findViewById(R.id.button6)
        var btn7 : Button = findViewById(R.id.button7)
        var btn8 : Button = findViewById(R.id.button8)
        var btn9 : Button = findViewById(R.id.button9)
        var btn0 : Button = findViewById(R.id.button0)
        var plus : Button = findViewById(R.id.buttonPlus)
        var minus : Button = findViewById(R.id.buttonMinus)
        var mul : Button = findViewById(R.id.buttonMul)
        var div : Button = findViewById(R.id.buttonDiv)
        var sqrt : Button = findViewById(R.id.buttonSqrt)
        var dot : Button = findViewById(R.id.buttonDot)
        var equals : Button = findViewById(R.id.buttonEquals)
        var c : Button = findViewById(R.id.buttonC)
        var ce : Button = findViewById(R.id.buttonCE)
        var textView : TextView = findViewById(R.id.textView)
        var textView2 : TextView = findViewById(R.id.textView2)

        var listener = object : View.OnClickListener {
            override fun onClick(view: View) {
                if (reset) {
                    textView.setText("")
                    textView2.setText("")
                    reset = false
                }
                input = textView.getText().toString()

                when (view.getId()) {
                    R.id.button1 -> input += "1"
                    R.id.button2 -> input += "2"
                    R.id.button3 -> input += "3"
                    R.id.button4 -> input += "4"
                    R.id.button5 -> input += "5"
                    R.id.button6 -> input += "6"
                    R.id.button7 -> input += "7"
                    R.id.button8 -> input += "8"
                    R.id.button9 -> input += "9"
                    R.id.button0 -> input += "0"
                    R.id.buttonDot -> input += "."
                    R.id.buttonC -> {
                        input = ""
                        operand1=""
                        operand2=""
                        operation= ""
                        reset=true
                    }
                    R.id.buttonCE -> {
                        if (input != "") {
                            input = input.substring(0,input.length -1)
                        }
                    }
                    R.id.buttonEquals -> {
                        calc()

                        //Toast.makeText(this@MainActivity,"Completed!",Toast.LENGTH_SHORT).show()
                        Toast.makeText(this@MainActivity,"Completed!",Toast.LENGTH_SHORT).show()

                    }

                }
                textView.setText(input)
                textView2.setText(operand1 + " " + operation + " " + operand2)
                Log.d("MainActivity", "HIER1")
            }

            private fun calc() {
                operand2 = textView.getText().toString()

                when (operation) {
                    "+" -> finalResult = operand1.toDouble() + operand2.toDouble()
                    "-" -> finalResult = operand1.toDouble() - operand2.toDouble()
                    "*" -> finalResult = operand1.toDouble() * operand2.toDouble()
                    "/" -> finalResult = operand1.toDouble() / operand2.toDouble()
                    "sqrt" -> finalResult = sqrt(operand1.toDouble())
                }
                Log.d("MainActivity", "${finalResult}")

                textView.setText(finalResult.toString())
                input = finalResult.toString()
                reset = true
                Log.d("MainActivity", "HIER2")
            }
        }

        btn1.setOnClickListener(listener)
        btn2.setOnClickListener(listener)
        btn3.setOnClickListener(listener)
        btn4.setOnClickListener(listener)
        btn5.setOnClickListener(listener)
        btn6.setOnClickListener(listener)
        btn7.setOnClickListener(listener)
        btn8.setOnClickListener(listener)
        btn9.setOnClickListener(listener)
        btn0.setOnClickListener(listener)
        dot.setOnClickListener(listener)
        c.setOnClickListener(listener)
        ce.setOnClickListener(listener)
        equals.setOnClickListener(listener)

        var operations = object : View.OnClickListener {
            override fun onClick(view: View) {
                reset = true
                operand1 = textView.getText().toString()

                when(view.getId()) {
                    R.id.buttonPlus -> operation = "+"
                    R.id.buttonMinus -> operation = "-"
                    R.id.buttonMul -> operation = "*"
                    R.id.buttonDiv -> operation = "/"
                    R.id.buttonSqrt -> operation = "sqrt"
                }
            }
        }
        plus.setOnClickListener(operations)
        minus.setOnClickListener(operations)
        mul.setOnClickListener(operations)
        div.setOnClickListener(operations)
        sqrt.setOnClickListener(operations)
    }
}