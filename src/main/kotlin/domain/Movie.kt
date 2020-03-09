package domain

data class Movie(
    val id: Long,
    val title: String,
    val price: Int
) {
    val playSchedules by lazy {
        mutableListOf<PlaySchedule>()
    }

    fun addPlaySchedule(playSchedule: PlaySchedule) {
        playSchedules.add(playSchedule)
    }

    fun getSchedule(numberOfSchedule: Int): PlaySchedule {
        return playSchedules[numberOfSchedule - 1]
    }

    override fun toString(): String {
        return "$id - $title, ${price}원"
    }
}