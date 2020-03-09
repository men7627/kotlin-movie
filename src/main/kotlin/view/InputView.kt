package view

import domain.MovieRepository
import java.util.*

class InputView {

    companion object {
        private const val MESSAGE_START = "\n## "

        fun inputMovieId(): Long {
            println("${MESSAGE_START}예약할 영화를 선택하세요.")
            val choice = Scanner(System.`in`).nextLong()

            return MovieRepository.getMovies().stream()
                .filter { it.id == choice }
                .findFirst()
                .map { it.id }
                .orElseThrow { throw IllegalArgumentException("선택 오류") }
        }

        fun inputPlaySchedule(numberOfSchedule: Int): Int {
            println("${MESSAGE_START}예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)")
            val choice = Scanner(System.`in`).nextInt()

            if (choice !in 1..numberOfSchedule) {
                throw java.lang.IllegalArgumentException("선택 오류")
            }
            return choice
        }

        fun inputNumberOfPerson(numberOfPerson: Int): Int {
            println("${MESSAGE_START}예약할 인원을 입력하세요.")
            val choice = Scanner(System.`in`).nextInt()
            if (choice !in 1..numberOfPerson) {
                throw java.lang.IllegalArgumentException("선택 오류")
            }
            return choice
        }

        fun inputAdditionalReservation(): Int {
            println("${MESSAGE_START}예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번")
            val choice = Scanner(System.`in`).nextInt()
            if (choice != 1 && choice != 2) {
                throw java.lang.IllegalArgumentException("선택 오류")
            }
            return choice
        }

        fun inputPoint(): Int {
            println(
                """${MESSAGE_START}결제를 진행합니다.
                |${MESSAGE_START}포인트 사용 금액을 입력하세. 포인트가 없으면 0 입력
            """.trimMargin()
            )
            val point = Scanner(System.`in`).nextInt()
            if (point < 0) {
                throw java.lang.IllegalArgumentException("포인트 오류")
            }
            return point
        }

        fun inputPaymentMethod(): Int {
            println("${MESSAGE_START}신용카드는 1번, 현금은 2번 다음")
            val choice = Scanner(System.`in`).nextInt()
            if (choice != 1 && choice != 2) {
                throw java.lang.IllegalArgumentException("선택 오류")
            }
            return choice
        }
    }
}