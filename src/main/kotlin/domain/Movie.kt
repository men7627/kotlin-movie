package domain

import java.lang.StringBuilder

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

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("$id - $title, ${price}원\n")

        playSchedules.forEach { stringBuilder.append(it.toString()) }

        return stringBuilder.toString()
    }
}