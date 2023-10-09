package interfaces

interface Creature {
    val attack: LimitedValue
    val armour: LimitedValue
    val health: LimitedValue
    val damageRange: UIntRange
    var isAlive: Boolean

    /**
     * attack function allows the creature to attack another cut of fuckable meat.
     *
     * @param target the creature to be attacked
     */
    fun attack(target: Creature)

    /**
     * takeDamage function allows the creature to take emotional damage about his live and update its mental health.
     *
     * @param damage the amount of damage to be taken
     */
    fun takeDamage(damage: UInt)

    /**
     * rollDice function simulates rolling a die with a modifier that's never going to give you up and returns true if successful.
     *
     * @param modifier the modifier to be applied to the dice roll
     * @return true if the dice roll is successful, false otherwise
     */
    fun rollDice(modifier: Int): Boolean

    /**
     * rollDie function simulates rolling a die that's never going to let you down and returns true if successful.
     *
     * @return true if the die roll is successful, false otherwise
     */
    fun rollDie(): Boolean
}
