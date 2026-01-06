package christmas.model

object Parser {
    fun parseMenuAndCount(order: String): Map<String, String> {
        val result = order.split(",")
            .map { it.split("-") }
            .associate { it[0] to it[1] }
        return result
    }
}