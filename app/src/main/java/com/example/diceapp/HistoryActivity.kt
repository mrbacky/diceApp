package com.example.diceapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {

    private var deleted = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
//        val numberOfSelectedDices = intent.extras?.getInt("dices")
        val diceThrowHistory: ArrayList<BEDiceThrow>? =
            intent.extras?.getParcelableArrayList<BEDiceThrow>("history")


        val historyAdapter = HistoryAdapter(this, diceThrowHistory!!)
        rvHistory.adapter = historyAdapter
        rvHistory.layoutManager = LinearLayoutManager(this)
        // tvTestNumber.text = dices.toString()


    }

    fun onClickBack(view: View) {
        if (deleted) {
            setResult(RESULT_OK, intent)
            finish()
        } else {
            setResult(RESULT_CANCELED, intent)
            finish()

        }

    }

    fun onClickClearHistory(view: View) {
        rvHistory.adapter = null
        rvHistory.adapter?.notifyDataSetChanged()
        deleted = true


    }
}