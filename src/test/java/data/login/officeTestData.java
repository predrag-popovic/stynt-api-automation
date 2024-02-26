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

    /********************************************************************************************
     METHOD FOR SENDING PARAMETERS FOR CREDENTIALS
     ********************************************************************************************/

    public static void ParamsForValidCredentials(JSONObject requestParamsForOfficeSubmitValidCredentials) {
        requestParamsForOfficeSubmitValidCredentials.put("email", OFFICE_VERIFIED_EMAIL);
        requestParamsForOfficeSubmitValidCredentials.put("password", OFFICE_VERIFIED_PASSWORD);
    }

    /********************************************************************************************
     METHOD FOR VERIFICATION EXPECTED RESULT THAT WE GET FORM BODY
     ********************************************************************************************/
    public static void verifyThaOfficeLoginSuccessfully(Response officeSuccessfullyLogin) {
        Assertions.assertEquals(200, officeSuccessfullyLogin.statusCode());
        Assertions.assertEquals("true", officeSuccessfullyLogin.jsonPath().getString("success"));
    }
}
