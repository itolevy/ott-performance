package com.kaltura.performance.scenarios


import com.kaltura.performance.api.RestApi._
import com.kaltura.performance.base.RestBaseScenario
import io.gatling.core.Predef._
import com.kaltura.performance.config.Config
import io.gatling.core.structure.ChainBuilder

class LoginOnlyScenario extends RestBaseScenario{



  def setRunLogic: ChainBuilder = {

    setSessionParams(PARTNER_ID, Config.rest_partner_id)
    setSessionParams(REST_API_VERSION, Config.rest_api_version)
    setSessionParams(REGION_ID, 0)
    setSessionParams(EXTERNAL_ALIAS, "")
    userLogin()
    getHouseholdDeviceList()
    printFromSession("ks")
    getHouseholdDeviceList()
    getOttUserList
    getEntitlementHouseholdSubscriptionList()

  }

}
