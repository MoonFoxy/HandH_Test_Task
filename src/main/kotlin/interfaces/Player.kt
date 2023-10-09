package interfaces

interface Player : Creature {
    /**
     * healCount represents the number of times the player can heal.
     * "<3 <3 <3 <3"
     * - Why four?
     * - IDK, I'm an artist, that's how I see it
     */
    var healCount: UInt

    /**
     * heal function allows the player to heal his mental illness and increase their health.
     */
    fun heal()
}