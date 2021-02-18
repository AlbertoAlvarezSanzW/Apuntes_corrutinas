import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    println("Empiezo main2")
    // el run blocking es como un join, una vez dentro impide la ejecucion de lo siguiente hasta que termina la corrutina
    runBlocking {
        println("Entro en el blocking")
        delay(3000)
        println("Salgo del blocking")
    }

    println("Main no ha seguido a lo suyo")

    println("Termina")
}
