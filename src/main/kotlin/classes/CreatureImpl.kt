package classes

import interfaces.Creature
import kotlin.random.Random

/**
 * CreatureImpl class represents a creature in the game.
 *
 * @param attack the attack value of the creature
 * @param armour the armour value of the creature
 * @param health the current health value of the creature
 * @param maxHealth the maximum health value of the creature
 * @param damageRange the range of damage the creature can inflict
 */
open class CreatureImpl(
    attack: UInt,
    armour: UInt,
    health: UInt,
    maxHealth: UInt,
    final override val damageRange: UIntRange
) : Creature {
    init {
        require(damageRange.step == 1) { "The step should be 1." }
    }

    override val attack = LimitedValueImpl(attack, 1u..30u)
    override val armour = LimitedValueImpl(armour, 1u..30u)
    override val health = LimitedValueImpl(health, 0u..maxHealth)
    override var isAlive = true

    override fun attack(target: Creature) {
        val attackModifier = attack.value.toInt() - target.armour.value.toInt() + 1
        val isSuccess = rollDice(attackModifier)

        if (isSuccess) {
            val damage = Random.nextInt(damageRange.first.toInt(), damageRange.last.toInt() + 1).toUInt()
            target.takeDamage(damage)
        }
    }

    override fun takeDamage(damage: UInt) {
        if (damage >= health.value) {
            health.value = 0u
            isAlive = false
        } else {
            health.value -= damage
        }
    }

    final override fun rollDice(modifier: Int): Boolean {
        val diceCount = modifier.coerceAtLeast(1)
        return (1..diceCount).any { rollDie() }
    }

    final override fun rollDie(): Boolean {
        return Random.nextInt(1, 7) in arrayOf(5, 6)
    }
}