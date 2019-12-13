package com.ai.calender.ui.main

import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

class SpDate (val calendar: Calendar,val isMi: Boolean,val isTuchinohimi: Boolean, val isTora: Boolean,val isIchiryumanbai: Boolean,val isTensha: Boolean)

fun createSpDateList(): ArrayList<SpDate> {
    return arrayListOf(
        SpDate(
            toCalendar(2019,12,13),
            isMi = false,
            isTuchinohimi = true,
            isTora = false,
            isIchiryumanbai = true,
            isTensha = false
        )
    )
}

fun toCalendar(year: Int, month: Int, day: Int): Calendar {
    val cal = Calendar.getInstance()
    cal.set(Calendar.YEAR, year)
    cal.set(Calendar.MONTH, month - 1)
    cal.set(Calendar.DATE, day)
    return cal
}