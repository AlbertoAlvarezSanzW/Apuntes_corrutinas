import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(){
    // podemos bloquear el codigo hasta que se haya terminado una corrutina mediante un async
    // que luego nos permitiria usar await() bloqueando asi la ejecucion hasta que haya terminado y devuelto un dato el async
    GlobalScope.launch {
        val contenido = async {
            delay(1000)
            "Hola"
        }
        println("Estoy listo para imprimir pero \"a\" aún está vacia por lo que toca esperar")
        println(contenido.await())
        println("Impreso!")

    }
    Thread.sleep(5000)

}