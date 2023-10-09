import classes.Monster
import classes.PlayerImpl

fun main() {
    val player = PlayerImpl(10u, 5u, 100u, 100u, 1u..10u)
    val monster = Monster(8u, 3u, 80u, 80u, 1u..8u)

    println("Player health: ${player.health.value}")
    println("Monster health: ${monster.health.value}")

    player.attack(monster)
    println("Player attacks Monster")

    println("Player health: ${player.health.value}")
    println("Monster health: ${monster.health.value}")

    monster.attack(player)
    println("Monster attacks Player")

    println("Player health: ${player.health.value}")
    println("Monster health: ${monster.health.value}")

    player.heal()
    println("Player heals")

    println("Player health: ${player.health.value}")

    if (!player.isAlive) {
        println("Player is dead")
    }

    if (!monster.isAlive) {
        println("Monster is dead")
    }
}