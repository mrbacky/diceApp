package com.example.diceapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.dice_throw_cell.view.*

class HistoryAdapter(context: Context, diceThrows: ArrayList<BEDiceThrow>) :
    RecyclerView.Adapter<ThrowHolder>() {

    private var mDataSet: ArrayList<BEDiceThrow> = diceThrows
    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private val diceIds = Constants.diceIds
    private var rowDiceValues: MutableList<Int> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThrowHolder {
        val view: View = mInflater.inflate(R.layout.dice_throw_cell, parent, false)
        return ThrowHolder(view)

    }

    override fun onBindViewHolder(holder: ThrowHolder, position: Int) {
        holder.itemView.llDiceContainer.removeAllViewsInLayout()
        holder.itemView.tvDiceThrowTime.text = mDataSet[position].time
        var rowDiceValues: List<Int> = mDataSet[position].diceValues
        val rowMaxIndex = rowDiceValues.size - 1
        for (i in 0..rowMaxIndex) {
            val imageViewDice = ImageView(holder.itemView.llDiceContainer.context)
            imageViewDice.setImageResource(diceIds[rowDiceValues[i]])
            val params = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            imageViewDice.run {
                layoutParams = params
                layoutParams.height = 120;
                layoutParams.width = 120;
                setPadding(10, 0, 10, 0)
            }
            holder.itemView.llDiceContainer.addView(imageViewDice)
        }
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }


}