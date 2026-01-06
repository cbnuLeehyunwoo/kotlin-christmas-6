package christmas.model

import christmas.model.ErrorMessage

object Validator {
    fun validateDate(date: Int) {

    }

    fun validateOrder(order: Map<String, String>) {
        var menuTotal = 0
        order.forEach { (menu, count) ->
            validateMenu(menu)
            validateMenuCount(count)
            menuTotal += count.toInt()
        }
        checkDuplicateMenu(order.map { it.key })
        checkTotalMenuCount(menuTotal)
    }

    private fun validateMenu(menuName: String) {
        Menu.fromName(menuName)
    }

    private fun validateMenuCount(count: String) {
        val result = count.toIntOrNull()?.let {
            if(it in 1..<20) return
            else throw IllegalArgumentException(ErrorMessage.ERROR_INVALID_MENU_COUNT.getErrorMessage())
        }
        throw IllegalArgumentException(ErrorMessage.ERROR_INVALID_MENU_COUNT.getErrorMessage())

    }

    private fun checkDuplicateMenu(menus: List<String>) {
        if (menus.size != menus.toSet().size)
            throw IllegalArgumentException(ErrorMessage.ERROR_INVALID_MENU.getErrorMessage())
    }

    private fun checkTotalMenuCount(count: Int) {
        if(count <= 20) return
        throw IllegalArgumentException(ErrorMessage.ERROR_INVALID_MENU_COUNT.getErrorMessage())

    }

}