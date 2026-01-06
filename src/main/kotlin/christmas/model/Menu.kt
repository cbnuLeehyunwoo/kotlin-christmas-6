package christmas.model
import christmas.model.ErrorMessage
enum class Menu(val menuName: String, val price: Int, val type: MenuType  ) {
    MUSHROOMSOUP("양송이수프", 6000, MenuType.APPETIZER),
    TAPAS("타파스", 5500, MenuType.APPETIZER),
    CEASORSALAD("시저샐러드", 8000, MenuType.APPETIZER),
    TBONSTEAK("티본스테이크", 55000, MenuType.MAIN),
    BBQLIB("바비큐립", 54000, MenuType.MAIN),
    SEAFOODPASTA("해산물파스타", 35000, MenuType.MAIN),
    XMASPASTA("크리스마스파스타", 25000,MenuType.MAIN),
    CHOCOCAKE("초코케이크", 15000, MenuType.DESSERT),
    ICECREAM("아이스크림", 5000, MenuType.DESSERT),
    ZEROCOKE("제로콜라", 3000, MenuType.JUICE),
    REDWINE("레드와인", 60000, MenuType.JUICE),
    CHAMPAGIN("샴페인", 25000, MenuType.JUICE);

    companion object  {
        fun fromName(menuName: String) = entries.find {
            it.menuName == menuName
        }?: throw IllegalArgumentException(ErrorMessage.ERROR_INVALID_MENU.getErrorMessage())
    }
}

enum class MenuType() {
    APPETIZER, MAIN, DESSERT, JUICE
}