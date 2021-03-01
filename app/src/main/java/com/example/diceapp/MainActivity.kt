package com.example.diceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE_ANSWER = 1
    private val gen = Random()

    private var dices = 0
    private val diceIds = arrayOf(
        0,
        R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6
    )

    // var diceThrows = arrayOf<BEDiceThrow>()
    val diceThrows = mutableListOf<Int>()
    var diceValues = mutableListOf<BEDiceThrow>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sDicePicker.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                value: Int,
                id: Long
            ) {
                dices = value
                llDiceBoard.removeAllViewsInLayout()
                createBoard(dices)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun createBoard(value: Int) {
        for (i in 1..value + 1) {
            val imageViewDice = ImageView(this)
            imageViewDice.id = i
            imageViewDice.layoutParams = LinearLayout.LayoutParams(150, 150)
            imageViewDice.setImageResource(R.drawable.dice1)
            llDiceBoard.addView(imageViewDice)
            Log.d("myTag", "$imageViewDice.id")
            Log.d("myTag", "yoyo")

        }
    }

    fun onClickRoll(view: View) {
//        val leftDice = gen.nextInt(6) + 1
//        val rightDice = gen.nextInt(6) + 1
//        imgLeftDice.setImageResource(diceIds[leftDice])
//        imgRightDice.setImageResource(diceIds[rightDice])
//        if (diceThrows.size >= 5)
//            diceThrows.removeAt(0)
//        // diceThrows.add(Pair(leftDice, rightDice))
//        updateHistory()
    }

    fun onClickHistory(view: View) {
        val i = Intent(this, HistoryActivity::class.java)
        // i.putExtra("question", etQuestion.text.toString())
        startActivityForResult(i, REQUEST_CODE_ANSWER)
    }

    private fun updateHistory() {
        var s = ""
        diceThrows.forEach { p ->
            // val e1 = p.first;
            // val e2 = p.second; s += "$e1 - $e2\n"
            tvHistory.text = s
        }

    }

    fun onClickClear(view: View) {
        diceThrows.clear()
        updateHistory()

    }

    fun testingButton(view: View) {
        // var customDice = llDiceBoard.findViewById<ImageView>(4)

    }


}


