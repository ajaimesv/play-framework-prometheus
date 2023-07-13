package controllers

import metrics.RequestCounter

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def index() = Action { implicit request: Request[AnyContent] =>
    val browser = request.headers.get("User-Agent").getOrElse("unknown")
    val page = request.path
    RequestCounter.requestCounter.labels(browser, page).inc()

    Ok(views.html.index())
  }

}
