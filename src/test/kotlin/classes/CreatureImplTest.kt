package classes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class CreatureImplTest {

    private lateinit var creature: CreatureImpl

    @BeforeEach
    fun setUp() {
        creature = CreatureImpl(10u, 5u, 100u, 100u, 1u..10u)
    }

    @Test
    fun `test takeDamage when damage is greater than health`() {
        creature.takeDamage(150u)

        assertFalse(creature.isAlive)
        assertEquals(0u, creature.health.value)
    }

    @Test
    fun `test takeDamage when damage is less than health`() {
        creature.takeDamage(50u)

        assertTrue(creature.isAlive)
        assertEquals(50u, creature.health.value)
    }

    @Test
    fun `test getDamageRange`() {
        val damageRange = creature.damageRange

        assertEquals(1u, damageRange.first)
        assertEquals(10u, damageRange.last)
    }
}