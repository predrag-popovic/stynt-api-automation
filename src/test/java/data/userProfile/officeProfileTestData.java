package data.userProfile;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

public class officeProfileTestData {

    /********************************************************************************************
     TEST DATA THAT WE USE FOR OFFICE USERS
     ********************************************************************************************/
    public static final String OFFICE_BEARER_TOKEN = "eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJTdHludCBvZmZpY2UiLCJpZCI6ImJhMmZmYWY2LWQyNGUtNDMyMS1iY2NiLWEzY2Y3NGM1MTA3ZCIsImVtYWlsIjoicWF0ZXN0cWE3NStpbEBnbWFpbC5jb20iLCJpYXQiOjE3MDkyODg5NTEsImV4cCI6MTcwOTY0ODk1MX0.WcZYvj2hOmLCMHX4gfiN92igiuBXI_k29rdRnNUowFk";

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
