package professional_api_tests;

import data.userProfile.professionalProfileTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import utility.PropertyManager;

import static io.restassured.RestAssured.given;

@Epic("Automate API for Professional user profile")
public class professionalProfileTest extends professionalProfileTestData {

    private static PropertyManager properties = PropertyManager.getInstance();
    private static final String professionalLoginEndPoint = properties.getEndPointLoginProfessional();
    private static final String professionalUserProfileEndPoint = properties.getEndPointUserProfileProfessional();

    @Test
    @Feature("01.TC Verify that the appropriate data is returned for the Professional user")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyUserProfileDataForProfessionalUser() {

        JSONObject requestParamsForVerifiedProfessionalSubmitValidCredentials = new JSONObject();
        ParamsForValidCredentials(requestParamsForVerifiedProfessionalSubmitValidCredentials);

        Response verifiedProfessionalLogin = getResponseProfessionalLogin(requestParamsForVerifiedProfessionalSubmitValidCredentials);

        String accessTokenProfessional = getAccessToken(verifiedProfessionalLogin);

        JSONObject requestProfessionalProfileData = new JSONObject();

        Response professionalUserProfile = getResponseProfessionalUserProfile(requestProfessionalProfileData,accessTokenProfessional);

        verifyThatProfessionalGetUserProfileDataSuccessfully(professionalUserProfile);
    }

    private static Response getResponseProfessionalUserProfile(JSONObject requestParams, String accessTokenProfessional) {
        Response professionalUserProfile = given()
                .body(requestParams.toString())
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .get(professionalUserProfileEndPoint + accessTokenProfessional + "/personnel/profile-steps")
                .andReturn()
                .then()
                .log().all()
                .extract().response();
        return professionalUserProfile;
    }

    private static Response getResponseProfessionalLogin(JSONObject requestParams) {
        Response verifiedProfessionalSuccessfullyLogin = given()
                .body(requestParams.toString())
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .post(professionalLoginEndPoint)
                .andReturn()
                .then()
                .log().all()
                .extract().response();
        return verifiedProfessionalSuccessfullyLogin;
    }

    private static String getAccessToken(Response verifiedProfessionalLogin) {
        // Get the response body as a string
        String responseBody = verifiedProfessionalLogin.getBody().asString();

        // Parse the response body as a JSON object
        JsonPath jsonPath = new JsonPath(responseBody);

        // Now you can access values from the JSON object
        String accessTokenProfessional = jsonPath.get("accessToken");
        return accessTokenProfessional;
    }
}
