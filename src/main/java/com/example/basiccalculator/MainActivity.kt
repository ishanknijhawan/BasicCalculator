package com.example.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    val OP_ADD = 1
    val OP_SUB = 2
    val OP_MUL = 3
    val OP_DIV = 4
    val OP_SQRT = 5
    val OP_POW = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mem:Float = 0.0F
        //var temp:Float = 0.0F
        //var temp2 = 0
        var op = 0
        //var i=0
        var flag=0
        var x=0

        btnClr.setOnClickListener {
            try {
                if(tv.text.toString() == "NaN" || tv.text.toString() == "Infinity" || tv.text.toString() == "Invalid input" ||tv.text.toString() == "" || tv.text.toString() == "0" ) tv.setText("0")
                else tv.text = tv.text.substring(0,tv.length()-1)
                op = 0
            }
            catch (e: NullPointerException){
                tv.setText("0")
            }
        }
        btnClr.setOnLongClickListener {
            tv.setText("0")
            op = 0
            flag=0
            false
        }
        btn7.setOnClickListener {
            if (tv.text == "0" || tv.text == "+" || tv.text == "×" || tv.text == "÷" || tv.text == "-" || tv.text == "^") tv.text = "7"
            else tv.setText(tv.text.toString() + "7")

        }
        btn8.setOnClickListener {
            if (tv.text == "0" || tv.text == "+" || tv.text == "×" || tv.text == "÷" || tv.text == "-" || tv.text == "^") tv.text = "8"
            else tv.setText(tv.text.toString() + "8")

        }
        btn9.setOnClickListener {
            if (tv.text == "0" || tv.text == "+" || tv.text == "×" || tv.text == "÷" || tv.text == "-" || tv.text == "^") tv.text = "9"
            else tv.setText(tv.text.toString() + "9")

        }
        btn4.setOnClickListener {
            if (tv.text == "0" || tv.text == "+" || tv.text == "×" || tv.text == "÷" || tv.text == "-" || tv.text == "^") tv.text = "4"
            else tv.setText(tv.text.toString() + "4")

        }
        btn3.setOnClickListener {
            if (tv.text == "0" || tv.text == "+" || tv.text == "×" || tv.text == "÷" || tv.text == "-" || tv.text == "^") tv.text = "3"
            else tv.setText(tv.text.toString() + "3")

        }
        btn2.setOnClickListener {
            if (tv.text == "0" || tv.text == "+" || tv.text == "×" || tv.text == "÷" || tv.text == "-" || tv.text == "^") tv.text = "2"
            else tv.setText(tv.text.toString() + "2")

        }
        btn1.setOnClickListener {
            if (tv.text == "0" || tv.text == "+" || tv.text == "×" || tv.text == "÷" || tv.text == "-" || tv.text == "^") tv.text = "1"
            else tv.setText(tv.text.toString() + "1")

        }
        btn5.setOnClickListener {
            if (tv.text == "0" || tv.text == "+" || tv.text == "×" || tv.text == "÷" || tv.text == "-" || tv.text == "^") tv.text = "5"
            else tv.setText(tv.text.toString() + "5")

        }
        btn6.setOnClickListener {
            if (tv.text == "0" || tv.text == "+" || tv.text == "×" || tv.text == "÷" || tv.text == "-" || tv.text == "^") tv.text = "6"
            else tv.setText(tv.text.toString() + "6")

        }
        btn0.setOnClickListener {
            if (tv.text == "0" || tv.text == "+" || tv.text == "×" || tv.text == "÷" || tv.text == "-" || tv.text == "^") tv.text = "0"
            else tv.setText(tv.text.toString() + "0")

        }
        btnPt.setOnClickListener {
            while (x < tv.length()) {
                if(tv.text.toString() == ".") flag++
                x++
            }
            try {
                if (flag > 1) return@setOnClickListener
                if (tv.text == "+" || tv.text == "×" || tv.text == "÷" || tv.text == "-" || tv.text == "^") tv.text =
                    "."
                if (tv.text == ".") return@setOnClickListener
                if ((tv.text.get(0).toString() != ".") && (tv.text.get(tv.length() - 1).toString() == ".")) return@setOnClickListener
                else tv.setText(tv.text.toString() + ".")
            }
            catch (e: NumberFormatException){
                tv.setText("Invalid input")
            }

        }

        btnAdd.setOnClickListener {
            try {
            if (op != 0 || flag>1) return@setOnClickListener
            else {
                op = OP_ADD
                //temp = tv.text.toString().toFloat()
                mem = tv.text.toString().toFloat()
                tv.setText("+")
            }}
            catch (e: NumberFormatException){
              tv.setText("Invalid input")
            }}

        btnSub.setOnClickListener {
            try{
            if (op != 0 || flag>1) return@setOnClickListener
            else {
                op = OP_SUB
               // temp = tv.text.toString().toFloat()
                mem = tv.text.toString().toFloat()
                tv.setText("-")
            }}
            catch (e: NumberFormatException){
                tv.setText("Invalid Input")
            }
        }
        btnMul.setOnClickListener {
            try {
            if (op != 0 || flag>1) return@setOnClickListener
            else { op = OP_MUL
               // temp = tv.text.toString().toFloat()
                mem = tv.text.toString().toFloat()
                tv.setText("×")
            }}catch (e: NumberFormatException){
                tv.setText("Invalid Input")
            }}

        btnDiv.setOnClickListener {
            try {
            if (op != 0 || flag>1) return@setOnClickListener
            else {
                op = OP_DIV
               // temp = tv.text.toString().toFloat()
                mem = tv.text.toString().toFloat()
                tv.setText("÷")
            }}
            catch (e: NumberFormatException){
                tv.setText("Invalid Input")
            }}

        btSqrt.setOnClickListener {
            try {
            if (flag>1) return@setOnClickListener
            op = OP_SQRT
            mem = tv.text.toString().toFloat()
            tv.setText((sqrt(mem).toString()))
            op = 0
        } catch (e: NumberFormatException){
                tv.setText("Invalid Input")
            }}


        BtnPow.setOnClickListener {
            try {
            if (op != 0 || flag>1) return@setOnClickListener
            else {
                op = OP_POW
               // temp = tv.text.toString().toFloat()
                mem = tv.text.toString().toFloat()
                tv.setText("^")
            }}
            catch (e: NumberFormatException){
                tv.setText("Invalid Input")
            }}

        BtnPercent.setOnClickListener {
            try {
                if (op == 0 || tv.text == "+" || tv.text == "-" || tv.text == "÷" || tv.text == "×") return@setOnClickListener
                //if (mem == temp) tv.setText(mem.toString())

                when (op) {
                    OP_ADD -> {
                        tv.setText((mem + ((mem * tv.text.toString().toFloat()) / 100)).toString())
                        op = 0
                    }
                    OP_SUB -> {
                        tv.setText((mem - ((mem * tv.text.toString().toFloat()) / 100)).toString())
                        op = 0
                    }
                    OP_MUL -> {
                        tv.setText(((mem * tv.text.toString().toFloat()) / 100).toString())
                        op = 0
                    }
                    OP_DIV -> {
                        try {
                            tv.setText(((mem / tv.text.toString().toFloat()) / 100).toString())
                            op = 0
                        } catch (e: ArithmeticException) {
                            //tv.setText("Invalid Input")
                        }
                    }
                }
            } catch (e: NumberFormatException) {
                tv.setText("Invalid Input")
            }
        }

        btnEq.setOnClickListener {
            if (op == 0 || tv.text == "+" || tv.text == "-"|| tv.text == "÷"|| tv.text == "×" || tv.text == "^") return@setOnClickListener
            //if (mem == temp) tv.setText(mem.toString())

            when(op) {
                OP_ADD -> {
                    tv.setText((mem + tv.text.toString().toFloat()).toString())
                    op = 0
                }
                OP_SUB -> {
                    tv.setText((mem - tv.text.toString().toFloat()).toString())
                    op = 0
                }
                OP_MUL -> {
                    tv.setText((mem * tv.text.toString().toFloat()).toString())
                    op = 0
                }
                OP_DIV -> {
                    try {
                        tv.setText((mem / tv.text.toString().toFloat()).toString())
                        op = 0
                    }
                    catch (e: ArithmeticException) {
                        //tv.setText("Invalid Input")
                    }
                }
                OP_POW -> {
                    try {
                    tv.setText(mem.pow(tv.text.toString().toInt()).toString())
                    op = 0 }
                    catch (e: NumberFormatException){
                        tv.setText("Invalid Input")
                    }
                }
            }
        }

    }
}
