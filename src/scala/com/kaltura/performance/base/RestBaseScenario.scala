package com.kaltura.performance.base

import com.kaltura.performance.api.RestApi
import com.kaltura.performance.config.Config
import io.gatling.core.Predef._
import io.gatling.core.feeder.FeederBuilder
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import io.gatling.http.check.HttpCheck
import io.gatling.core.Predef.scenario

abstract class RestBaseScenario extends RestApi {



  feed(feeder)


  val loginCheckUpList: List[HttpCheck] = List(
    jsonPath("$.result.loginSession.ks").saveAs("ks"),
    jsonPath("$.result.user.id").saveAs("siteGuid"),
    jsonPath("$.result.user.id").saveAs("userId"))

  val getHouseHoldDeviceCheckUpList: List[HttpCheck] = List(
    jsonPath("$.result.objects[0].householdId").saveAs("domainId"))

  val assetListCheckupList: List[HttpCheck] = List(
    jsonPath("$.result.objects[0].externalIds").saveAs("epgChannelId"),
    jsonPath("$.result.objects[0].mediaFiles[0].id").saveAs("epgMediaFileId"),
    jsonPath("$.result.objects[0].mediaFiles[0].url").saveAs("epgBaseLink"),
    jsonPath("$.result.objects[0].id").saveAs("linearChannelMediaId"))

  val entitlementHouseholdSubscriptionCheckupList: List[HttpCheck] = List(
    jsonPath("$.result.objects[0].id").saveAs("subscriptionId"))

  val houseHoldCheckupList: List[HttpCheck] = List(
    jsonPath("$.result.users..id").findAll.saveAs("siteGuidsOfDomain"),
    jsonPath("$.result.users..id").findAll.transform(_.mkString(";")).saveAs("usersDataSiteGuids"))

  val searchAssetListCheckupList: List[HttpCheck] = List(
    jsonPath("$.result.objects[0].id").saveAs("mediaId"),
    jsonPath("$.result.objects[0].mediaFiles[0].id").saveAs("vodMediaFileId"),
    jsonPath("$.result.objects[0].mediaFiles[0].url").saveAs("mediaBaseLink"))

  val epgMultiChannelCheckupList: List[HttpCheck] = List(
    jsonPath("$.result.objects[0].id").saveAs("epgItemID"))


  def getEntitlementHouseholdSubscriptionListAndSaveSubscriptionId(checks: List[HttpCheck] = Nil): ChainBuilder = super.getEntitlementHouseholdSubscriptionList(entitlementHouseholdSubscriptionCheckupList)

  override def userLogin(checks: List[HttpCheck]): ChainBuilder = super.userLogin(loginCheckUpList)

  override def getHouseholdDeviceList(checks: List[HttpCheck]): ChainBuilder = super.getHouseholdDeviceList(getHouseHoldDeviceCheckUpList)

  override def getAssetListChannel(checks: List[HttpCheck]): ChainBuilder = super.getAssetListChannel(assetListCheckupList)

  override def getHousehold(checks: List[HttpCheck]): ChainBuilder = super.getHousehold(houseHoldCheckupList)

  override def searchAssetList(checks: List[HttpCheck]): ChainBuilder = super.searchAssetList(searchAssetListCheckupList)

  override def getEPGMultiChannelProgram(checks: List[HttpCheck]): ChainBuilder = super.getEPGMultiChannelProgram(epgMultiChannelCheckupList)


  def createScenario(name: String, feed: FeederBuilder, chains: ChainBuilder*): ScenarioBuilder = {
    scenario(name).feed(feed).forever() {
      exec(chains).pause(Config.pauseBetweenRequests)
    }
  }

  def setSessionParams(key: String, value: Any) = {
    exec(_.set(key, value))
  }


  def fetchAndSaveParamToSession(valueToGet: String, valueToSaveToSession: String) = {
    exec { session =>
      val param = session(valueToGet).as[Any]
      session.set(valueToSaveToSession, param)
      session
    }
  }


  def printFromSession(key: String) = {
    exec { session =>
      println(session(key).as[String])
      session
    }
  }

  def setRunLogic: ChainBuilder

}