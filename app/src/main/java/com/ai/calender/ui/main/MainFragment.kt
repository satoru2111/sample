package com.ai.calender.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.format.DateUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.ai.calender.R
import jp.kuluna.calendarviewpager.CalendarViewPager
import jp.kuluna.calendarviewpager.Day
import java.util.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var textMonth: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false).rootView.also {
            textMonth = it.findViewById(R.id.text_month)
            val viewPager = it.findViewById<CalendarViewPager>(R.id.calendar_view_pager)
            viewPager.adapter = CustomCalendarAdapter(requireContext())
            setDateHeader(Calendar.getInstance())

            viewPager.onDayClickListener = { day: Day ->
                Toast.makeText(requireContext(), day.calendar.time.toString(), Toast.LENGTH_SHORT)
                    .show()
            }

            viewPager.onCalendarChangeListener = { calendar: Calendar ->
                setDateHeader(calendar)
            }
        }
    }

    private fun setDateHeader(calendar: Calendar) {
        textMonth.text = DateUtils.formatDateTime(
            requireContext(), calendar.timeInMillis,
            DateUtils.FORMAT_SHOW_YEAR or DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_NO_MONTH_DAY
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        // setup adapter

    }

}
