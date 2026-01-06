package christmas.view
import camp.nextstep.edu.missionutils.Console

const val INPUT_GUIDE_GREETING = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
const val INPUT_GUIDE_DAY = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
const val INPUT_GUIDE_ORDER = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"

object InputView {
    fun readDate(): Int {
        println(INPUT_GUIDE_GREETING)
        println(INPUT_GUIDE_DAY)
        val input = Console.readLine().toInt()
        return input
    }
    fun readOrder(): String {
        println(INPUT_GUIDE_ORDER)
        val input = Console.readLine()
        return input
    }

}