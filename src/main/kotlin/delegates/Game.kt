package delegates

fun main() {
//    val zombie = Zombie("Zombie")
//    val human = Human("Human")
//    zombie.move()
//    zombie.fight()
//    human.move()
//    human.fight()
//
//    val premiumZombie = PremiumPlayer(zombie)
//    premiumZombie.move()
//    premiumZombie.fight()
//    premiumZombie.callForHelp()
//
//    val flyingHuman = FlyingPlayer(human)
//    flyingHuman.move()
//    flyingHuman.fight()
//    flyingHuman.fly()

    val mutableList = mutableListOf(1, 2 ,3)
    val loggingMutableList = LoggingMutableList(mutableList)
    loggingMutableList.add(4)
}

interface Player {

    fun move()

    fun fight()
}

data class Zombie(val userName: String): Player {

    override fun move() {
        println("I'm walking very slowly...")
    }

    override fun fight() {
        println("I'm eating people...")
    }
}

data class Human(val userName: String): Player {

    override fun move() {
        println("I'm running very fast...")
    }

    override fun fight() {
        println("I'm shooting a gun...")
    }
}

data class FlyingPlayer(val player: Player): Player by player {

    fun fly() {
        println("I'm flying...")
    }
}

data class PremiumPlayer(val player: Player): Player by player {

    fun callForHelp() {
        println("HELP ME!!!")
    }
}

class LoggingMutableList<T>(private val mutableList: MutableList<T>): MutableList<T> by mutableList {

    override fun add(element: T): Boolean {
        return mutableList.add(element).also {
            println("Element $element was added")
        }
    }
}