package requests

import io.gatling.core.Predef._
import io.gatling.core.feeder.FeederBuilder
import io.gatling.http.Predef._

class Requests() {

  def getAllByCountryName(data: FeederBuilder) = scenario("Get All States Request")
    .feed(data)
    .exec(http("request /state/get/${country}/all")
      .get("/state/get/${country}/all")
      .check(substring("${messageall}")
      )
    )

  def getByText(data: FeederBuilder) = scenario("Search By Text")
    .feed(data)
    .exec(http("request /state/search/${country}?text=${text}")
      .get("/state/search/${country}").queryParam("text", "${text}")
      .check(substring("${messagetext}")
      )
    )

  def getByCountryState(data: FeederBuilder) = scenario("Get One Country State")
    .feed(data)
    .exec(http("request /state/get/${country}/${state}")
      .get("/state/get/${country}/${state}")
      .check(substring("${messagestate}")
      )
    )
}
