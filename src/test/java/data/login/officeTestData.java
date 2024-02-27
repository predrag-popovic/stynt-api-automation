package data.login;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

public class officeTestData {

    /********************************************************************************************
     TEST DATA AND ENDPOINT URL THAT WE USE FOR PROFESSIONAL USERS
     ********************************************************************************************/

    public static final  String OFFICE_LOGIN_END_POINT_URL = "https://offices.preprod.stynt.com/app/wapi/v1/login";
    public static final String OFFICE_VERIFIED_EMAIL = "qatestqa75+db1@gmail.com";
    public static final String OFFICE_VERIFIED_PASSWORD = "Gecko123";
    public static final String OFFICE_EMPTY_EMAIL = "";
    public static final String OFFICE_EMPTY_PASSWORD = "";
    public static final String OFFICE_INVALID_EMAIL = "qatestqa75+db12143124pro@gmail.com";
    public static final String OFFICE_INVALID_PASSWORD = "Gecko12";
    public static final String OFFICE_UNVERIFIED_EMAIL = "qatestqa75+tos1@gmail.com";
    public static final String OFFICE_DISABLED_EMAIL = "qatestqa75+db2@gmail.com";

    /********************************************************************************************
     METHOD FOR SENDING PARAMETERS FOR CREDENTIALS
     ********************************************************************************************/

    public static void ParamsForValidCredentials(JSONObject requestParamsForOfficeSubmitValidCredentials) {
        requestParamsForOfficeSubmitValidCredentials.put("email", OFFICE_VERIFIED_EMAIL);
        requestParamsForOfficeSubmitValidCredentials.put("password", OFFICE_VERIFIED_PASSWORD);
    }
    public static void ParamsForEmptyCredentials(JSONObject requestParamsForOfficeSubmitEmptyCredentials) {
        requestParamsForOfficeSubmitEmptyCredentials.put("email", OFFICE_EMPTY_EMAIL);
        requestParamsForOfficeSubmitEmptyCredentials.put("password", OFFICE_EMPTY_PASSWORD);
    }
    public static void ParamsForValidEmailAndEmptyPassword(JSONObject requestParamsForOfficeSubmitValidValidEmailAndEmptyPassword) {
        requestParamsForOfficeSubmitValidValidEmailAndEmptyPassword.put("email", OFFICE_VERIFIED_EMAIL);
        requestParamsForOfficeSubmitValidValidEmailAndEmptyPassword.put("password", OFFICE_EMPTY_PASSWORD);
    }
    public static void ParamsForEmptyEmailAndValidPassword(JSONObject requestParamsForOfficeSubmitValidValidEmailAndEmptyPassword) {
        requestParamsForOfficeSubmitValidValidEmailAndEmptyPassword.put("email", OFFICE_EMPTY_EMAIL);
        requestParamsForOfficeSubmitValidValidEmailAndEmptyPassword.put("password", OFFICE_VERIFIED_PASSWORD);
    }
    public static void ParamsForInvalidCredentials(JSONObject requestParamsForOfficeSubmitInvalidCredentials) {
        requestParamsForOfficeSubmitInvalidCredentials.put("email", OFFICE_INVALID_EMAIL);
        requestParamsForOfficeSubmitInvalidCredentials.put("password", OFFICE_INVALID_PASSWORD);
    }
    public static void ParamsForInvalidEmailAndValidPassword(JSONObject requestParamsForOfficeSubmitInvalidEmailAndValidPassword) {
        requestParamsForOfficeSubmitInvalidEmailAndValidPassword.put("email", OFFICE_INVALID_EMAIL);
        requestParamsForOfficeSubmitInvalidEmailAndValidPassword.put("password", OFFICE_VERIFIED_PASSWORD);
    }
    public static void ParamsForValidEmailAndInvalidPassword(JSONObject requestParamsForOfficeSubmitValidEmailAndInvalidPassword) {
        requestParamsForOfficeSubmitValidEmailAndInvalidPassword.put("email", OFFICE_VERIFIED_EMAIL);
        requestParamsForOfficeSubmitValidEmailAndInvalidPassword.put("password", OFFICE_INVALID_PASSWORD);
    }
    public static void ParamsForUnverifiedUserValidCredentials(JSONObject requestParamsForOfficeSubmitValidCredentials) {
        requestParamsForOfficeSubmitValidCredentials.put("email", OFFICE_UNVERIFIED_EMAIL);
        requestParamsForOfficeSubmitValidCredentials.put("password", OFFICE_VERIFIED_PASSWORD);
    }
    public static void ParamsForDisabledUserValidCredentials(JSONObject requestParamsForOfficeSubmitValidCredentials) {
        requestParamsForOfficeSubmitValidCredentials.put("email", OFFICE_DISABLED_EMAIL);
        requestParamsForOfficeSubmitValidCredentials.put("password", OFFICE_VERIFIED_PASSWORD);
    }

    /********************************************************************************************
     METHOD FOR VERIFICATION EXPECTED RESULT THAT WE GET FORM BODY
     ********************************************************************************************/
    public static void verifyThaOfficeLoginSuccessfully(Response officeSuccessfullyLogin) {
        Assertions.assertEquals(200, officeSuccessfullyLogin.statusCode());
        Assertions.assertEquals("true", officeSuccessfullyLogin.jsonPath().getString("success"));
    }
    public static void verifyThatOfficeLoginUnsuccessfully(Response officeUnsuccessfullyLogin) {
        Assertions.assertEquals(401, officeUnsuccessfullyLogin.statusCode());
    }
}
