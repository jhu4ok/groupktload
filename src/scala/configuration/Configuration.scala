package configuration

import io.gatling.core.Predef.constantUsersPerSec
import scala.concurrent.duration.FiniteDuration
import io.gatling.core.Predef._
import io.gatling.http.Predef._


class Configuration {

  val baseUrlConfig = http.
    baseUrl("http://services.groupkt.com").check(status is 200)

  def loadConfig(rate: Int, time: FiniteDuration) = constantUsersPerSec(rate) during (time)

}
