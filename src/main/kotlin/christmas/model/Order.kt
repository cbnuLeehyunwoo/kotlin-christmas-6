package christmas.model

data class Order(
    val menu: Menu,
    val count: Int
) {
    var finalPrice = menu.price
}