package view

import domain.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class OutputViewTest {
    @Test
    @DisplayName("전체 영화 출력")
    internal fun printMovies() {
        OutputView.printMovies(MovieRepository.getMovies())
    }

    @Test
    @DisplayName("해당 영화 스케줄 출력")
    internal fun printPlaySchedule() {
        val movie1 = MovieRepository.getMovies()[0]
        OutputView.printPlaySchedule(movie1)
    }

    @Test
    @DisplayName("예약 목록 출력")
    internal fun printReservations() {
        val reservations = Reservations()

        val movie1 = MovieRepository.getMovies()[0]
        val reservation1 = Reservation(movie1, 1, 1)
        reservations.addReservation(reservation1)



        val movie2 = MovieRepository.getMovies()[3]
        val reservation2 = Reservation(movie2, 1, 2)
        reservations.addReservation(reservation2)

        OutputView.printReservations(reservations)
    }

    @Test
    @DisplayName("최종 금액 출력")
    internal fun printFinalPayment() {
        val movie = MovieRepository.getMovies()[0]
        val reservation = Reservation(movie, 1, 1)
        val reservations = Reservations()
        reservations.addReservation(reservation)
        val payment = Payment(reservations, 0, PaymentMethod.CREDIT_CART)

        OutputView.printFinalPayment(payment.finalPayment)
    }
}