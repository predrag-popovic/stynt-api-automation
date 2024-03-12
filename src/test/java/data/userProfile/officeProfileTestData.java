package data.userProfile;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

public class officeProfileTestData {

    /********************************************************************************************
     TEST DATA THAT WE USE FOR OFFICE USERS
     ********************************************************************************************/
    public static final String OFFICE_BEARER_TOKEN = "eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJTdHludCBvZmZpY2UiLCJpZCI6IjM1N2VjN2M4LTYxMmEtNGU5MS1iZmI4LWE0NTVlMmM4NTlmYyIsImVtYWlsIjoicWF0ZXN0cWE3NStkYjFAZ21haWwuY29tIiwiaWF0IjoxNzEwMTQzNzQ5LCJleHAiOjE3MTA1MDM3NDl9.2KKDmjZ9BkNiJi8QGFM9IMwz3_oVN5xVE23Kup3adao";

    /********************************************************************************************
     METHOD FOR SENDING PARAMETERS FOR CREDENTIALS
     ********************************************************************************************/
    public static void ParamsForBearerToken(JSONObject requestParamsForOfficeBearerToken) {
        requestParamsForOfficeBearerToken.put("Bearer", OFFICE_BEARER_TOKEN);
    }

    /********************************************************************************************
     METHOD FOR VERIFICATION EXPECTED RESULT THAT WE GET FORM BODY
     ********************************************************************************************/
    public static void verifyThatOfficeGetUserProfileDataSuccessfully(Response officeSuccessfullyGetUserProfileData) {
        Assert.assertEquals(200, officeSuccessfullyGetUserProfileData.statusCode());
        Assert.assertEquals("Office DB Test 1", officeSuccessfullyGetUserProfileData.jsonPath().getString("load.name"));
        Assert.assertEquals("CLIENT", officeSuccessfullyGetUserProfileData.jsonPath().getString("load.type"));
    }


}
