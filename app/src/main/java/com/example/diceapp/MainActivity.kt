package com.example.diceapp

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dice_throw_cell.*
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE_ANSWER = 1
    private val gen = Random()


    private var dices: Int = 8478
    private val diceIds = arrayOf(
        0,
        R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6
    )


    var diceNumbers = DiceThrows().diceNumbers


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
                createBoard(dices)
                Log.d("myTag", "board created")

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }


    }

    fun createBoard(value: Int) {
        llDiceBoard.removeAllViewsInLayout()
        for (i in 1..value + 1) {
            val randomNumber = gen.nextInt(6) + 1
            val imageViewDice = ImageView(this)
            imageViewDice.id = i
            imageViewDice.layoutParams = LinearLayout.LayoutParams(150, 150)
            imageViewDice.setImageResource(diceIds[randomNumber])
            llDiceBoard.addView(imageViewDice)
        }
    }

    fun onClickRoll(view: View) {
        createBoard(dices)


        val randomNumebr = gen.nextInt(6) + 1
        val imageViewDice = ImageView(this)


        // imageViewDice.setImageResource(diceIds[leftDice])
//        if (diceThrows.size >= 5)
//            diceThrows.removeAt(0)
        // diceThrows.add(Pair(leftDice, rightDice))
        updateHistory()

        var inflator = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val someDice: ImageView
    }

    fun onClickHistory(view: View) {
        Log.i("myTag", "clicking history")
        val i = Intent(this, HistoryActivity::class.java)
        i.putExtra("numberOfDices", dices)
        startActivity(i)



    }

    private fun updateHistory() {
        var s = ""
        diceNumbers.forEach { p ->
            // val e1 = p.first;
            // val e2 = p.second; s += "$e1 - $e2\n"
            tvHistory.text = s
        }

    }

    fun onClickClear(view: View) {
        diceNumbers.clear()
        updateHistory()

    }

    fun testingButton(view: View) {
        // var customDice = llDiceBoard.findViewById<ImageView>(4)

    }


}


