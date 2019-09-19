package com.kaltura.performance.scenarios


import com.kaltura.performance.api.RestApi._
import com.kaltura.performance.base.RestBaseScenario
import io.gatling.core.Predef._
import com.kaltura.performance.config.Config
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef.{http, status}
import io.gatling.http.check.HttpCheck

class LoginOnlyScenario extends RestBaseScenario {


  feed(feeder)


  val loginOnlyScenario = createScenario(Config.testName, feeder.random,
    setSessionParams(PARTNER_ID, Config.rest_partner_id),
    setSessionParams(REST_API_VERSION, Config.rest_api_version),
    setSessionParams(REGION_ID, 0),
    setSessionParams(EXTERNAL_ALIAS, ""),
    serveByDevice,
    userLogin(),
    printFromSession("ks"),
    getOttUser,
    getHousehold(),
    getHouseHoldUserList,
    getProductPriceActionList("productPriceActionListBody1.json"),
    getProductPriceActionList("productPriceActionListBody2.json"),
    getProductPriceActionList("productPriceActionListBody3.json"),
    getProductPriceActionList("productPriceActionListBody4.json"),
    getProductPriceActionList("productPriceActionListBody5.json"),
    getAssetActionList("assetActionListBody1.json"),
    getAssetActionList("assetActionListBody2.json"),
    getAssetActionList("assetActionListBody3.json"),
    getAssetActionList("assetActionListBody4.json"),
    getAssetActionList("assetActionListBody5.json"))

  override def setRunLogic: ChainBuilder = ???
}
