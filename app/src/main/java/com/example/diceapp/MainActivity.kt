package com.example.diceapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dice_throw_cell.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE_ANSWER = 1
    private val DICE_THROWS_ARRAY = "throws"
    private val gen = Random()
    private var numberOfSelectedDices = 2
    private val diceIds = Constants.diceIds
    private var diceThrowsHistory = arrayListOf<BEDiceThrow>()

    fun onClickHistory(view: View) {
        val i = Intent(this, HistoryActivity::class.java)
        i.putExtra("dices", numberOfSelectedDices)
        i.putExtra("history", diceThrowsHistory)
        startActivityForResult(i, REQUEST_CODE_ANSWER)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.d("debug", "I am in onActivityResult fun")

        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ANSWER)
            if (resultCode == RESULT_OK) {
                diceThrowsHistory.clear()

            }

    }


    // create view model
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Log.i("debug", "$diceThrowsHistory and ${diceThrowsHistory.size}")
        setContentView(R.layout.activity_main)
        createBoard(2)
        sDicePicker.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                value: Int,
                id: Long
            ) {

                numberOfSelectedDices = value + 1
                createBoard(numberOfSelectedDices)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }


    }

    fun createBoard(value: Int) {
        llDiceBoard.removeAllViewsInLayout()
        for (i in 1..value) {
            putDice(i)
        }
    }

    private fun putDice(i: Int) {
        val randomNumber = gen.nextInt(6) + 1
        val imageViewDice = ImageView(this)
        imageViewDice.id = i
        imageViewDice.layoutParams = LinearLayout.LayoutParams(150, 150)
        imageViewDice.setPadding(10, 0, 10, 0)
        imageViewDice.setImageResource(diceIds[randomNumber])
        llDiceBoard.addView(imageViewDice)
    }

    fun onClickRoll(view: View) {
        llDiceBoard.removeAllViewsInLayout()

        val rowDiceCombinations = arrayListOf<Int>()

        for (i in 1..numberOfSelectedDices) {
            val randomNumber = gen.nextInt(6) + 1
            val imageViewDice = ImageView(this)
            imageViewDice.id = i
            imageViewDice.layoutParams = LinearLayout.LayoutParams(150, 150)
            imageViewDice.setPadding(10, 0, 10, 0)
            imageViewDice.setImageResource(diceIds[randomNumber])
            llDiceBoard.addView(imageViewDice)

            rowDiceCombinations.add(randomNumber)
        }

        val simpleDateFormat = SimpleDateFormat("HH:mm:ss")
        val time: String = simpleDateFormat.format(Date())

        println("$time ------------------------")
        val diceThrow = BEDiceThrow(time, rowDiceCombinations)
        diceThrowsHistory.add(diceThrow)

    }


    private fun updateHistory() {
//        var s = ""
//        diceNumbers.forEach { p ->
//            // val e1 = p.first;
//            // val e2 = p.second; s += "$e1 - $e2\n"
//            tvHistory.text = s
//        }

    }

    fun onClickClear(view: View) {
        updateHistory()

    }

    fun testingButton(view: View) {
//        diceThrowsHistory.add(BEDiceThrow(1, listOf(1, 6, 2, 2)))
//        Log.d("debug", "$diceThrowsHistory and ${diceThrowsHistory.size}")
        createBoard(numberOfSelectedDices)
    }


}


