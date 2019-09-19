package com.kaltura.performance.scenarios


import com.kaltura.performance.api.RestApi._
import com.kaltura.performance.base.RestBaseScenario
import io.gatling.core.Predef._
import io.gatling.core.Predef.scenario
import com.kaltura.performance.config.Config
import io.gatling.core.structure.ChainBuilder


class VodafoneRestScenario extends RestBaseScenario{

  /*
  setTestName(Config.testName)
  setPartnerId(Config.rest_partner_id)
  setApiVersion(Config.rest_api_version)
  setNumberOfUsers(Config.numberOfUsers)
  setTestDuration(Config.scenarioDuration)
  setRampUpduration(Config.rampUpDuration)
  isTimeBasedScenario = true
  setDelayBetweenTransactions(Config.pauseBetweenRequests)

   */


  def setRunLogic: ChainBuilder = {
    setSessionParams(PARTNER_ID,Config.rest_partner_id)
    setSessionParams(REST_API_VERSION,Config.rest_api_version)
    setSessionParams(REGION_ID, 0)
    setSessionParams(EXTERNAL_ALIAS,"")


    userLogin()
    getHouseholdDeviceList()
    printFromSession("ks")
    getHouseholdDeviceList()
    getOttUserList
    getEntitlementHouseholdSubscriptionList()


    getAssetListChannel()
    getEntitlementHouseholdSubscriptionListAndSaveSubscriptionId()
    getHousehold()
    setSessionParams(SEARCH_ASSETS_FILTER, "genre+''")
    setSessionParams(SEARCH_ASSETS_FILTER_TYPE,"401")
    searchAssetList()
    setSessionParams(BOOKMARK_ASSET_TYPE, "MEDIA")

  }




    .exec(searchAssetList())
    .exec { session =>
      session.set("bookmarkAssetType", "MEDIA")
        .set("bookmarkAssetId", session("mediaId").as[Int])
    }
    .exec(getAssetsBookmarks)
    .exec { session =>
      session.set("ottUserUserName", "")
        .set("userIdIn", session("usersDataSiteGuids").as[String])
    }






  val sc = scenario("Rest test")
   // .exec(_.set(PartnerId, Config.rest_partner_id)) //Tenant
   //.exec(_.set(RestApiVersion, Config.rest_api_version))
    // for now set region id to be 0 - until we will have regions in test scenario
    .exec(_.set("regionId", 0))
    // for now set external alias to be empty - until we have adapters set up properly in test scenario
    .exec(_.set("externalAlias", ""))
    .exec(repeat(Config.repeat_count)
    {
      feed(feeder)
        // .exec(OttUserAnonymousLoginRequest.request
        // 	.check(jsonPath("$.result.ks").saveAs("ks")))
        .exec(userLogin())
        .exec { session =>
          println(session("ks").as[String])
          session
        }
        .exec(getHouseholdDeviceList())
        .exec(getOttUserList)

        // requires purchase to work
        .exec(getEntitlementHouseholdSubscriptionList())
        .exec(getAssetListChannel())
        // alias should come from menu - still not implemented
        // .exec(GetExternalAssetsRequest.request)
        .exec(getEntitlementHouseholdSubscriptionListAndSaveSubscriptionId())
        .exec(getHousehold())
        .exec { session =>
          // get linear media assets
          session.set("searchAssetsFilter", "genre+''")
            .set("searchAssetsFilterTypes", "401")
        }
        .exec(searchAssetList())
        .exec { session =>
          session.set("bookmarkAssetType", "MEDIA")
            .set("bookmarkAssetId", session("mediaId").as[Int])
        }
        .exec(getAssetsBookmarks)
        .exec { session =>
          session.set("ottUserUserName", "")
            .set("userIdIn", session("usersDataSiteGuids").as[String])
        }
        .exec(getOttUserData)
        // Add item to list and then check that it exists
        // .exec(UserassetslistitemAddRequest.request)
        .exec(getItemFromUserAssetLIst)
          // .check(jsonPath("$.result.id").exists)
        .exec(getRegions)
        .exec { session =>
          println(session("epgChannelId").as[String])
          session
        }
        .exec(getEPGMultiChannelProgram()
        )
        .exec { session =>
          session.set("playbackContextAssetType", "media")
            .set("playbackContextAssetId", session("mediaId").as[Int])
        }
        .exec(getPlaybackContext)
        // end of boot
        // .repeat(1) {
        // 	// // start of OK Button
        // 	// exec(AssetListSpecificMediaRequest.request.
        // 	// 	check(jsonPath("$.result.objects[0].tags.Genre.objects[0].value").saveAs("genre")))
        // 	// .exec(BookmarkListRequest.request)
        // 	// // .exec(GetExternalAssetsRequest.request)
        // 	// .exec { session =>
        // 	// 	session.set("searchAssetsFilter", "genre='" + session("genre").as[String] + "'")
        // 	// 	.set("searchAssetsFilterTypes", "")
        // 	// }
        // 	// .exec(AssetListSearchRequest.request)
        // 	// .exec { session =>
        // 	// 	session.set("subscriptionMediaId", session("mediaId").as[Int])
        // 	// 	.set("subscriptionMediaFileId", session("vodMediaFileId").as[Int])
        // 	// }
        // 	// .exec(SubscriptionListMediaFileRequest.request
        // 	// 	.check(jsonPath("$.result.objects[0].id").saveAs("subscriptionId"))
        // 	// )
        // 	// .exec { session =>
        // 	// 	session.set("subscriptionSiteGuid", session("siteGuid").as[String])
        // 	// }
        // 	// .exec(ProductPriceListSubscriptionRequest.request)

        // 	// end OK Button

        // 	// start catch up

        // 	// TODO: set up proper epg, media file and base link!
        // 	// .exec { session =>
        // 	// 	session.set("epgMediaFileId", session("vodMediaFileId").as[String])
        // 	// 	.set("epgBaseLink", "")
        // 	// }
        // 	// .
        // 	exec { session =>
        // 		session.set("playbackContextAssetType", "epg")
        // 		.set("playbackContextAssetId", session("epgItemID").as[Int])
        // 	}
        // 	.exec(GetPlaybackContextRequest.request)
        // 	.exec(BookmarkListRequest.request)
        // 	.exec(AssetListSpecificMediaRequest.request)
        // 	.exec { session =>
        // 		session.set("playbackContextAssetType", "media")
        // 		.set("playbackContextAssetId", session("mediaId").as[Int])
        // 	}
        // 	// zapping
        // 	.exec(GetPlaybackContextRequest.request)
        // 	.pause(1)
        // }
        .exec{ session =>
          session.set("bookmarkAssetType", "media")
            .set("bookmarkAssetId", session("mediaId").as[Int])
            .set("bookmarkAssetFileId", session("vodMediaFileId").as[Int])
            .set("bookmarkAction", "first_play")
        }
        .exec {session =>
          println("normal")
          session
        }
        // 	normal tv viewer: mediamark first play , media hit *10 every 30 sec ) *  100
        .repeat(Config.normal_viewer_repeat_count) {
          exec { session =>
            session.set("playbackContextAssetType", "media")
              .set("playbackContextAssetId", session("mediaId").as[Int])
              .set("bookmarkAction", "first_play")
          }
            .exec(getPlaybackContext)
            .exec(addBookMark)
            .repeat(5)
            {
              exec{ session =>
                session.set("bookmarkAssetType", "media")
                  .set("bookmarkAssetId", session("mediaId").as[Int])
                  .set("bookmarkAssetFileId", session("vodMediaFileId").as[Int])
                  .set("bookmarkAction", "hit")
              }
                .exec(addBookMark)
                .pause(Config.tvpapi_media_hit_pause)
            }
            .exec { session =>
              // get linear media assets - different than previous
              session.set("searchAssetsFilter", "media_id!='" + session("mediaId").as[String] + "'")
                .set("searchAssetsFilterTypes", "401")
            }
            .exec(searchAssetList())
        }
    }
  )

}
