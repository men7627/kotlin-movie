package domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ReservationTest {
    @Test
    @DisplayName("유효한 영화 생성")
    fun Reservation1() {
        val movie = MovieRepository.getMovies()[0]
        Reservation(movie, 1, 1)
    }

    @Test
    @DisplayName("유효하지 않은 영화 생성")
    fun Reservation2() {
        val movie = MovieRepository.getMovies()[0]
        assertThatThrownBy { Reservation(movie, 1, 10) }.isInstanceOf(IllegalArgumentException::class.java)
    }
}