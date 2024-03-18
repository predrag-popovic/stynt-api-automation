package office_api_tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import static data.login.officeLoginTestData.ParamsForValidCredentials;
import static io.restassured.RestAssured.given;

import data.userProfile.officeProfileTestData;
import org.junit.jupiter.api.Test;
import utility.PropertyManager;

@Epic("Automate API for Office user profile")

public class officeProfileTest extends officeProfileTestData {

    private static PropertyManager properties = PropertyManager.getInstance();
    private static final String officeUserProfileEndPoint = properties.getEndPointUserProfileOffice();
    private static final String officeLoginEndPoint = properties.getEndPointLoginOffice();

    @Test
    @Feature("01. TC Verify that the appropriate data is returned for the office user")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyUserProfileDataForOfficeUser() {

        JSONObject requestParamsForOfficeSubmitValidCredentials = new JSONObject();
        ParamsForValidCredentials(requestParamsForOfficeSubmitValidCredentials);

        Response officeLogin = getResponseOfficeLogin(requestParamsForOfficeSubmitValidCredentials);
        String accessTokenOffice = getAccessToken(officeLogin);

        Response officeUserProfile = getResponseOfficeUserProfile(requestParamsForOfficeSubmitValidCredentials, accessTokenOffice);

        verifyThatOfficeGetUserProfileDataSuccessfully(officeUserProfile);
    }

    private static Response getResponseOfficeUserProfile(JSONObject requestParams, String accessTokenOffice) {
        Response officeUserProfile = given()
                .header("Authorization", "Bearer " + accessTokenOffice)
                .body(requestParams.toString())
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .get(officeUserProfileEndPoint)
                .andReturn()
                .then()
                .log().all()
                .extract().response();
        return officeUserProfile;
    }

    private static Response getResponseOfficeLogin(JSONObject requestParams) {
        Response officeSuccessfullyLogin = given()
                .body(requestParams.toString())
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .post(officeLoginEndPoint)
                .andReturn()
                .then()
                .log().all()
                .extract().response();
        return officeSuccessfullyLogin;
    }

    private static String getAccessToken(Response verifiedOfficeLogin) {
        // Get the response body as a string
        String responseBody = verifiedOfficeLogin.getBody().asString();

        // Parse the response body as a JSON object
        JsonPath jsonPath = new JsonPath(responseBody);

        // Now you can access values from the JSON object
        String accessTokenOffice = jsonPath.get("data.token");
        return accessTokenOffice;
    }

}
