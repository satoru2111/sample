package com.ai.calender.ui.main

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.ai.calender.R
import jp.kuluna.calendarviewpager.CalendarPagerAdapter
import jp.kuluna.calendarviewpager.Day
import jp.kuluna.calendarviewpager.DayState
import java.util.*

class CustomCalendarAdapter(context: Context) : CalendarPagerAdapter(context) {
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
            // 背景
            if (day.isSelected) view.findViewById<ConstraintLayout>(R.id.background).setBackgroundColor(
                Color.GRAY
            )
        } else {
            view.findViewById<TextView>(R.id.text_day).text = ""
        }
    }
}