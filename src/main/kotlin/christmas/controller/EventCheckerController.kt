package christmas.controller

import christmas.model.EventChecker
import christmas.model.Menu
import christmas.model.Order
import christmas.model.Parser
import christmas.model.Validator
import christmas.view.InputView
import christmas.view.OutputView

class EventCheckerController(
) {
    lateinit var eventChecker: EventChecker
    fun run() {
        val validDate = getValidDate()
        val validOrder = getValidOrders()
        eventChecker = EventChecker(validOrder, validDate)
        OutputView.printMenu(eventChecker)
        OutputView.printBeforePrice(eventChecker)
        eventChecker.checkTotalBenefit()
        eventChecker.checkEventBadge()
        printResult()
    }

    fun getValidDate(): Int {
        while (true) {
            try {
                val date = InputView.readDate()
                Validator.validateDate(date)
                return date
            } catch (e: IllegalArgumentException) {
                e.message?.let { OutputView.showError(it) }
            }
        }
    }

    fun getValidOrders(): List<Order> {
        while (true) {
            try {
                val order = InputView.readOrder()
                val parsedOrders = Parser.parseMenuAndCount(order)
                Validator.validateOrder(parsedOrders)
                return parsedOrders.map { Order(Menu.fromName(it.key), it.value.toInt()) }
            } catch (e: IllegalArgumentException) {
                e.message?.let { OutputView.showError(it) }
            }
        }
    }

    fun printResult() {
        OutputView.printBonusMenu(eventChecker)
        OutputView.printBenefitList(eventChecker)
        OutputView.printTotalBenefit(eventChecker)
        OutputView.printAfterPrice(eventChecker)
        OutputView.printEventBadge(eventChecker)
    }

}