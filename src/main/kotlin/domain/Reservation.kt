package domain

data class Reservation(private val movie: Movie, private val numberOfSchedule: Int, private val numberOfPerson: Int) {
    init {
        checkNumberOfPerson(movie, numberOfSchedule, numberOfPerson)
    }

    private fun checkNumberOfPerson(movie: Movie, numberOfSchedule: Int, numberOfPerson: Int) {
        if (movie.getSchedule(numberOfSchedule).isInValidNumberOfPerson(numberOfPerson)) {
            throw IllegalArgumentException()
        }
    }

    fun getPlaySchedule(): PlaySchedule {
        return movie.getSchedule(numberOfSchedule)
    }

    fun getTotalPayment(): Int {
        return movie.price * numberOfPerson
    }
}