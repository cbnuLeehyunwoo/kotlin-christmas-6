package christmas
import java.io.PrintStream

import christmas.controller.EventCheckerController
import java.nio.charset.Charset

fun main() {
    System.setOut(PrintStream(System.out, true, "UTF-8"))
    val eventCheckerController = EventCheckerController()
    eventCheckerController.run()
}
