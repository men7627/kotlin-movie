package view

import domain.Movie
import domain.Payment

class OutputView {
    companion object {
        private const val MESSAGE_START = "\n##"

        fun printMovies(movies: List<Movie>) {
            println(MESSAGE_START)
            movies.forEach { println(it) }
        }

        fun printChoiceMovieMessgae() {
            println("${MESSAGE_START}예약할 영화를 선택하세요")
        }

        fun printChoicePlayScheduleMessage() {
            println("${MESSAGE_START}예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)")
        }

        fun printChoiceNumberOfPersonMessage() {
            println("${MESSAGE_START}예약할 인원을 입력하세요.")
        }

        fun printChoiceAdditionalReservationMessage() {
            println("${MESSAGE_START}예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번")
        }

        fun printPaymentProgressMessage() {
            println("${MESSAGE_START}결제를 진행합니다.")
        }

        fun printPointInputMessage() {
            println("${MESSAGE_START}포인트 사용 금액을 입력하세요. 포인트가 없으면 0입력")
        }

        fun printChoicePaymentMethodMessage() {
            println("${MESSAGE_START}신용카드는 1번, 현금은 2번")
        }

        fun printFinalPayment(payment: Payment) {
            println("""최종 결제한 금액은 ${payment.finalPayment}원 입니다.
                |예매를 완료했습니다. 즐거운 영화 관람되세요.""".trimMargin())
       }
    }
}