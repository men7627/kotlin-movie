package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class PaymentTest {
    @Test
    @DisplayName("최좋 결제 금액 테스트1")
    fun getFinalPayment1() {
        val movie1 = MovieRepository.getMovies()[0]
        val reservation1 = Reservation(movie1, 1, 3)

        val movie2 = MovieRepository.getMovies()[3]
        val reservation2 = Reservation(movie2, 1, 2)

        val reservations = Reservations()
        reservations.addReservation(reservation1)
        reservations.addReservation(reservation2)

        val payment = Payment(reservations, 1000, PaymentMethod.CASH)
        assertThat(payment.finalPayment).isEqualTo(40160)
    }

    @Test
    @DisplayName("최좋 결제 금액 테스트2")
    fun getFinalPayment2() {
        val movie1 = MovieRepository.getMovies()[1]
        val reservation1 = Reservation(movie1, 3, 4)

        val movie2 = MovieRepository.getMovies()[2]
        val reservation2 = Reservation(movie2, 1, 3)

        val reservations = Reservations()
        reservations.addReservation(reservation1)
        reservations.addReservation(reservation2)

        val payment = Payment(reservations, 3000, PaymentMethod.CREDIT_CART)
        assertThat(payment.finalPayment).isEqualTo(60650)
    }
}