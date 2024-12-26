package com.android.hackathon2024_2

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.style.ForegroundColorSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.android.hackathon2024_2.databinding.FragmentCalendarBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.prolificinteractive.materialcalendarview.format.ArrayWeekDayFormatter
import com.prolificinteractive.materialcalendarview.format.MonthArrayTitleFormatter
import com.prolificinteractive.materialcalendarview.format.TitleFormatter

class CalendarFragment : Fragment() {

    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)

        // 월 / 요일을 한글로 보이게 설정
        binding.calendarView.setTitleFormatter(
            MonthArrayTitleFormatter(resources.getTextArray(R.array.custom_months))
        )
        binding.calendarView.setWeekDayFormatter(
            ArrayWeekDayFormatter(resources.getTextArray(R.array.custom_weekdays))
        )

        // 좌우 화살표 사이 연, 월의 폰트 스타일 설정
        binding.calendarView.setHeaderTextAppearance(R.style.CalendarWidgetHeader)

        // 헤더 한글로 포멧
        binding.calendarView.setTitleFormatter(object : TitleFormatter {
            override fun format(day: CalendarDay?): CharSequence {
                return "${day?.year}년 ${day?.month}월"
            }
        })

        var selectedMonthDecorator = SelectedMonthDecorator(requireContext(), CalendarDay.today().month)

        binding.calendarView.addDecorators(selectedMonthDecorator)
        // 현재 달로 초기값 지정
        var selectedMonth: Int = CalendarDay.today().month

        // 월 변경 이벤트 리스너
        binding.calendarView.setOnMonthChangedListener { _, date ->
            selectedMonth = date.month
            Log.d("Calendar", "Month: $selectedMonth")
            binding.calendarView.removeDecorators()
            binding.calendarView.invalidateDecorators()
            selectedMonthDecorator = SelectedMonthDecorator(requireContext(), date.month)
            binding.calendarView.addDecorators(selectedMonthDecorator)
            // 달이 변경될 때마다 그 달의 하이라이트된 날 받아오기
            //fetchHighlightedDate(selectedMonth)
        }

        binding.floatingActionBtn.setOnClickListener {
            val bottomSheet = CustomBottomSheetDialog()
            bottomSheet.show(requireActivity().supportFragmentManager, "RecordBottomSheet")
        }


        return binding.root
    }

    /* 이번달에 속하지 않지만 캘린더에 보여지는 이전달/다음달의 일부 날짜를 설정하는 클래스 */
    private inner class SelectedMonthDecorator(
        private val context: Context,
        val selectedMonth: Int
    ) : DayViewDecorator {
        override fun shouldDecorate(day: CalendarDay): Boolean = day.month != selectedMonth
        override fun decorate(view: DayViewFacade) {
            view.addSpan(ForegroundColorSpan(ContextCompat.getColor(context, R.color.trans_black)))
        }
    }
}