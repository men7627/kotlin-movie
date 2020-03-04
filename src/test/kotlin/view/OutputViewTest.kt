package view

import domain.*
import org.junit.jupiter.api.Test

internal class OutputViewTest {
    @Test
    internal fun printMovies() {
        OutputView.printMovies(MovieRepository.getMovies())
    }

    @Test
    internal fun printFinalPayment() {
        val movie = MovieRepository.getMovies()[0]
        val reservation = Reservation(movie, 1, 1)
        val reservations = Reservations()
        reservations.addReservation(reservation)
        val payment = Payment(reservations, 0, PaymentMethod.CREDIT_CART)

        OutputView.printFinalPayment(payment)
    }
}