package classes

import kotlin.random.Random

class Player(
    attack: UInt,
    armour: UInt,
    health: UInt,
    maxHealth: UInt,
    damageRange: UIntRange
) : CreatureImpl(attack, armour, health, maxHealth, damageRange) {
    fun heal() {
        val maxHealAmount = (0.3 * health.value.toDouble()).toUInt()
        val healAmount = Random.nextInt(1, maxHealAmount.toInt() + 1).toUInt()
        health.value = (health.value + healAmount).coerceAtMost(health.valueRange.last)
    }
}