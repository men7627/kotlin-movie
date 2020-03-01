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
        for (reservation in reservations.reservations) {
            sum += reservation.getTotalPayment()
        }
        return sum
    }
}
