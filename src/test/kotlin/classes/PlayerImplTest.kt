package classes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PlayerImplTest {

    private lateinit var player: PlayerImpl

    @BeforeEach
    fun setUp() {
        player = PlayerImpl(10u, 5u, 100u, 100u, 1u..10u)
    }

    @Test
    fun `test initial heal count`() {
        assertEquals(4u, player.healCount)
    }

    @Test
    fun `test heal when heal count is greater than 0`() {
        player.heal()

        assertEquals(3u, player.healCount)
        assertTrue(player.health.value in 100u..130u)
    }

    @Test
    fun `test heal when heal count is 0`() {
        player.healCount = 0u

        player.heal()

        assertEquals(0u, player.healCount)
        assertEquals(100u, player.health.value)
    }
}