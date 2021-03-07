package com.example.diceapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var diceThrowsLiveData: MutableLiveData<ArrayList<BEDiceThrow>> = MutableLiveData()
    private var currentRollLiveData: MutableLiveData<BEDiceThrow> = MutableLiveData()


    fun getHistory(): LiveData<ArrayList<BEDiceThrow>> {
        return this.diceThrowsLiveData
    }

    fun setHistory(history: ArrayList<BEDiceThrow>) {
        diceThrowsLiveData.value = history
    }

    fun getCurrentRoll(): LiveData<BEDiceThrow> {
        return this.currentRollLiveData
    }

    fun setCurrentRoll(currentRoll: BEDiceThrow) {
        currentRollLiveData.value = currentRoll
    }

}