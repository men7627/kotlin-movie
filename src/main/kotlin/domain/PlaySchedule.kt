package domain

import utils.DateTimeUtils
import java.time.LocalDateTime

data class PlaySchedule(private val startDateTime: LocalDateTime, private val capacity: Int) {
    fun isInValidNumberOfPerson(numberOfPerson: Int): Boolean {
        return numberOfPerson > capacity
    }

    fun isOneHourWithinRange(playSchedule: PlaySchedule): Boolean {
        return DateTimeUtils.isOneHourWithinRange(startDateTime, playSchedule.startDateTime)
    }
}
