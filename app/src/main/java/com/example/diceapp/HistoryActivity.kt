package com.example.diceapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        Log.wtf("myTag", "more pod")

        val historyAdapter = HistoryAdapter(this, DiceThrows().getThrows())
        rvHistory.adapter = historyAdapter
        rvHistory.layoutManager = LinearLayoutManager(this)

        val dices = intent.extras?.getLong("numberOfDices")
        Log.d("myTag", "$dices")
        Log.d("myTag", "funguje")
        tvTestNumber.setText(dices.toString())


    }

    fun onClickBack(view: View) {
        // val intent = Intent()
        // intent.putExtra("answer", etAnswer.text.toString())
        // setResult(RESULT_OK, intent)
        finish()

    }
}