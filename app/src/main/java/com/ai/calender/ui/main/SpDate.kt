package com.ai.calender.ui.main

import java.util.*
import kotlin.collections.ArrayList

class SpDate(
    val calendar: Calendar,
    val rokuyou: Rokuyou,
    val isMi: Boolean,
    val isTuchinohimi: Boolean,
    val isTora: Boolean,
    val isIchiryumanbai: Boolean,
    val isTensha: Boolean
)

enum class Rokuyou(name: String) {
    TOMOBIKI("友引"),
    SENBU("先負"),
    BUTUMETU("仏滅"),
    SENSHOU("先勝"),
    TAIAN("大安"),
    SHAKKU("赤口")
}

fun createSpDateList(): ArrayList<SpDate> {
    return arrayListOf(
        SpDate(toCalendar(2019, 1, 1), Rokuyou.SHAKKU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 2), Rokuyou.SENSHOU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 3), Rokuyou.TOMOBIKI, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 4), Rokuyou.SENBU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 5), Rokuyou.BUTUMETU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 6), Rokuyou.TAIAN, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 7), Rokuyou.SHAKKU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 8), Rokuyou.SENSHOU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 9), Rokuyou.TOMOBIKI, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 10), Rokuyou.SENBU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 11), Rokuyou.BUTUMETU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 12), Rokuyou.TAIAN, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 13), Rokuyou.SHAKKU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 14), Rokuyou.SENSHOU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 15), Rokuyou.TOMOBIKI, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 16), Rokuyou.SENBU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 17), Rokuyou.BUTUMETU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 18), Rokuyou.TAIAN, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 19), Rokuyou.SHAKKU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 20), Rokuyou.SENSHOU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 21), Rokuyou.TOMOBIKI, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 22), Rokuyou.SENBU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 23), Rokuyou.BUTUMETU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 24), Rokuyou.TAIAN, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 25), Rokuyou.SENSHOU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 26), Rokuyou.TOMOBIKI, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 27), Rokuyou.SENBU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 28), Rokuyou.BUTUMETU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 29), Rokuyou.TAIAN, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 30), Rokuyou.SHAKKU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false),
        SpDate(toCalendar(2019, 1, 31), Rokuyou.SENSHOU, isMi = false, isTuchinohimi = false, isTora = false, isIchiryumanbai = false, isTensha = false)
    )
}

fun toCalendar(year: Int, month: Int, day: Int): Calendar {
    val cal = Calendar.getInstance()
    cal.set(Calendar.YEAR, year)
    cal.set(Calendar.MONTH, month - 1)
    cal.set(Calendar.DATE, day)
    return cal
}