import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay

import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

val mutex = Mutex()
// el mutex nos permite crear un semaforo pero donde SOLAMENTE puede entrar 1 a la vez y ejecutar.
fun main() {
    for (i in 1..10){
        GlobalScope.launch {
            escribirConMutex(i)
        }
    }
    Thread.sleep(12000)
}

suspend fun escribirConMutex(i : Int) {
    // aqui le estamos diciendo que el que entre obtenga y bloquee el mutex, una vez que acaba lo libera y lo puede coger otro . es un semaforo
    mutex.withLock {
        println("Empiezo a escribir $i")
        delay(1000)
        println("Termino de escribir $i")
    }
}
