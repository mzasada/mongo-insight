import org.scalatra.LifeCycle
import javax.servlet.ServletContext
import org.mongocrunch.console.controller.StatisticsController

/**
 * @author mzasada
 */
class ScalatraBootstrap extends LifeCycle {

  override def init(context: ServletContext): Unit = {

    context mount(new StatisticsController, "/statistics")
  }
}