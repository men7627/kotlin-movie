package domain

import utils.DateTimeUtils

data class Reservation(private val movie: Movie, private val numberOfSchedule: Int, private val numberOfPerson: Int) {
    val schedule: PlaySchedule
    val totalPayment: Int

    init {
        checkNumberOfPerson(movie, numberOfSchedule, numberOfPerson)
        schedule = movie.getSchedule(numberOfSchedule)
        totalPayment = movie.price * numberOfPerson
    }

    private fun checkNumberOfPerson(movie: Movie, numberOfSchedule: Int, numberOfPerson: Int) {
        if (movie.getSchedule(numberOfSchedule).isInValidNumberOfPerson(numberOfPerson)) {
            throw IllegalArgumentException()
        }
    }

    override fun toString(): String {
        return """$movie
            |시작시간: ${DateTimeUtils.format(schedule.startDateTime)}
            |예약인원: $numberOfPerson
        """.trimMargin()
    }
}