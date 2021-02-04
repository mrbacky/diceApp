package com.example.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val gen = Random()
    private val diceIds = arrayOf(
        0,
        R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6
    )

    val history = mutableListOf<Pair<Int, Int>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickRoll(view: View) {
        val leftDice = gen.nextInt(6) + 1
        val rightDice = gen.nextInt(6) + 1

        imgLeftDice.setImageResource(diceIds[leftDice])
        imgRightDice.setImageResource(diceIds[rightDice])


        if (history.size >= 5)
            history.removeAt(0)
        history.add(Pair(leftDice + 1, rightDice + 1))
        updateHistory()

    }

    private fun updateHistory() {
        var s = ""
        history.forEach { p ->
            val e1 = p.first;
            val e2 = p.second; s += "$e1 - $e2\n"
            tvHistory.text = s
        }

    }

    fun onClickClear(view: View) {
        history.clear()
        updateHistory()

    }
}