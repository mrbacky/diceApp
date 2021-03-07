package com.example.diceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private val gen = Random()
    private var numberOfSelectedDices = 0
    private val diceIds = Constants.diceIds
    private var history = ArrayList<BEDiceThrow>()
    private var viewModel: MainActivityViewModel? = null
    private var currentRoll: BEDiceThrow? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        initCurrentRollListener()
        initHistoryListener()
        initNumberPickerListener()
        selectTwoDices()
    }

    private fun initCurrentRollListener() {
        viewModel?.getCurrentRoll()
            ?.observe(this, androidx.lifecycle.Observer { currentRollSnapshot ->
                currentRoll = currentRollSnapshot
                putCurrentRoll(currentRoll!!)
            })
    }

    private fun initHistoryListener() {
        viewModel?.getHistory()?.observe(this, androidx.lifecycle.Observer { historySnapshot ->
            history.clear()
            history.addAll(historySnapshot)
        })
    }


    private fun initNumberPickerListener() {
        sDicePicker.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>?,
                    view: View?,
                    value: Int,
                    id: Long
                ) {
                    numberOfSelectedDices = value + 1
                    if (currentRoll == null) {
                        currentRoll = generateBoard(numberOfSelectedDices)
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }
    }

    private fun selectTwoDices() {
        sDicePicker.setSelection(1)
    }


    private fun generateBoard(numberOfDices: Int): BEDiceThrow {
        llDiceBoard.removeAllViewsInLayout()
        val rowDiceCombinations = arrayListOf<Int>()
        for (i in 1..numberOfDices) {
            val randomNumber = gen.nextInt(6) + 1
            putDice(randomNumber)
            rowDiceCombinations.add(randomNumber)
        }
        val simpleDateFormat = SimpleDateFormat("HH:mm:ss")
        val time: String = simpleDateFormat.format(Date())
        return BEDiceThrow(time, rowDiceCombinations)
    }

    private fun putCurrentRoll(currentRoll: BEDiceThrow) {
        llDiceBoard.removeAllViewsInLayout()
        val rowDiceCombinations = currentRoll.diceValues
        for (i in rowDiceCombinations.indices) {
            putDice(rowDiceCombinations[i])
        }
    }

    private fun putDice(num: Int) {
        val imageViewDice = ImageView(this)
        imageViewDice.layoutParams = LinearLayout.LayoutParams(150, 150)
        imageViewDice.setPadding(10, 0, 10, 0)
        imageViewDice.setImageResource(diceIds[num])
        llDiceBoard.addView(imageViewDice)
    }

    fun onClickRoll(view: View) {
        currentRoll = generateBoard(numberOfSelectedDices)
        history.add(currentRoll!!)
    }

    fun onClickHistory(view: View) {
        val i = Intent(this, HistoryActivity::class.java)
        i.putExtra(Constants.HISTORY_ARRAY, history)
        startActivityForResult(i, Constants.REQUEST_CODE_ANSWER)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constants.REQUEST_CODE_ANSWER)
            if (resultCode == RESULT_OK) {
                history.clear()
            }

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel!!.setCurrentRoll(this.currentRoll!!)
        viewModel!!.setHistory(this.history)

    }


}


