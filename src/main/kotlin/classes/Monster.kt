package classes

/**
 * Monster class represents a monster in the game.
 * "Ugh, you're a monster" - Eminem
 *
 * @param attack the attack value of the monster
 * @param armour the armour value of the monster
 * @param health the current health value of the monster
 * @param maxHealth the maximum health value of the monster
 * @param damageRange the range of damage the monster can inflict
 */
class Monster(
    attack: UInt,
    armour: UInt,
    health: UInt,
    maxHealth: UInt,
    damageRange: UIntRange
) : CreatureImpl(attack, armour, health, maxHealth, damageRange)
// No additional functions in this class