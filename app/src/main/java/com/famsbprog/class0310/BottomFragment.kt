package com.famsbprog.class0310

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.famsbprog.class0310.Model.typedValues
import kotlinx.android.synthetic.main.fragment_bottom.*
import kotlin.math.sqrt


class BottomFragment : Fragment() {

    var listener: DisplayText? = null
    var op="x"
    var newNumber=""
    var oldNumber=""
    var isNewOp = false
    var dot=false
    var isPositive = false


    interface DisplayText{
        fun setDisplayText()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            typedValues.append(savedInstanceState.getString("saveInfo"))
        }

        //Numbers
        btn0.setOnClickListener {
            typedValues.append("0")
            if(isNewOp==false){
            oldNumber= typedValues.toString()}
            else{
                newNumber = typedValues.toString()
            }
            listener?.setDisplayText()
        }
        btn1.setOnClickListener {
            typedValues.append("1")
            if(isNewOp==false){
                oldNumber= typedValues.toString()}
            else{
                newNumber = typedValues.toString()
            }
            listener?.setDisplayText()
        }
        btn2.setOnClickListener {
            typedValues.append("2")
            if(isNewOp==false){
                oldNumber= typedValues.toString()}
            else{
                newNumber = typedValues.toString()
            }
            listener?.setDisplayText()
        }
        btn3.setOnClickListener {
            typedValues.append("3")
            if(isNewOp==false){
                oldNumber= typedValues.toString()}
            else{
                newNumber = typedValues.toString()
            }
            listener?.setDisplayText()
        }
        btn4.setOnClickListener {
            typedValues.append("4")
            if(isNewOp==false){
                oldNumber= typedValues.toString()}
            else{
                newNumber = typedValues.toString()
            }
            listener?.setDisplayText()
        }
        btn5.setOnClickListener {
            typedValues.append("5")
            if(isNewOp==false){
                oldNumber= typedValues.toString()}
            else{
                newNumber = typedValues.toString()
            }
            listener?.setDisplayText()
        }
        btn6.setOnClickListener {
            typedValues.append("6")
            if(isNewOp==false){
                oldNumber= typedValues.toString()}
            else{
                newNumber = typedValues.toString()
            }
            listener?.setDisplayText()
        }
        btn7.setOnClickListener {
            typedValues.append("7")
            if(isNewOp==false){
                oldNumber= typedValues.toString()}
            else{
                newNumber = typedValues.toString()
            }
            listener?.setDisplayText()
        }
        btn8.setOnClickListener {
            typedValues.append("8")
            if(isNewOp==false){
                oldNumber= typedValues.toString()}
            else{
                newNumber = typedValues.toString()
            }
            listener?.setDisplayText()
        }
        btn9.setOnClickListener {
            typedValues.append("9")
            if(isNewOp==false){
                oldNumber= typedValues.toString()}
            else{
                newNumber = typedValues.toString()
            }
            listener?.setDisplayText()
        }

        //DOT
        btnDot.setOnClickListener {
            if (dot == false) {
                typedValues.append(".")
                listener?.setDisplayText()
            }
            dot = true
        }

        //Clear (CE AND C)
        btnCE.setOnClickListener {
            typedValues.clear()
            listener?.setDisplayText()
        }

        btnC.setOnClickListener {
            oldNumber = ""
            newNumber=""
            dot = false
            isNewOp = false
            isPositive = false
            typedValues.clear()
            listener?.setDisplayText()
        } //CLEAR ALL

        //Operations
        btnSum.setOnClickListener {
            op = "+"
            isNewOp = true
            typedValues.clear()
            listener?.setDisplayText()

        }
        btnMinus.setOnClickListener {
            op = "-"
            isNewOp = true
            typedValues.clear()
            listener?.setDisplayText()
        }
        btnMultiply.setOnClickListener {
            op = "*"
            isNewOp = true
            typedValues.clear()
            listener?.setDisplayText()
        }
        btnDivision.setOnClickListener {
            op = "/"
            isNewOp = true
            typedValues.clear()
            listener?.setDisplayText()
        }
        btnModulus.setOnClickListener {
            op = "%"
            isNewOp = true
            typedValues.clear()
            listener?.setDisplayText()
        }

        btnSquare.setOnClickListener {
            typedValues.clear()
            newNumber = (sqrt(oldNumber.toDouble())).toString()
            typedValues.append(newNumber)
            listener?.setDisplayText()
            isNewOp=false
            isPositive = false
            dot = false
        }

        //EQUAL
        btnEqual.setOnClickListener {
            if(!isNewOp){
                typedValues.clear()
                typedValues.append("")
                listener?.setDisplayText()
            }
            else {
                typedValues.clear()
                var finalNumber: Double? = null

                when (op) {
                    "*" -> {
                        finalNumber = oldNumber.toDouble() * newNumber.toDouble()

                    }
                    "/" -> {
                        finalNumber = oldNumber.toDouble() / newNumber.toDouble()

                    }
                    "-" -> {
                        finalNumber = oldNumber.toDouble() - newNumber.toDouble()

                    }
                    "+" -> {
                        finalNumber = oldNumber.toDouble() + newNumber.toDouble()

                    }
                    "%" -> {
                        finalNumber = oldNumber.toDouble() % newNumber.toDouble()

                    }
                }
                var finalText: String = finalNumber.toString()

                typedValues.append(finalText)
                listener?.setDisplayText()
                oldNumber = finalText
                isNewOp = false
                isPositive = false
                dot = false
            }
        }

        //Change Signal
        btnNegative.setOnClickListener {
            if (!isPositive) {
                typedValues.insert(0, "-")
                listener?.setDisplayText()
                isPositive = false
            }
            else{ typedValues.deleteCharAt(0)}
            isPositive = true
        }

    }//End onViewCreated


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("saveInfo", typedValues.toString())
        outState.getString("saveInfo", oldNumber)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is DisplayText){
            listener = context
        }
        else {
            throw RuntimeException(context.toString())
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

}//EndBottomFragment

