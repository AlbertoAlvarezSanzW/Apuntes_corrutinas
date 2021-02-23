import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random



fun main() {
    //los deferred son un tipo de dato al cual le estamos diciendo que un async devolvera datos, pero en el momento no
    // por tanto podemos usar await para congelar la ejecucion hasta que esa variable deferred tenga los datos resultates del async

    //funcionSinDeferred()
    funcionConDeferred()

    runBlocking{
        println("hola antes del await")
        println(funcionDevolucionAsync().await())
        println("Hola despues de await")
    }
}

fun funcionSinDeferred(){
    println("Entro")

    GlobalScope.launch {
        println("Entro1")
        val list = mutableListOf<Int>()
        for (i in 1..100) {
            GlobalScope.launch {
                list.add(Random.nextInt(0, 9))
            }
        }
        println("El resultado sin Deferred es una lista de ${list.size} elementos con \n$list ")
    }

    Thread.sleep(5000) // wait for 2 seconds. Para que tenga tiempo de escribir el resutlado.
}


fun funcionConDeferred() {

    GlobalScope.launch {
        val listOfDeferred = mutableListOf<Deferred<Int>>()
        for (i in 1..100) {
            val a = GlobalScope.async {
                Random.nextInt(0, 9)
            }
            listOfDeferred.add(a)
        }
        //con awaitAll esperamos a que acabe completamente, no a que acabe la primera y devolvemos
        println("El resultado sin Deferred es una lista de ${listOfDeferred.awaitAll().size} elementos con \n${listOfDeferred.awaitAll()} ")
    }
    Thread.sleep(5000) // wait for 5 seconds. Para que tenga tiempo de escribir el resutlado.

}
// esta es otra manera de hacer funciones con return de async
fun funcionDevolucionAsync() = GlobalScope.async{
    delay(3000)
    return@async "hola"
}
// esta es la manera "cutre" por la cual deberiamos declarar un deferred del tipo string y luego usar await sobre ese deferred
fun devolucionAsyncCutre(): Deferred<String> {
    return GlobalScope.async {
        "hola"
    }
}


