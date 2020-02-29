package domain

class Reservations {
    private val reservations by lazy {
        mutableListOf<Reservation>()
    }

    fun addReservation(reservation: Reservation) {
        if (reservations.size == 0) {
            reservations.add(reservation)
            return
        }
        checkValidPlaySchedule(reservation.getPlaySchedule())
        reservations.add(reservation)
    }

    private fun checkValidPlaySchedule(playSchedule: PlaySchedule) {
        for (reservation in reservations) {
            playSchedule.checkOneHourWithinRange(reservation.getPlaySchedule())
        }
    }

    fun size(): Int {
        return reservations.size
    }
}
