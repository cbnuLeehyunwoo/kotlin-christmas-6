package christmas.view

import christmas.model.EventChecker
import java.text.DecimalFormat

const val OUTPUT_GUIDE_MENU = "<주문 메뉴>"
const val OUTPUT_GUIDE_BEFORE_PRICE = "<할인 전 총 주문 금액>"
const val OUTPUT_GUIDE_QUANTITY = "개"
const val OUTPUT_GUIDE_BONUS_MENU = "<증정 메뉴>"
const val OUTPUT_GUIDE_BENEFIT_LIST = "<혜택 내역>"
const val OUTPUT_GUIDE_TOTAL_BENEFIT_AMOUNT = "<총혜택 금액>"
const val OUTPUT_GUIDE_AFTER_PRICE = "<할인 후 예상 결제 금액>"
const val OUTPUT_GUIDE_EVENT_BADGE = "<12월 이벤트 배지>"
const val OUTPUT_GUIDE_MONEY_SCALE = "원"
const val BENEFIT_SEPARATOR = ": "
object OutputView {
    fun printMenu(eventChecker: EventChecker) {
        println(OUTPUT_GUIDE_MENU)
        val orders = eventChecker.orders
        orders.forEach {
            print(it.menu.menuName + it.count)
            println(OUTPUT_GUIDE_QUANTITY)
        }
    }

    fun printBeforePrice(eventChecker: EventChecker) {
        println(OUTPUT_GUIDE_BEFORE_PRICE)
        print(eventChecker.getBeforePrice().toDecimal())
        println(OUTPUT_GUIDE_MONEY_SCALE)
    }

    fun showError(error: String) {
        println(error)
    }

    fun printBenefitList(eventChecker: EventChecker) {
        println(OUTPUT_GUIDE_BENEFIT_LIST)
        eventChecker.getBenefitList()
            .map {
                print(it.first.eventName)
                print(BENEFIT_SEPARATOR)
                print((-1 * it.second).toDecimal())
                println(OUTPUT_GUIDE_MONEY_SCALE)
            }
    }

    fun printBonusMenu(eventChecker: EventChecker) {
        println(OUTPUT_GUIDE_BONUS_MENU)
        val bonusMenu = eventChecker.getBonusMenu()
        println("${bonusMenu.first} ${bonusMenu.second}개")
    }

    fun printTotalBenefit(eventChecker: EventChecker) {
        println(OUTPUT_GUIDE_TOTAL_BENEFIT_AMOUNT)
        print((-1 * eventChecker.getTotalBenefit()).toDecimal())
        println(OUTPUT_GUIDE_MONEY_SCALE)
    }

    fun printAfterPrice(eventChecker: EventChecker) {
        println(OUTPUT_GUIDE_AFTER_PRICE)
        print(eventChecker.getAfterPrice())
        println(OUTPUT_GUIDE_MONEY_SCALE)
    }

    fun printEventBadge(eventChecker: EventChecker) {
        println(OUTPUT_GUIDE_EVENT_BADGE)
        println(eventChecker.getEventBadge())
    }

    fun Int.toDecimal(format : String = "#.###") : String {
        return DecimalFormat(format).format(this)
    }
}
