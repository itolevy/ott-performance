package com.kaltura.performance.base

import io.gatling.core.Predef._
import io.gatling.http.Predef._

abstract class BaseSimulation extends Simulation {

  val contentType = System.getProperty("http_content_type")


}

