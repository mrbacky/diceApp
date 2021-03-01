package com.example.diceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val rwHistory = findViewById<RecyclerView>(R.id.rwHistory)
        rwHistory.layoutManager = LinearLayoutManager(this)
        // rwHistory.adapter = RecyclerAdapter(this,)

    }

    fun onClickBack(view: View) {
        val intent = Intent()
        // intent.putExtra("answer", etAnswer.text.toString())
        // setResult(RESULT_OK, intent)
        finish()

    }
}