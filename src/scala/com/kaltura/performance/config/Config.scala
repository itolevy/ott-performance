package com.kaltura.performance.config
import scala.concurrent.duration._

	object Config {

		//Global config

		val testName = System.getProperty("test_name")
		val scenarioRepeatValue = System.getProperty("scenario_repeat_value")
		val pauseBetweenRequests= System.getProperty("pause_between_requests")
		val scenarioDuration = System.getProperty("scenario_duration")
		val rampUpDuration = System.getProperty("ramp_up_duration")
		val numberOfUsers = System.getProperty("number_of_users")

		// TVP APi environment config
	  val base_url = "http://34.249.122.223:8080/v5_2_2/api_v3/service/"
	  val header_content_type = "Content-Type"
	  val json_header = "application/json"
	  var tvpapi_base_url = System.getProperty("base_url")
	  var tvpapi_version = "5_1_2"
	  var tvpapi_url = tvpapi_base_url + "/v" + tvpapi_version + "/gateways/JsonPostGW.aspx"
	  var repeat_count = Integer.getInteger("repeat_count", 1).toInt
	  var tvpapi_simulation_at_once_users = Integer.getInteger("users", 1)
	  var is_tokenized = "false"
	  var tvpapi_localeuserstate = "Unknown"
	  var tvpapi_platform = "ConnectedTV" // Cellular = tokens , ConnectedTV = no tokens
	  var tvpapi_username = "tvpapi_222"
	  var tvpapi_password = "11111"
	  var tvpapi_ramp_users = Integer.getInteger("users", 1)
	  var tvpapi_ramp_duration = Duration(java.lang.Long.getLong("rampup", 30L), "seconds")
	  var tvpapi_media_hit_pause = Integer.getInteger("media_hit_pause", 30)
	  var tvpapi_initial_pause = Integer.getInteger("initial_pause", 1)


		// REST environment config
	  var rest_url = System.getProperty("base_url")
	  var rest_partner_id =  Integer.getInteger("rest_partner_id", 222)
	  var rest_api_version = "5.2.2.5524"
	  var normal_viewer_repeat_count = Integer.getInteger("normal_viewer_repeat_count", 50).toInt
	}
