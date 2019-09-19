package com.kaltura.performance.base

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class TvpApiBaseSimulation extends BaseSimulation {


  var tvpApiBaseUrl = System.getProperty("tvp_api_base_url")
  var tvpApiVersion = System.getProperty("tvp_api_version")
  val tvpApiJsonUrl = System.getProperty("tvp_api_json_url") // /gateways/JsonPostGW.aspx
  var url = tvpApiBaseUrl +  tvpApiVersion + tvpApiJsonUrl

  val httpsconf = http
    .baseUrl(url)
    .contentTypeHeader("application/json")

}
