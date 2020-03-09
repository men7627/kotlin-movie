package view

import domain.Movie
import domain.Payment
import domain.Reservations

class OutputView {
    companion object {
        private const val MESSAGE_START = "\n## "

        fun printMovies(movies: List<Movie>) {
            println(MESSAGE_START + "상영 영화 목록")
            movies.forEach {
                println(it)
                it.playSchedules.forEach { println(it) }
            }
            println()
        }

        fun printPlaySchedule(movie: Movie) {
            println(movie)
            movie.playSchedules.forEach {
                println(it)
            }
        }

        fun printReservations(reservations: Reservations) {
            println("예약 내역")
            reservations.reservations.forEach {
                println(it)
            }
        }

        fun printFinalPayment(finalPayment: Int) {
            println(
                "\n" + """최종 결제한 금액은 ${finalPayment}원 입니다.
                |예매를 완료했습니다. 즐거운 영화 관람되세요.""".trimMargin()
            )
        }
    }
}