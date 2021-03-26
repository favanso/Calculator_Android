package com.famsbprog.class0310

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.famsbprog.class0310.Model.typedValues
import kotlinx.android.synthetic.main.fragment_top.*


class TopFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false)
    }


    fun changeDisplay() {
        if (typedValues.isEmpty()) {
            textOut.text = "0"
        } else
            textOut.text = typedValues


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("saveOut",textOut.text.toString())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(savedInstanceState!=null){
            textOut.text = savedInstanceState.getString("saveOut")
        }
    }















}