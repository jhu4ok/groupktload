package statesimulation

import configuration.Configuration
import io.gatling.core.Predef._
import requests.Requests


class StateSimulation extends Simulation {

  val request = new Requests()
  val config = new Configuration()
  val feeder = csv("data/countries.csv").random


  val httpProtocol = config.baseUrlConfig

  val getAllStatesRequest = request.getAllByCountryName(feeder)

  val getStateByAnyFreeFormTextRequest = request.getByText(feeder)

  val getOneCountryState = request.getByCountryState(feeder)

  setUp(
    getAllStatesRequest.inject(config.loadConfig(10, 60)),
    getStateByAnyFreeFormTextRequest.inject(config.loadConfig(10, 60)),
    getOneCountryState.inject(config.loadConfig(10, 60))
  ).protocols(httpProtocol)


}


