package christmas.model

enum class ErrorMessage(val message: String) {
    ERROR_PREFIX("[ERROR] "),
    ERROR_INVALID_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ERROR_INVALID_MENU_COUNT("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ERROR_INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    fun getErrorMessage(): String = ERROR_PREFIX.message + this.message

}