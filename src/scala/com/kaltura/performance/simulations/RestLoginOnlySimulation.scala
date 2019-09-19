package com.kaltura.performance.simulations

import io.gatling.core.Predef._
import com.kaltura.performance.scenarios.LoginOnlyScenario
import scala.concurrent.duration._
class RestLoginOnlySimulation extends LoginOnlyScenario {

  setUp(loginOnlyScenario.inject(constantConcurrentUsers(2) during (5 seconds), rampConcurrentUsers(1) to (2) during (1 minute)))
    .protocols(httpconf).maxDuration((2 minutes))
    .assertions(global.successfulRequests.percent.is(100))
}
