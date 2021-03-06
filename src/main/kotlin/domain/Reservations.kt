package domain

class Reservations {
    val reservations by lazy {
        mutableListOf<Reservation>()
    }

    fun addReservation(reservation: Reservation) {
        if (reservations.size == 0) {
            reservations.add(reservation)
            return
        }
        checkValidPlaySchedules(reservation.schedule)
        reservations.add(reservation)
    }

    private fun checkValidPlaySchedules(playSchedule: PlaySchedule) {
        for (reservation in reservations) {
            checkValidPlaySchedule(playSchedule, reservation)
        }
    }

    private fun checkValidPlaySchedule(playSchedule: PlaySchedule, reservation: Reservation) {
        if (!playSchedule.isOneHourWithinRange(reservation.schedule)) {
            throw IllegalArgumentException()
        }
    }

    fun size(): Int {
        return reservations.size
    }
}
