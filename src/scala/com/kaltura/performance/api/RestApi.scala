package com.kaltura.performance.api

import com.kaltura.performance.base.RestBaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.check.HttpCheck


abstract class RestApi extends RestBaseSimulation {


  def anonymousLogin(checks: List[HttpCheck] = Nil) = {
    exec(http("Ott anonymous user login request")
      .post("ottuser/action/anonymouslogin")
      .body(ElFileBody("rest/OttUserAnonymousLogin.json")).asJson
      .check(status is 200)
      .check(checks: _*))
  }

  def userLogin(checks: List[HttpCheck] = Nil) = {
    exec(http("Ott user login request")
      .post("ottuser/action/login")
      .body(ElFileBody("rest/OttUserLogin.json")).asJson
      .check(status is 200)
      .check(checks: _*))
  }


  def getHouseholdDeviceList(checks: List[HttpCheck] = Nil) = {
    exec(http("Get household device list")
      .post("householdDevice/action/list")
      .body(ElFileBody("rest/onlyks.json")).asJson
      .check(status is 200)
      .check(checks: _*))
  }


  def getOttUserList = {
    exec(http("Get Ott User List")
      .post("OTTUser/action/list")
      .body(ElFileBody("rest/OttUserList.json")).asJson
      .check(status is 200))
  }

  def getEntitlementHouseholdSubscriptionList(checks: List[HttpCheck] = Nil) = {
    exec(http("Get entitlement household subscription list")
      .post("entitlement/action/list")
      .body(ElFileBody("rest/EntitlementListHouseholdSubscription.json")).asJson
      .check(status is 200)
      .check(checks: _*))
  }

  def getAssetListChannel(checks: List[HttpCheck] = Nil) = {
    exec(http("Get asset list channel")
      .post("asset/action/list")
      .body(ElFileBody("rest/AssetListChannel.json")).asJson
      .check(status is 200)
      .check(checks: _*))
  }

  def searchAssetList(checks: List[HttpCheck] = Nil) = {
    exec(http("Search assets list")
      .post("asset/action/list")
      .body(ElFileBody("rest/AssetListSearch.json")).asJson
      .check(status is 200)
      .check(checks: _*))
  }

  def getAssetListSpecificMedia = {
    exec(http("Get specific media from asset list")
      .post("asset/action/list")
      .body(ElFileBody("rest/AssetListSpecificMedia.json")).asJson
      .check(status is 200))
  }

  def getAssetsBookmarks = {
    exec(http("Get assets bookmark")
      .post("bookmark/action/list")
      .body(ElFileBody("rest/BookmarkList.json")).asJson
      .check(status is 200))
  }

  def getOttUserData = {
    exec(http("Get ott user data")
      .post("OTTUser/action/get")
      .body(ElFileBody("rest/OttUserGet.json")).asJson
      .check(status is 200))

  }

  def addItemToUserAssetsLIst: Unit = {
    exec(http("Add item to user assets list")
      .post("Userassetslistitem/action/add")
      .body(ElFileBody("rest/UserassetslistitemAdd.json")).asJson
      .check(status is 200))
  }


  def getItemFromUserAssetLIst = {
    exec(http("Get item from user asset list")
      .post("Userassetslistitem/action/get")
      .body(ElFileBody("rest/UserassetslistitemGet.json")).asJson
      .check(status is 200))
  }

  def getRegions = {
    exec(http("Get regions")
      .post("region/action/list")
      .body(ElFileBody("rest/RegionList.json")).asJson
      .check(status is 200))
  }

  def getEPGMultiChannelProgram(checks: List[HttpCheck] = Nil) = {
    exec(http("Get EPG multi channel")
      .post("asset/action/list")
      .body(ElFileBody("rest/AssetListEpgChannel.json")).asJson
      .check(status is 200)
      .check(checks: _*))
  }


  def getPlaybackContext = {
    exec(http("Get playback context")
      .post("asset/action/getPlaybackContext")
      .body(ElFileBody("rest/GetPlaybackContext.json")).asJson
      .check(status is 200))

  }

  def GetSubscriptionIDsContainingMediaFile = {
    exec(http("Get subscription ids containing media file")
      .post("subscription/action/list")
      .body(ElFileBody("rest/SubscriptionListMediaFile.json")).asJson
      .check(status is 200))

  }

  def GetSubscriptionsPricesWithCoupon = {
    exec(http("Get subscription prices with coupon")
      .post("productprice/action/list")
      .body(ElFileBody("rest/ProductPriceListSubscription.json")).asJson
      .check(status is 200))
  }

  def getHousehold(checks: List[HttpCheck] = Nil) = {
    exec(http("Get domain info")
      .post("household/action/get")
      .body(ElFileBody("rest/onlyks.json")).asJson
      .check(status is 200)
      .check(checks: _*))

  }


  def addBookMark() = {
    exec(http("Add bookmark")
      .post("bookmark/action/add")
      .body(ElFileBody("rest/BookmarkAdd.json")).asJson
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


}


