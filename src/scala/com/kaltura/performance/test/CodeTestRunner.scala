
import com.kaltura.performance.simulations.RestLoginOnlySimulation
import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object CodeTestRunner {
  def main(args: Array[String]):  Unit = {

    val simClass =classOf[RestLoginOnlySimulation].getName

    val props = new GatlingPropertiesBuilder
    props.simulationClass(simClass)

    Gatling.fromMap(props.build)
  }

}
