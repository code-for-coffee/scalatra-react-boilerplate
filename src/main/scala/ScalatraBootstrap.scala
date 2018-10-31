import com.playground.awesome._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new HomeController, "/*")
    context.mount(new PlanetsApiController, "/api/*")
  }
}
