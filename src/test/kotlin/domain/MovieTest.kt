package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MovieTest {
    @Test
    internal fun addPlaySchedule() {
        val movies = mutableListOf<Movie>(Movie(1, "a", 1))
        movies.add(Movie(2, "b", 2))

        assertThat(movies.size).isEqualTo(2)
    }
}