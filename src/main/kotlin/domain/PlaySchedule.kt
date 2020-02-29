package domain

import utils.DateTimeUtils
import java.time.LocalDateTime

data class PlaySchedule(private val startDateTime: LocalDateTime, private val capacity: Int) {
    fun isInValidNumberOfPerson(numberOfPerson: Int): Boolean {
        return numberOfPerson > capacity
    }

    fun checkOneHourWithinRange(playSchedule: PlaySchedule) {
        if (!DateTimeUtils.isOneHourWithinRange(startDateTime, playSchedule.startDateTime)) {
            throw IllegalArgumentException()
        }
    }
}
