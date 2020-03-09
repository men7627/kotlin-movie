import domain.*
import view.InputView
import view.OutputView

fun main(args: Array<String>) {
    val reservations = Reservations()
    OutputView.printMovies(MovieRepository.getMovies())

    do {
        reserve(reservations)
    } while (InputView.inputAdditionalReservation() == 2)

    pay(reservations)
}

private fun pay(reservations: Reservations) {
    OutputView.printReservations(reservations)
    val point = InputView.inputPoint()
    val paymentMethod = PaymentMethod.get(InputView.inputPaymentMethod())
    val payment = Payment(reservations, point, paymentMethod)
    OutputView.printFinalPayment(payment.finalPayment)
}

private fun reserve(reservations: Reservations) {
    val movie = MovieRepository.getMovie(InputView.inputMovieId())
    OutputView.printPlaySchedule(movie)
    val numberOfSchedule = InputView.inputPlaySchedule(movie.playSchedules.size)
    val numberOfPerson = InputView.inputNumberOfPerson(movie.getSchedule(numberOfSchedule).capacity)

    reservations.addReservation(Reservation(movie, numberOfSchedule, numberOfPerson))
}