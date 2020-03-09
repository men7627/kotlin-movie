package domain

import utils.DateTimeUtils
import java.time.LocalDateTime

data class PlaySchedule(val startDateTime: LocalDateTime, val capacity: Int) {
    fun isInValidNumberOfPerson(numberOfPerson: Int): Boolean {
        return numberOfPerson > capacity
    }

    fun isOneHourWithinRange(playSchedule: PlaySchedule): Boolean {
        return DateTimeUtils.isOneHourWithinRange(startDateTime, playSchedule.startDateTime)
    }

    override fun toString(): String {
        return "시작시간: ${DateTimeUtils.format(startDateTime)} 예약가능인원:$capacity"
    }
}
