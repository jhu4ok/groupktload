package statesimulation

import configuration.Configuration
import io.gatling.core.Predef._
import requests.Requests

class SearchAllStatesSimulation extends Simulation {

  val config = new Configuration()

  val httpProtocol = config.baseUrlConfig

  val getAllStatesRequest = new Requests().getAllByCountryName(csv("data/countries.csv").random)

  setUp(
    getAllStatesRequest.inject(config.loadConfig(10, 60))
  ).protocols(httpProtocol)
}


