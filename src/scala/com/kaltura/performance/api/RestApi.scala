package com.kaltura.performance.api


import com.kaltura.performance.base.BaseSimulation
import com.kaltura.performance.config.Config
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.check.HttpCheck


abstract class RestApi extends BaseSimulation {

  var url = System.getProperty("rest_base_url")
  val feeder = jsonFile(Config.resourcesPath + "/json/devices.json") //user password and additional const data
  val httpconf = http.baseUrl(url).header("Accept", contentType)

  def anonymousLogin(checks: List[HttpCheck] = Nil) = {
    exec(http("Ott anonymous user login request")
      .post("/ottuser/action/anonymouslogin")
      .body(ElFileBody("json/OttUserAnonymousLogin.json")).asJson
      .check(status is 200)
      .check(checks: _*))
  }

  def userLogin(checks: List[HttpCheck] = Nil) = {
    exec(http("Ott user login request")
      .post("/ottuser/action/login")
      .body(ElFileBody(Config.resourcesPath + "/json/OttUserLogin.json")).asJson
      .check(status is 200)
      .check(checks: _*))
  }

  def serveByDevice = {
    exec(http("Get runtime configuration for client applications")
      .post("/configurations/action/serveByDevice")
      .body(ElFileBody(Config.resourcesPath + "/json/serveByDeviceBody.json")).asJson
      .check(status is 200))
  }


  def getHouseholdDeviceList(checks: List[HttpCheck] = Nil) = {
    exec(http("Get household device list")
      .post("/householdDevice/action/list")
      .body(ElFileBody(Config.resourcesPath + "/json/onlyks.json")).asJson
      .check(status is 200)
      .check(checks: _*))
  }


  def getOttUserList = {
    exec(http("Get Ott User List")
      .post("/OTTUser/action/list")
      .body(ElFileBody(Config.resourcesPath + "/json/OttUserList.json")).asJson
      .check(status is 200))
  }

  def getOttUser = {
    exec(http("Get Ott User")
      .post("/OTTUser/action/get")
      .body(ElFileBody(Config.resourcesPath + "/json/getOttUserBody.json")).asJson
      .check(status is 200))
  }


  def getEntitlementHouseholdSubscriptionList(checks: List[HttpCheck] = Nil) = {
    exec(http("Get entitlement household subscription list")
      .post("/entitlement/action/list")
      .body(ElFileBody(Config.resourcesPath + "/json/EntitlementListHouseholdSubscription.json")).asJson
      .check(status is 200)
      .check(checks: _*))
  }

  def getAssetListChannel(checks: List[HttpCheck] = Nil) = {
    exec(http("Get asset list channel")
      .post("/asset/action/list")
      .body(ElFileBody("/json/AssetListChannel.json")).asJson
      .check(status is 200)
      .check(checks: _*))
  }

  def searchAssetList(checks: List[HttpCheck] = Nil) = {
    exec(http("Search assets list")
      .post("/asset/action/list")
      .body(ElFileBody("/json/AssetListSearch.json")).asJson
      .check(status is 200)
      .check(checks: _*))
  }

  def getAssetListSpecificMedia = {
    exec(http("Get specific media from asset list")
      .post("/asset/action/list")
      .body(ElFileBody("/json/AssetListSpecificMedia.json")).asJson
      .check(status is 200))
  }

  def getAssetsBookmarks = {
    exec(http("Get assets bookmark")
      .post("/bookmark/action/list")
      .body(ElFileBody("/json/BookmarkList.json")).asJson
      .check(status is 200))
  }

  def getOttUserData = {
    exec(http("Get ott user data")
      .post("/OTTUser/action/get")
      .body(ElFileBody("/json/OttUserGet.json")).asJson
      .check(status is 200))

  }

  def addItemToUserAssetsLIst: Unit = {
    exec(http("Add item to user assets list")
      .post("/Userassetslistitem/action/add")
      .body(ElFileBody("/json/UserassetslistitemAdd.json")).asJson
      .check(status is 200))
  }


  def getItemFromUserAssetLIst = {
    exec(http("Get item from user asset list")
      .post("/Userassetslistitem/action/get")
      .body(ElFileBody("/json/UserassetslistitemGet.json")).asJson
      .check(status is 200))
  }

  def getRegions = {
    exec(http("Get regions")
      .post("/region/action/list")
      .body(ElFileBody("/json/RegionList.json")).asJson
      .check(status is 200))
  }

  def getEPGMultiChannelProgram(checks: List[HttpCheck] = Nil) = {
    exec(http("Get EPG multi channel")
      .post("/asset/action/list")
      .body(ElFileBody("/json/AssetListEpgChannel.json")).asJson
      .check(status is 200)
      .check(checks: _*))
  }

  def getAssetActionList(jsonBody: String) = {
    exec(http("Get assets action list")
      .post("/asset/action/list")
      .body(ElFileBody(Config.resourcesPath +"/json/"+jsonBody)).asJson
      .check(status is 200))
  }


  def getPlaybackContext = {
    exec(http("Get playback context")
      .post("/asset/action/getPlaybackContext")
      .body(ElFileBody("/json/GetPlaybackContext.json")).asJson
      .check(status is 200))

  }

  def GetSubscriptionIDsContainingMediaFile = {
    exec(http("Get subscription ids containing media file")
      .post("/subscription/action/list")
      .body(ElFileBody("/json/SubscriptionListMediaFile.json")).asJson
      .check(status is 200))

  }

  def GetSubscriptionsPricesWithCoupon = {
    exec(http("Get subscription prices with coupon")
      .post("/productprice/action/list")
      .body(ElFileBody("/json/ProductPriceListSubscription.json")).asJson
      .check(status is 200))
  }

  def getHousehold(checks: List[HttpCheck] = Nil) = {
    exec(http("Get domain info")
      .post("/household/action/get")
      .body(ElFileBody(Config.resourcesPath +"/json/onlyks.json")).asJson
      .check(status is 200)
      .check(checks: _*))

  }


  def addBookMark() = {
    exec(http("Add bookmark")
      .post("/bookmark/action/add")
      .body(ElFileBody("/json/BookmarkAdd.json")).asJson
      .check(status is 200))
  }

  def getOttCategory() = {
    exec(http("Get OTT category")
      .post("/ottcategory/action/get")
      .body(ElFileBody(Config.resourcesPath +"/json/getOttCategoryBody.json")).asJson
      .check(status is 200))
  }

  def getProductPriceActionList(body: String) ={
    exec(http("Get product price action list")
      .post("/productprice/action/list")
      .body(ElFileBody(Config.resourcesPath +"/json/"+body)).asJson
      .check(status is 200))

  }

  def getHouseHoldUserList() ={
    exec(http("Get household user list ")
      .post("/householduser/action/list")
      .body(ElFileBody(Config.resourcesPath +"/json/getHouseHoldUserListBody.json")).asJson
      .check(status is 200))
  }



}


object RestApi {

  val PARTNER_ID = "partnerId"
  val REST_API_VERSION = "restApiVersion"
  val REGION_ID = "regionId"
  val EXTERNAL_ALIAS = "externalAlias"
  val SEARCH_ASSETS_FILTER = "searchAssetsFilter"
  val SEARCH_ASSETS_FILTER_TYPE = "searchAssetsFilterTypes"
  val BOOKMARK_ASSET_TYPE = "bookmarkAssetType"
  val BOOKMARK_ASSET_ID = "bookmarkAssetId"
  val UUID = "uuid"
  val USER = "username"
  val PASSWORD = "password"


}


