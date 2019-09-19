package com.kaltura.performance.api

import com.kaltura.performance.base.TvpApiBaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class TvpApi extends TvpApiBaseSimulation {


  def signIn() = {
    exec(http("Sign in")
      .post("")
      .queryParam("m", "SignIn")
      .body(ElFileBody("tvpapi/SignIn.json")).asJson
      .check(status is 200)
      .check(jsonPath("$..SiteGuid")))
  }

  def getDomainInfoRequest = {
    exec(http("Get domain info")
      .post("")
      .queryParam("m", "GetDomainInfo")
      .body(ElFileBody("tvpapi/GetDomainInfo.json")).asJson
      .check(status is 200)
      // basically validate response
      .check(jsonPath("$..m_nDomainID")))
  }

  def getMediaInfoRequest() = {
    exec(http("Get media info")
      .post("")
      .queryParam("m", "GetMediaInfo")
      .body(ElFileBody("tvpapi/GetMediaInfo.json")).asJson
      .check(status is 200)
      .check(jsonPath("$..MediaID")))
  }

  def getMediasInfoRequest() = {
    exec(http("Get medias info")
      .post("")
      .queryParam("m", "GetMediasInfo")
      .body(ElFileBody("tvpapi/GetMediasInfo.json")).asJson
      .check(status is 200))

  }

  def getAssetsBookmarks() = {
    exec(http("Get assets bookmark")
      .post("")
      .queryParam("m", "GetAssetsBookmarks")
      .body(ElFileBody("tvpapi/GetAssetsBookmarks.json")).asJson
      .check(status is 200))
  }

  def getExternalAssetsRequest() = {
    exec(http("Get external assets")
      .post("")
      .queryParam("m", "GetExternalAssets")
      .body(ElFileBody("tvpapi/GetExternalAssets.json")).asJson
      .check(status is 200))
  }

  def getMediaLicenseLink = {
    exec(http("Get media license link")
      .post("")
      .queryParam("m", "GetMediaLicenseLink")
      .body(ElFileBody("tvpapi/GetMediaLicenseLink.json")).asJson
      .check(status is 200))

  }

  def getSubscriptionIdsContainingMediaFiles = {
    exec(http("Get subscription IDs containing media file")
      .post("")
      .queryParam("m", "GetSubscriptionIDsContainingMediaFile")
      .body(ElFileBody("tvpapi/GetSubscriptionIDsContainingMediaFile.json")).asJson
      .check(status is 200))
  }

  def getSubscriptionsPricesWithCouponRequest() = {
    exec(http("Get subscriptions prices with coupon")
      .post("")
      .queryParam("m", "GetSubscriptionsPricesWithCoupon")
      .body(ElFileBody("tvpapi/GetSubscriptionsPricesWithCoupon.json")).asJson
      .check(status is 200))

  }

  def searchAssets() = {
    exec(http("Search assets")
      .post("")
      .queryParam("m", "SearchAssets")
      .body(ElFileBody("tvpapi/SearchAssets.json")).asJson
      .check(status is 200)
      .check(jsonPath("$.status").exists)
      .check(jsonPath("$.assets").exists))
  }

  def getChannelMultiFIlter() = {
    exec(http("Get channel multi filter")
      .post("")
      .queryParam("m", "GetChannelMultiFilter")
      .body(ElFileBody("tvpapi/GetChannelMultiFilter.json")).asJson
      .check(status is 200))
  }


  def getDomainPermittedItems = {
    exec(http("Get domain permitted items")
      .post("")
      .queryParam("m", "GetDomainPermittedItems")
      .body(ElFileBody("tvpapi/GetDomainPermittedItems.json")).asJson
      .check(status is 200))
  }


  def getDomainPermittedSubscriptions() = {
    exec(http("Get domain permitted subscriptions")
      .post("")
      .queryParam("m", "GetDomainPermittedSubscriptions")
      .body(ElFileBody("tvpapi/GetDomainPermittedSubscriptions.json")).asJson
      .check(status is 200))
  }

  def getEPGLicensedLink = {
    exec(http("Get EPG licensed link")
      .post("")
      .queryParam("m", "GetEPGLicensedLink")
      .body(ElFileBody("tvpapi/GetEPGLicensedLink.json")).asJson
      .check(status is 200))
  }

  def getEPGMultiChannelProgram = {
    exec(http("Get EPG multi channel program")
      .post("")
      .queryParam("m", "GetEPGMultiChannelProgram")
      .body(ElFileBody("tvpapi/GetEPGMultiChannelProgram.json")).asJson
      .check(status is 200))
  }

  def getEPGMultiChannelProgramNow = {
    exec(http("Get EPG multi channel program now")
      .post("")
      .queryParam("m", "GetEPGMultiChannelProgram")
      .body(ElFileBody("tvpapi/GetEPGMultiChannelProgramNow.json")).asJson
      .check(status is 200))
  }


  def getItemFromList() = {
    exec(http("Get item from list")
      .post("")
      .queryParam("m", "GetItemFromList")
      .body(ElFileBody("tvpapi/GetItemFromList.json")).asJson
      .check(status is 200))
  }

  def addItemToList() = {
    exec(http("Add item to list")
      .post("")
      .queryParam("m", "AddItemToList")
      .body(ElFileBody("tvpapi/AddItemToList.json")).asJson
      .check(status is 200))
  }

  def addItemTOList() = {
    exec(http("Add item to list")
      .post("")
      .queryParam("m", "AddItemToList")
      .body(ElFileBody("tvpapi/AddItemToList.json")).asJson
      .check(status is 200))
  }

  def getMenu() = {
    exec(http("Get menu")
      .post("")
      .queryParam("m", "GetMenu")
      .body(ElFileBody("tvpapi/GetMenu.json")).asJson
      .check(status is 200))
  }

  def getRecordings() = {
    exec(http("Get recordings")
      .post("")
      .queryParam("m", "GetRecordings")
      .body(ElFileBody("tvpapi/GetRecordings.json")).asJson
      .check(status is 200))
  }

  def getRegions() = {
    exec(http("Get regions")
      .post("")
      .queryParam("m", "GetRegions")
      .body(ElFileBody("tvpapi/GetRegions.json")).asJson
      .check(status is 200))
  }

  def getSecuredSiteGuide() = {

    exec(http("Get secured site GUID")
      .post("")
      .queryParam("m", "GetSecuredSiteGuid")
      .body(ElFileBody("tvpapi/GetSecuredSiteGuid.json")).asJson
      .check(status is 200))
  }


  def getSeriesRecordings() ={
    exec(http("Get series recordings")
      .post("")
      .queryParam("m", "GetSeriesRecordings")
      .body(ElFileBody("tvpapi/GetSeriesRecordings.json")).asJson
      .check(status is 200))
  }

def getUserData() ={
  exec(http("GetUserData")
    .post("")
    .queryParam("m", "GetUserData")
    .body(ElFileBody("tvpapi/GetUserData.json")).asJson
    .check(status is 200))
}

 def getUsersData() ={
   exec(http("GetUsersData")
     .post("")
     .queryParam("m", "GetUsersData")
     .body(ElFileBody("tvpapi/GetUsersData.json")).asJson
     .check(status is 200))
 }

 def getDeviceDomains() ={
   exec(http("GetDeviceDomains")
     .post("")
     .queryParam("m", "GetDeviceDomains")
     .body(ElFileBody("tvpapi/GetDeviceDomains.json")).asJson
     .check(status is 200))
 }

 def markMedia() ={
   exec(http("MediaMark")
     .post("")
     .queryParam("m", "MediaMark")
     .body(ElFileBody("tvpapi/MediaMark.json")).asJson
     .check(status is 200))
 }

  def hitMedia() ={
    exec(http("MediaHit")
      .post("")
      .queryParam("m", "MediaHit")
      .body(ElFileBody("tvpapi/MediaHit.json")).asJson
      .check(status is 200))
  }

}
