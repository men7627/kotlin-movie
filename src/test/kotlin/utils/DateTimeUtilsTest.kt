package utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

internal class DateTimeUtilsTest {
    @Test
    @DisplayName("String을 LocalDateTime으로 변환 - 내부 포맷 사용")
    internal fun createDate1() {
        val dateTime = "2020-02-29 12:00"
        val formatter = DateTimeFormatter.ofPattern(DateTimeUtils.PLAYING_TIME_FORMAT)
        val createdLocalDateTime = DateTimeUtils.createDateTime(dateTime)

        println(createdLocalDateTime.toString())
        assertThat(createdLocalDateTime).isEqualTo(
            LocalDateTime.parse(dateTime, formatter)
        )
    }

    @Test
    @DisplayName("String을 LocalDateTime으로 변환 - 포맷 임의 지정")
    internal fun createDate2() {
        val dateTime = "2020-02-29 12:00:22"
        val format = "yyyy-MM-dd HH:mm:ss"
        val createdLocalDateTime = DateTimeUtils.createDateTime(dateTime, format)

        println(createdLocalDateTime)
        assertThat(createdLocalDateTime).isEqualTo(
            LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(format))
        )
    }

    @Test
    @DisplayName("LocalDateTime을 String으로 변환")
    internal fun format() {
        val time = LocalDateTime.of(2020, 2, 29, 12, 0)
        assertThat(DateTimeUtils.format(time)).isEqualTo("2020-02-29 12:00")
    }

    @Test
    @DisplayName("1시간 이내 간격 테스트")
    internal fun isOneHourWithinRange1() {
        val time1 = LocalDateTime.of(2020, 2, 29, 12, 0)
        val time2 = LocalDateTime.of(2020, 2, 29, 12, 55)

        assertThat(DateTimeUtils.isOneHourWithinRange(time1, time2)).isTrue()
    }

    @Test
    @DisplayName("1시간 이상 간격 테스트")
    internal fun isOneHourWithinRange2() {
        val time1 = LocalDateTime.of(2020, 2, 29, 12, 0)
        val time2 = LocalDateTime.of(2020, 2, 29, 13, 5)

        assertThat(DateTimeUtils.isOneHourWithinRange(time1, time2)).isFalse()
    }
}