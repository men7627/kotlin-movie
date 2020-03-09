package view

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.util.*

internal class InputViewTest {
    @Test
    @DisplayName("영화 id입력 오류 - 범위")
    internal fun inputMovieId() {
        assertThatThrownBy {
            System.setIn(ByteArrayInputStream("2".toByteArray()))
            InputView.inputMovieId()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("영화 스케줄 입력 오류 - 범위")
    internal fun inputPlaySchedule() {
        assertThatThrownBy {
            System.setIn(ByteArrayInputStream("6".toByteArray()))
            InputView.inputPlaySchedule(5)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("예약 인원 입력 오류 - 자료형")
    internal fun inputNumberOfPerson1() {
        assertThatThrownBy {
            System.setIn(ByteArrayInputStream("a".toByteArray()))
            InputView.inputNumberOfPerson(5)
        }.isInstanceOf(InputMismatchException::class.java)
    }

    @Test
    @DisplayName("예약 인원 입력 오류 - 범위")
    internal fun inputNumberOfPerson2() {
        assertThatThrownBy {
            System.setIn(ByteArrayInputStream("7".toByteArray()))
            InputView.inputNumberOfPerson(5)
        }.isInstanceOf(java.lang.IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("추가 예약 오류 - 범위")
    internal fun inputAdditionalReservation() {
        assertThatThrownBy {
            System.setIn(ByteArrayInputStream("3".toByteArray()))
            InputView.inputAdditionalReservation()
        }.isInstanceOf(java.lang.IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("포인트 입력 오류 - 자료형")
    internal fun inputPoint1() {
        assertThatThrownBy {
            System.setIn(ByteArrayInputStream("acd".toByteArray()))
            InputView.inputPoint()
        }.isInstanceOf(InputMismatchException::class.java)
    }

    @Test
    @DisplayName("포인트 입력 오류 - 범위")
    internal fun inputPoint2() {
        assertThatThrownBy {
            System.setIn(ByteArrayInputStream("-1".toByteArray()))
            InputView.inputPoint()
        }.isInstanceOf(java.lang.IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("결제 수단 입력 오류 - 자료형")
    internal fun inputPaymentMethod1() {
        assertThatThrownBy {
            System.setIn(ByteArrayInputStream("q".toByteArray()))
            InputView.inputPaymentMethod()
        }.isInstanceOf(InputMismatchException::class.java)
    }

    @Test
    @DisplayName("결제 수단 입력 오류 - 범위")
    internal fun inputPaymentMethod2() {
        assertThatThrownBy {
            System.setIn(ByteArrayInputStream("3".toByteArray()))
            InputView.inputPaymentMethod()
        }.isInstanceOf(java.lang.IllegalArgumentException::class.java)
    }
}