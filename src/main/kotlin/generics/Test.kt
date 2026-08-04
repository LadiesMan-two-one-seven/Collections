package generics

import collections.MyList
import collections.myListOf

fun main() {
    val a: Worker = Programmer("Max")
    val b: MyList<Worker> = myListOf<Programmer>()

    val worker = Programmer("John")
    showName(worker)

    val workers: MyList<Programmer> = myListOf(Programmer("Nick"), Programmer("Helen"))
    showCount(workers)
}

private fun showName(worker: Worker) {
    println(worker.name)
}

private fun showCount(workers: MyList<Worker>) {
    println(workers.size)
}

open class Worker(val name: String)

class Programmer(name: String): Worker(name)

class Director(name: String): Worker(name)