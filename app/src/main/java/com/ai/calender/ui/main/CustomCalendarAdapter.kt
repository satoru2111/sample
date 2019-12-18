package com.ai.calender.ui.main

import ajd4jp.Holiday
import ajd4jp.Month
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.ai.calender.R
import jp.kuluna.calendarviewpager.CalendarPagerAdapter
import jp.kuluna.calendarviewpager.Day
import jp.kuluna.calendarviewpager.DayState
import java.util.*
import kotlin.collections.ArrayList


class CustomCalendarAdapter(
    context: Context,
    val spDateList: ArrayList<SpDate>
) : CalendarPagerAdapter(context) {

    override fun onCreateView(parent: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(context).inflate(R.layout.view_calendar_cell, parent, false)
    }

    override fun onBindView(view: View, day: Day) {
        if (day.state == DayState.ThisMonth) {

            // 日付
            view.findViewById<TextView>(R.id.text_day).text =
                day.calendar.get(Calendar.DAY_OF_MONTH).toString()
            // 日付の色指定
            when (day.calendar.get(Calendar.DAY_OF_WEEK)) {
                Calendar.SUNDAY -> view.findViewById<TextView>(R.id.text_day).setTextColor(Color.RED)
                Calendar.SATURDAY -> view.findViewById<TextView>(R.id.text_day).setTextColor(Color.BLUE)
                else -> view.findViewById<TextView>(R.id.text_day).setTextColor(Color.BLACK)
            }

            // 休日
            if (isHoliday(day)) view.findViewById<TextView>(R.id.text_day).setTextColor(Color.RED)

            // 背景
            if (day.isSelected) view.findViewById<ConstraintLayout>(R.id.background).setBackgroundColor(
                Color.GRAY
            )

            spDateList.find {
                it.calendar.get(Calendar.YEAR) == day.calendar.get(Calendar.YEAR) &&
                        it.calendar.get(Calendar.MONTH) == day.calendar.get(Calendar.MONTH) &&
                        it.calendar.get(Calendar.DAY_OF_MONTH) == day.calendar.get(Calendar.DAY_OF_MONTH)
            }?.also {
                if (it.isIchiryumanbai) view.findViewById<ConstraintLayout>(R.id.background).setBackgroundColor(
                    Color.RED
                )
                // 六曜
                view.findViewById<TextView>(R.id.text_rokuyou).text = it.rokuyou.name
            }

        } else {
            view.findViewById<TextView>(R.id.text_day).text = ""
        }
    }

    private fun isHoliday(day: Day): Boolean {
        val days = Month(day.calendar.get(Calendar.YEAR), day.calendar.get(Calendar.MONTH) + 1).days
        var holiday: Holiday? = null
        days.find { it.day == day.calendar.get(Calendar.DAY_OF_MONTH) }?.also {
            holiday = Holiday.getHoliday(it)
        }
        return holiday != null
    }
}

