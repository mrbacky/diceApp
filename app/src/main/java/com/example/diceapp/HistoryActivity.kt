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
        val diceThrowHistory: ArrayList<BEDiceThrow>? =
            intent.extras?.getParcelableArrayList<BEDiceThrow>(Constants.HISTORY_ARRAY)
        val historyAdapter = HistoryAdapter(this, diceThrowHistory!!)
        rvHistory.adapter = historyAdapter
        rvHistory.layoutManager = LinearLayoutManager(this)
    }

    fun onClickBack(view: View) {
        finish()
    }

    fun onClickClearHistory(view: View) {
        setResult(RESULT_OK, intent)
        finish()
    }
}