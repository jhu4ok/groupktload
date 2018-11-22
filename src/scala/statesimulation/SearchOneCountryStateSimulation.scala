package statesimulation

import configuration.Configuration
import io.gatling.core.Predef._
import requests.Requests

class SearchOneCountryStateSimulation extends Simulation {

  val config = new Configuration()

  val httpProtocol = config.baseUrlConfig

  val getOneCountryState = new Requests().getByCountryState(csv("data/countries.csv").random)

  setUp(
    getOneCountryState.inject(config.loadConfig(10, 60)),
  ).protocols(httpProtocol)
}
