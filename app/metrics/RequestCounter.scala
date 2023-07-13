package metrics

import io.prometheus.client.Counter

object RequestCounter {

  val requestCounter = Counter.build()
    .name("my_request_counter")
    .help("Total number of requests")
    .labelNames("user_agent", "page")
    .register()

}