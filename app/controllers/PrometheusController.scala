package controllers

import javax.inject.Inject
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import io.prometheus.client.CollectorRegistry
import io.prometheus.client.exporter.common.TextFormat

class PrometheusController @Inject()(cc: ControllerComponents, registry: CollectorRegistry)
  extends AbstractController(cc) {

  def metrics: Action[AnyContent] = Action { implicit request =>
    println("metrics called")
    val writer = new java.io.StringWriter()
    TextFormat.write004(writer, registry.metricFamilySamples())
    writer.close()
    Ok(writer.toString).as("text/plain; version=0.0.4")
  }
}

