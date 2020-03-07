package view

import java.util.*

class InputView {
    companion object {
        private val scanner = Scanner(System.`in`)

        fun inputMovieId(): Int {
            println("## 예약할 영화를 선택하세요.");
            return scanner.nextInt();
        }
    }
}