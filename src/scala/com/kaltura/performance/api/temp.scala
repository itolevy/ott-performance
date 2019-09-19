package com.kaltura.performance.api

import io.gatling.core.Predef._
import io.gatling.http.Predef._
//import com.performanceTesting.config.Config

object OttUserAnonymousLoginRequest {
  val request = http("ottuser/action/anonymouslogin")
    .post("ottuser/action/anonymouslogin")
    .body(ElFileBody("rest/OttUserAnonymousLogin.json")).asJson
    .check(status is 200)
}

object OttUserLoginRequest {
  val request = http("ottuser/action/login")
    .post("ottuser/action/login")
    .body(ElFileBody("rest/OttUserLogin.json")).asJson
    .check(status is 200)
}

// GetDeviceDomains
object HouseholdDeviceListRequest {
  val request = http("householdDevice/action/list")
    .post("householdDevice/action/list")
    .body(ElFileBody("rest/onlyks.json")).asJson
    .check(status is 200)
}

// GetUserData 1
object OttUserListRequest {
  val request = http("OTTUser/action/list")
    .post("OTTUser/action/list")
    .body(ElFileBody("rest/OttUserList.json")).asJson
    .check(status is 200)
}

// GetDomainPermittedItems
// GetDomainPermittedSubscriptionsRequest
object EntitlementListHouseholdSubscriptionRequest {
  val request = http("entitlement/action/list - household;subscription")
    .post("entitlement/action/list")
    .body(ElFileBody("rest/EntitlementListHouseholdSubscription.json")).asJson
    .check(status is 200)
}

// GetChannelMultiFilterRequest
object AssetListChannelRequest {
  val request = http("asset/action/list - channel")
    .post("asset/action/list")
    .body(ElFileBody("rest/AssetListChannel.json")).asJson
    .check(status is 200)
}

// SearchAssetsRequest
object AssetListSearchRequest {
  val request = http("asset/action/list - search")
    .post("asset/action/list")
    .body(ElFileBody("rest/AssetListSearch.json")).asJson
    .check(status is 200)
}

// GetMediasInfoRequest
object AssetListSpecificMediaRequest {
  val request = http("asset/action/list - specific media")
    .post("asset/action/list")
    .body(ElFileBody("rest/AssetListSpecificMedia.json")).asJson
    .check(status is 200)
}

// GetAssetsBookmarksRequest
object BookmarkListRequest {
  val request = http("bookmark/action/list")
    .post("bookmark/action/list")
    .body(ElFileBody("rest/BookmarkList.json")).asJson
    .check(status is 200)
}

// GetUserData - 2
object OttUserGetRequest {
  val request = http("OTTUser/action/get")
    .post("OTTUser/action/get")
    .body(ElFileBody("rest/OttUserGet.json")).asJson
    .check(status is 200)
}

// AddItemToListRequest
object UserassetslistitemAddRequest {
  val request = http("Userassetslistitem/action/add")
    .post("Userassetslistitem/action/add")
    .body(ElFileBody("rest/UserassetslistitemAdd.json")).asJson
    .check(status is 200)
}

// GetItemFromListRequest
object UserassetslistitemGetRequest {
  val request = http("Userassetslistitem/action/get")
    .post("Userassetslistitem/action/get")
    .body(ElFileBody("rest/UserassetslistitemGet.json")).asJson
    .check(status is 200)
}

// GetRegionsRequest
object RegionListRequest {
  val request = http("region/action/list")
    .post("region/action/list")
    .body(ElFileBody("rest/RegionList.json")).asJson
    .check(status is 200)
}

// GetEPGMultiChannelProgramRequest
object AssetListEpgChannelRequest {
  val request = http("asset/action/list - epg channel")
    .post("asset/action/list")
    .body(ElFileBody("rest/AssetListEpgChannel.json")).asJson
    .check(status is 200)
}

// GetMediaLicenseLinkRequest
// GetEPGLicensedLinkRequest
object GetPlaybackContextRequest {
  val request = http("asset/action/getPlaybackContext")
    .post("asset/action/getPlaybackContext")
    .body(ElFileBody("rest/GetPlaybackContext.json")).asJson
    .check(status is 200)
}

// GetSubscriptionIDsContainingMediaFileRequest
object SubscriptionListMediaFileRequest {
  val request = http("subscription/action/list - media file")
    .post("subscription/action/list")
    .body(ElFileBody("rest/SubscriptionListMediaFile.json")).asJson
    .check(status is 200)
}

// GetSubscriptionsPricesWithCouponRequest
object ProductPriceListSubscriptionRequest {
  val request = http("productprice/action/list - subscription")
    .post("productprice/action/list")
    .body(ElFileBody("rest/ProductPriceListSubscription.json")).asJson
    .check(status is 200)
}

// GetDomainInfo
object HouseholdGetSelfRequest {
  val request = http("household/action/get")
    .post("household/action/get")
    .body(ElFileBody("rest/onlyks.json")).asJson
    .check(status is 200)
}

// MediaMark
object BookmarkAddRequest {
  val request = http("bookmark/action/add")
    .post("bookmark/action/add")
    .body(ElFileBody("rest/BookmarkAdd.json")).asJson
    .check(status is 200)
}

