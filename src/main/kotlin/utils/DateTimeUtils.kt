package utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateTimeUtils {
    companion object {
        const val PLAYING_TIME_FORMAT = "yyyy-MM-dd HH:mm"
        private const val ONE_HOURS = 1L

        fun createDateTime(dateTime: String): LocalDateTime {
            return createDateTime(dateTime, PLAYING_TIME_FORMAT)
        }

        fun createDateTime(dateTime: String, format: String): LocalDateTime {
            val formatter = DateTimeFormatter.ofPattern(format)
            return LocalDateTime.parse(dateTime, formatter)
        }

        fun format(dateTime: LocalDateTime): String {
            val formatter = DateTimeFormatter.ofPattern(PLAYING_TIME_FORMAT)
            return dateTime.format(formatter)
        }

        fun isOneHourWithinRange(dateTime1: LocalDateTime, dateTime2: LocalDateTime): Boolean {
            val startDateTime = dateTime1.minusHours(ONE_HOURS)
            val endDateTime = dateTime1.plusHours(ONE_HOURS)
            return dateTime2.isAfter(startDateTime) && dateTime2.isBefore(endDateTime)
        }
    }
}