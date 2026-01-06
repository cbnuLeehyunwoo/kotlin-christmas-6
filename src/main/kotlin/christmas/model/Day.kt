package christmas.model

enum class Day(val number: Int, val type: String) {
    MONDAY(0, "normal"),
    TUESDAY(1, "normal"),
    WEDNESDAY(2, "normal"),
    THURSDAY(3, "normal"),
    FRIDAY(4, "end"),
    SATURDAY(5, "end"),
    SUNDAY(6, "normal");

    companion object {
        fun fromNumber(number: Int) = entries.find { number == it.number }

    }
}
