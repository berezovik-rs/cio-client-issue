import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.delay

const val NETTY_SERVER_PORT = 8000

fun main() {
  embeddedServer(Netty, port = NETTY_SERVER_PORT) {
    routing {
      get("/") {
        delay(1000)

        call.respondText("Hello, world!")
      }
    }
  }.start(wait = true)
}