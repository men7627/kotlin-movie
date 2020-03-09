package domain

import java.util.*

enum class PaymentMethod(val id: Int, private val discountRate: Int) {
    CREDIT_CART(1, 5),
    CASH(2, 2);

    companion object {
        fun get(id: Int): PaymentMethod {
            return Arrays.stream(values())
                .filter { it.id == id }
                .findFirst()
                .orElseThrow { throw IllegalArgumentException("선택 오류") }
        }
    }

    fun calculateDiscount(paymentBeforeDiscount: Int): Double {
        return paymentBeforeDiscount * (1 - discountRate / 100.0)
    }
}