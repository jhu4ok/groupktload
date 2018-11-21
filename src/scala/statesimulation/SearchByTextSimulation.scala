package statesimulation

import configuration.Configuration
import io.gatling.core.Predef._
import requests.Requests

class SearchByTextSimulation extends Simulation {

  val config = new Configuration()

  val httpProtocol = config.baseUrlConfig

  val getStateByAnyFreeFormTextRequest = new Requests().getByText(csv("data/countries.csv").random)

  setUp(
    getStateByAnyFreeFormTextRequest.inject(config.loadConfig(10, 60)),
  ).protocols(httpProtocol)
}
