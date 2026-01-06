package christmas.model

enum class Events(val eventName: String) {
    XMASDDAY("크리스마스 디데이 할인"),
    NORMALDAY("평일 할인"),
    ENDDAY("주말 할인"),
    FREEMENU("증정 이벤트"),
    SPECIALDAY("특별 할인"),
    INVALID("유효하지 않은 이벤트");
    companion object  {
        fun fromName(eventName: String) = entries.find {
            it.eventName == eventName
        } ?: Events.INVALID
    }
}