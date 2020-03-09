package domain

class Payment(
    private val reservations: Reservations,
    private val point: Int,
    private val paymentMethod: PaymentMethod
) {
    val finalPayment: Int

    init {
        var purePayment = calculatePurePayment()
        var discountPayment = paymentMethod.calculateDiscount(purePayment).toInt()
        finalPayment = discountPayment - point
    }

    private fun calculatePurePayment(): Int {
        var sum = 0
        reservations.reservations.forEach { sum += it.totalPayment }
        return sum
    }
}
