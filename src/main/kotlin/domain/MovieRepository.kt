package domain

import utils.DateTimeUtils.Companion.createDateTime

object MovieRepository {
    private val MOVIES = listOf(
        Movie(1, "생일", 8_000).apply {
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 12:00"), 6))
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 14:40"), 6))
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 17:00"), 6))
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 19:40"), 3))
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 22:00"), 3))
        },
        Movie(5, "돈", 10_000).apply {
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 08:00"), 3))
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 10:30"), 5))
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 13:00"), 5))
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 15:30"), 5))
        },
        Movie(7, "파이브피트", 9_000).apply {
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 13:00"), 4));
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 15:40"), 4));
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 18:00"), 4));
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 20:40"), 3));
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 23:15"), 3));
        },
        Movie(8, "덤보", 9_000).apply {
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 11:30"), 2))
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 16:00"), 3))
            addPlaySchedule(PlaySchedule(createDateTime("2019-04-16 21:30"), 2))
        }
    )

    fun getMovies(): List<Movie> {
        return MOVIES
    }

    fun getMovie(id: Long): Movie {
        return MOVIES.stream()
            .filter { it.id == id }
            .findFirst()
            .orElseThrow { throw IllegalAccessException("영화 없음") }
    }

}
