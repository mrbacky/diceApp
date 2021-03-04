package com.example.diceapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import java.time.LocalDateTime
import kotlin.collections.ArrayList

@Parcelize
data class BEDiceThrow(
    var time: String,
    var diceValues: List<Int>
) : Parcelable {

}