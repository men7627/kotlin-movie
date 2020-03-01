package domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ReservationsTest {
    private lateinit var reservations: Reservations

    @BeforeEach
    internal fun setUp() {
        reservations = Reservations()
    }

    @Test
    @DisplayName("첫번째 예약 성공")
    internal fun addReservation1() {
        val reservation = Reservation(MovieRepository.getMovies()[0], 1, 6)
        reservations.addReservation(reservation)
        assertThat(reservations.size()).isEqualTo(1)
    }

    @Test
    @DisplayName("첫번째 예약 실패 - 예약 인원 초과")
    internal fun addReservation2() {
        assertThatThrownBy {
            Reservation(
                MovieRepository.getMovies()[0],
                1,
                7
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("두번째 예약 성공 - 1시간 간격 이내")
    internal fun addReservation3() {
        val reservation1 = Reservation(MovieRepository.getMovies()[0], 1, 6)
        val reservation2 = Reservation(MovieRepository.getMovies()[3], 1, 2)
        reservations.addReservation(reservation1)
        reservations.addReservation(reservation2)

        assertThat(reservations.size()).isEqualTo(2)
    }

    @Test
    @DisplayName("두번째 예약 실패 - 1시간 간격 이상")
    internal fun addReservation4() {
        val reservation1 = Reservation(MovieRepository.getMovies()[0], 1, 6)
        val reservation2 = Reservation(MovieRepository.getMovies()[1], 1, 3)
        reservations.addReservation(reservation1)

        assertThatThrownBy { reservations.addReservation(reservation2) }.isInstanceOf(IllegalArgumentException::class.java)
    }
}