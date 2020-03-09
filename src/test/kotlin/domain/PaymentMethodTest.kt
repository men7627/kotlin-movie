package domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class PaymentMethodTest {

    @Test
    @DisplayName("할인 계산 - 카드")
    fun calculateDiscount1() {
        assertThat(PaymentMethod.CREDIT_CART.calculateDiscount(5000))
            .isEqualTo(4750.0)
    }

    @Test
    @DisplayName("할인 계산 - 현금")
    fun calculateDiscount2() {
        assertThat(PaymentMethod.CASH.calculateDiscount(5000))
            .isEqualTo(4900.0)
    }

    @Test
    @DisplayName("선택 오류 - 범위")
    fun getId() {
        assertThatThrownBy { PaymentMethod.get(3) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("선택 오류")
    }
}