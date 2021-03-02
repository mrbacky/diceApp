package com.example.diceapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dice_throw_cell.view.*

class HistoryAdapter(context: Context, diceThrows: List<BEDiceThrow>) :
    RecyclerView.Adapter<ThrowHolder>() {

    private var mDataSet: List<BEDiceThrow> = diceThrows
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThrowHolder {
        val view: View = mInflater.inflate(R.layout.dice_throw_cell, parent, false)
        return ThrowHolder(view)
    }

    override fun onBindViewHolder(holder: ThrowHolder, position: Int) {
        holder.itemView.tvDiceThrowTime.text = mDataSet[position].time.toString()

        for (i in 1..5 + 1) {
            val imageViewDice = ImageView(holder.itemView.llDiceContainer.context)
            imageViewDice.setImageResource(R.drawable.dice1)


            val params = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
//            this.layoutParams = params
//            this.layoutParams.height = 120;
//            this.layoutParams.width = 120;
            imageViewDice.run {
                layoutParams = params
                layoutParams.height = 120;
                layoutParams.width = 120;
                setPadding(10, 0, 10, 0)
            }


//            val layoutParams: ViewGroup.LayoutParams? = null
//
//            if (layoutParams != null) {
//                layoutParams.width = 200
//                layoutParams.height = 200
//            }
//            imageViewDice.layoutParams = layoutParams

            holder.itemView.llDiceContainer.addView(imageViewDice)
        }
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

//    private fun addDices() {
//        val llDiceContainer = Context.findView
//        llDiceContainer.removeAllViewsInLayout()
//        for (i in 1..value + 1) {
//            val randomNumber = gen.nextInt(6) + 1
//            val imageViewDice = ImageView(this)
//            imageViewDice.id = i
//            imageViewDice.layoutParams = LinearLayout.LayoutParams(150, 150)
//            imageViewDice.setImageResource(diceIds[randomNumber])
//            llDiceBoard.addView(imageViewDice)
//        }
//
//


}