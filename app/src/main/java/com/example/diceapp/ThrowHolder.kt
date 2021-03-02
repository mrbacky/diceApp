package com.example.diceapp

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ThrowHolder(v: View) : RecyclerView.ViewHolder(v) {

    private var view: View = v
    private var mTime: TextView = v.findViewById(R.id.tvDiceThrowTime)
    private var mDiceContainer: LinearLayout = v.findViewById(R.id.llDiceContainer)



}
