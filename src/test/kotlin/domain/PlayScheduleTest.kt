package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class PlayScheduleTest {

    @Test
    @DisplayName("유효하지 않은 인원 검사")
    fun isInValidNumberOfPerson1() {
        val time = LocalDateTime.of(2020, 3, 1, 12, 0)
        val playSchedule = PlaySchedule(time, 5)

        assertThat(playSchedule.isInValidNumberOfPerson(6)).isTrue()
    }

    @Test
    @DisplayName("유효한 인원 검사")
    fun isInValidNumberOfPerson2() {
        val time = LocalDateTime.of(2020, 3, 1, 12, 0)
        val playSchedule = PlaySchedule(time, 5)

        assertThat(playSchedule.isInValidNumberOfPerson(4)).isFalse()
    }

    @Test
    @DisplayName("한 시간 이내 차이 스케줄 검사")
    fun isOneHourWithinRange1() {
        val time1 = LocalDateTime.of(2020, 3, 1, 12, 0)
        val playSchedule1 = PlaySchedule(time1, 5)

        val time2 = LocalDateTime.of(2020, 3, 1, 12, 55)
        val playSchedule2 = PlaySchedule(time2, 5)

        assertThat(playSchedule1.isOneHourWithinRange(playSchedule2)).isTrue()
    }

    @Test
    @DisplayName("한 시간 이상 차이 스케줄 검사")
    fun isOneHourWithinRange2() {
        val time1 = LocalDateTime.of(2020, 3, 1, 12, 0)
        val playSchedule1 = PlaySchedule(time1, 5)

        val time2 = LocalDateTime.of(2020, 3, 1, 11, 0)
        val playSchedule2 = PlaySchedule(time2, 5)

        assertThat(playSchedule1.isOneHourWithinRange(playSchedule2)).isFalse()
    }
}