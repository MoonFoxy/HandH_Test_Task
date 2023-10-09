package classes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class LimitedValueImplTest {

    private lateinit var limitedValue: LimitedValueImpl

    @BeforeEach
    fun setUp() {
        limitedValue = LimitedValueImpl(5u, 1u..10u)
    }

    @Test
    fun `test initial value`() {
        assertEquals(5u, limitedValue.value)
    }

    @Test
    fun `test setting value within range`() {
        limitedValue.value = 8u

        assertEquals(8u, limitedValue.value)
    }

    @Test
    fun `test setting value outside range`() {
        assertThrows(IllegalArgumentException::class.java) {
            limitedValue.value = 12u
        }
    }

    @Test
    fun `test setting value at lower bound`() {
        limitedValue.value = 1u

        assertEquals(1u, limitedValue.value)
    }

    @Test
    fun `test setting value at upper bound`() {
        limitedValue.value = 10u

        assertEquals(10u, limitedValue.value)
    }
}