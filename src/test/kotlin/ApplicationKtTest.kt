import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ApplicationKtTest {
    @Test
    fun Test() {
        assertThat(5).isEqualTo(5)
        assertThat(true).isNotEqualTo(false)
    }
}