package christmas.util

import christmas.model.Day

const val FIRST_DAY = 0

object CheckDayOfWeek {
    fun checkDayOfWeek(date: Int): Day {
        val currentDay = (date + FIRST_DAY) % 7
        return Day.fromNumber(currentDay)!!
    }

    fun isNormalDay(date: Int): Boolean {
        return checkDayOfWeek(date).type == "normal"
    }

}

