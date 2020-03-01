package domain

enum class PaymentMethod(private val id: Int, private val discountRate: Int) {
    CREDIT_CART(1, 5),
    CASH(2, 2);

    fun calculateDiscount(paymentBeforeDiscount: Int): Double{
        return paymentBeforeDiscount * (1 - discountRate/100.0)
    }
}