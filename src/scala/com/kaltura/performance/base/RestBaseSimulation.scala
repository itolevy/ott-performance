package com.kaltura.performance.base

import io.gatling.core.Predef._
import io.gatling.http.Predef._


class RestBaseSimulation extends BaseSimulation {

  var url = System.getProperty("rest_base_url")
  val feeder = jsonFile("rest/rest.json").circular //user password and additional const data

  val httpconf = http
    .baseUrl(url)
    .header("Accept", contentType)

}