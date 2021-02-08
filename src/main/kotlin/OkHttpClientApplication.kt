import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.request.*
import io.ktor.util.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@ExperimentalTime
@KtorExperimentalAPI
suspend fun main() = coroutineScope {
    val duration = measureTime {
        val client = HttpClient(OkHttp)

        coroutineScope {
            repeat(1000) {
                launch(Dispatchers.Default) {
                    client.get<String>("http://127.0.0.1:${NETTY_SERVER_PORT}/")
                }
            }
        }

        client.close()
    }

    println(duration)
}
