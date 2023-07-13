package modules

import com.google.inject.AbstractModule
import controllers.PrometheusController
import io.prometheus.client.CollectorRegistry
import play.api.{Configuration, Environment}


class AppModule(environment: Environment, configuration: Configuration) extends AbstractModule {

  override def configure(): Unit = {

    // Bind the CollectorRegistry as a singleton
    bind(classOf[CollectorRegistry]).toInstance(CollectorRegistry.defaultRegistry)

    // Bind the PrometheusController as a singleton
    bind(classOf[PrometheusController]).asEagerSingleton()
  }

}
