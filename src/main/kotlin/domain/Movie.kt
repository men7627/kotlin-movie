package domain

data class Movie(
    private val id: Long,
    private val title: String,
    val price: Int
) {
    private val playSchedules by lazy {
        mutableListOf<PlaySchedule>()
    }

    fun addPlaySchedule(playSchedule: PlaySchedule) {
        playSchedules.add(playSchedule)
    }

    fun getSchedule(numberOfSchedule: Int): PlaySchedule {
        return playSchedules[numberOfSchedule - 1]
    }
}