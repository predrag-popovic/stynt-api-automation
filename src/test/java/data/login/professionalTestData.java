package data.login;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

public class professionalTestData {

    /********************************************************************************************
     TEST DATA AND ENDPOINT URL THAT WE USE FOR PROFESSIONAL USERS
     ********************************************************************************************/

    public static final  String PROFESSIONAL_LOGIN_END_POINT_URL = "https://preprod.stynt.com/api/v18/authenticate";
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
    public static void ParamsForEmptyCredentials(JSONObject requestParamsForVerifiedProfessional) {
        requestParamsForVerifiedProfessional.put("applicationId", PROFESSIONAL_APPLICATION_ID);
        requestParamsForVerifiedProfessional.put("applicationSecret", PROFESSIONAL_APPLICATION_SECRET);
        requestParamsForVerifiedProfessional.put("email", "");
        requestParamsForVerifiedProfessional.put("password", "");
        requestParamsForVerifiedProfessional.put("type", PROFESSIONAL_TYPE);
    }

    /********************************************************************************************
     METHOD FOR VERIFICATION EXPECTED RESULT THAT WE GET FORM BODY
     ********************************************************************************************/

    public static void verifyThatProfessionalLoginSuccessfully(Response verifiedProfessionalSuccessfullyLogin) {
        Assertions.assertEquals(200, verifiedProfessionalSuccessfullyLogin.statusCode());
        Assertions.assertEquals("PERSONNEL", verifiedProfessionalSuccessfullyLogin.jsonPath().getString("userType"));
        Assertions.assertEquals("79543", verifiedProfessionalSuccessfullyLogin.jsonPath().getString("userId"));
    }

    public static void verifyThatVerifiedProfessionalCanNotLoginWithEmptyEmailAndPassword(Response verifiedProfessionalCanNotLogInWithEmptyEmailAndPassword) {
        Assertions.assertEquals(400, verifiedProfessionalCanNotLogInWithEmptyEmailAndPassword.statusCode());
        Assertions.assertEquals("User does not exist.", verifiedProfessionalCanNotLogInWithEmptyEmailAndPassword.asString());
    }

}
