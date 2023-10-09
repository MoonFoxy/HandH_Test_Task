package classes

import interfaces.Player

/**
 * PlayerImpl class represents a player in the game.
 *
 * @param attack the attack value of the player
 * @param armour the armour value of the player
 * @param health the current health value of the player
 * @param maxHealth the maximum health value of the player
 * @param damageRange the range of damage the player can inflict
 */
class PlayerImpl(
    attack: UInt,
    armour: UInt,
    health: UInt,
    maxHealth: UInt,
    damageRange: UIntRange
) : CreatureImpl(attack, armour, health, maxHealth, damageRange), Player {

    override var healCount: UInt = 4u

    override fun heal() {
        if (healCount == 0u) return
        val healAmount = (0.3 * health.valueRange.last.toDouble()).toUInt()
        health.value = (health.value + healAmount).coerceAtMost(health.valueRange.last)
        healCount--
    }
}