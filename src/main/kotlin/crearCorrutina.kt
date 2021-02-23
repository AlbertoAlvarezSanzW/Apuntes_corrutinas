import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    println("Empiezo main")
    // Start a coroutine
    // Para crear una corrutina usamos globalScope.Launch{} todo lo que vaya dentro se ejecutara en una corrutina y la ejecucion seguira
    GlobalScope.launch {
        println("Corrutina a dormir")
        delay(1000)
        println("Corrutina despierta")
    }
    println("Main sigue a lo suyo")
    Thread.sleep(2000) // wait for 2 seconds
    println("Termina")
}


