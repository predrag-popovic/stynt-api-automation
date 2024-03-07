package data.userProfile;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

public class professionalProfileTestData {

    /********************************************************************************************
     TEST DATA THAT WE USE FOR PROFESSIONAL USERS
     ********************************************************************************************/
    public static final String PROFESSIONAL_VERIFIED_EMAIL = "qatestqa75+db1pro@gmail.com";
    public static final String PROFESSIONAL_VERIFIED_PASSWORD = "Gecko123";
    public static final String PROFESSIONAL_APPLICATION_ID = "28i1h1n6pvof1xeqc3ao";
    public static final String PROFESSIONAL_APPLICATION_SECRET = "ngiwv0r00sftu2gvzkpk";
    public static final String PROFESSIONAL_TYPE = "LOGIN";

    /********************************************************************************************
     METHOD FOR SENDING PARAMETERS FOR CREDENTIALS
     ********************************************************************************************/
    public static void ParamsForValidCredentials(JSONObject requestParamsForVerifiedProfessional) {
        requestParamsForVerifiedProfessional.put("applicationId", PROFESSIONAL_APPLICATION_ID);
        requestParamsForVerifiedProfessional.put("applicationSecret", PROFESSIONAL_APPLICATION_SECRET);
        requestParamsForVerifiedProfessional.put("email", PROFESSIONAL_VERIFIED_EMAIL);
        requestParamsForVerifiedProfessional.put("password", PROFESSIONAL_VERIFIED_PASSWORD);
        requestParamsForVerifiedProfessional.put("type", PROFESSIONAL_TYPE);
    }

    /********************************************************************************************
     METHOD FOR VERIFICATION EXPECTED RESULT THAT WE GET FORM BODY
     ********************************************************************************************/
    public static void verifyThatProfessionalGetUserProfileDataSuccessfully(Response officeSuccessfullyGetUserProfileData) {
        Assert.assertEquals(200, officeSuccessfullyGetUserProfileData.statusCode());
    }
}
