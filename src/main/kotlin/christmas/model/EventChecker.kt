package christmas.model

import christmas.util.CheckDayOfWeek

const val DEFAULT_BENEFIT_VALUE = "없음"

class EventChecker(
    val orders: List<Order>,
    val date: Int
) {
    private val beforePrice = orders.sumOf { it.menu.price * it.count }
    private val benefitList = mutableListOf<Pair<Events, Int>>()
    private var bonusMenu = DEFAULT_BENEFIT_VALUE to 0
    private var totalDiscount = 0
    private var badge = DEFAULT_BENEFIT_VALUE
    fun getBeforePrice() = beforePrice
    fun getTotalBenefit() = totalDiscount
    fun getAfterPrice() = beforePrice - totalDiscount
    fun getBonusMenu() = bonusMenu
    fun getEventBadge() = badge
    fun getBenefitList() = benefitList
    fun checkTotalBenefit() {
        val christmasDiscount = christmasDDayDiscount()
        if (christmasDiscount != 0) benefitList.add(Events.XMASDDAY to christmasDiscount)
        totalDiscount += christmasDiscount

        val normalDayDiscount = normalDayDiscount()
        if (normalDayDiscount != 0) benefitList.add(Events.NORMALDAY to normalDayDiscount)
        totalDiscount += normalDayDiscount

        val endDayDiscount = endDayDiscount()
        if (endDayDiscount != 0) benefitList.add(Events.ENDDAY to endDayDiscount)
        totalDiscount = endDayDiscount

        val specialDayDiscount = specialDiscount()
        if (specialDayDiscount != 0) benefitList.add(Events.SPECIALDAY to specialDayDiscount)
        totalDiscount = specialDayDiscount

        val bonusMenu = checkBonusMenu()
        if (bonusMenu.first != null) {
            benefitList.add(Events.FREEMENU to bonusMenu.first!!.price)
            totalDiscount = bonusMenu.first!!.price
            this.bonusMenu = bonusMenu.first!!.menuName to bonusMenu.second + 1
        }
    }


    private fun checkBonusMenu(): Pair<Menu?, Int> {
        return if (beforePrice >= 120000) {
            return Menu.CHAMPAGIN to 1
        } else null to 1
    }


    private fun christmasDDayDiscount(): Int {
        val baseDiscount = 1000
        val streakDiscount = 100
        return if (date in 1..25) date * streakDiscount + baseDiscount
        else 0
    }

    private fun normalDayDiscount(): Int {
        var totalDiscount = 0
        if (CheckDayOfWeek.isNormalDay(date)) {
            orders.forEach {
                if (it.menu.type == MenuType.DESSERT)
                    totalDiscount += 2023
            }
        }
        return totalDiscount
    }

    private fun endDayDiscount(): Int {
        var totalDiscount = 0
        if (!CheckDayOfWeek.isNormalDay(date)) {
            orders.forEach {
                if (it.menu.type == MenuType.MAIN)
                    totalDiscount += 2023
            }
        }
        return totalDiscount
    }

    private fun specialDiscount(): Int {
        val specialDay = listOf(3, 10, 17, 24, 25, 31)
        return if (date in specialDay) 1000
        else 0
    }

    fun checkEventBadge(): String {
        return when {
            totalDiscount in (5000 until 10001) -> "별"
            totalDiscount in (10001 until 20001) -> "트리"
            totalDiscount >= 20001 -> "산타"
            else -> "없음"
        }
    }
}