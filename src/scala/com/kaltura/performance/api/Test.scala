package com.kaltura.performance.api

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Test extends Simulation{

  val httpConf = http.baseUrl("https://api.openbrewery.org")
  val scn = scenario("basicgetscenario")
    .exec(http("basicgetrequesst").get("/breweries"))

  setUp(scn.inject(atOnceUsers(1))).protocols(httpConf)

}
