package com.example.diceapp

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

class DiceThrows {

    var diceNumbers = mutableListOf<Int>(1, 5, 6, 1)


    @RequiresApi(Build.VERSION_CODES.O)
    var myThrows = mutableListOf(
        BEDiceThrow(14, diceNumbers),
        BEDiceThrow(15, diceNumbers),
        BEDiceThrow(66, diceNumbers),
        BEDiceThrow(2, diceNumbers)

    )


    fun getThrows() = myThrows
}