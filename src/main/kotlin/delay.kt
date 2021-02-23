import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    println("Empiezo main2")
    corrutinaEnFuncion("Hello!")
    println("Main sigue a lo suyo")
    Thread.sleep(2000) // wait for 2 seconds
    println("Termina")
}

fun corrutinaEnFuncion(hola: String){
    // Start a coroutine
    GlobalScope.launch {
        println("Corrutina a dormir diciendo: $hola")
        delay(1000)
        println("Corrutina despierta")
    }
}

