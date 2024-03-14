package office_api_tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import data.userProfile.officeEditProfileTestData;
import utility.PropertyManager;

@Epic("Automate API for edit Office user profile")


public class officeEditProfileTest extends officeEditProfileTestData {

    private static PropertyManager properties = PropertyManager.getInstance();
    private static final String officeEditUserProfileEndPoint = properties.getEndPointEditUserProfileOffice();
    private static final String officeLoginEndPoint = properties.getEndPointLoginOffice();

    @Test
    @Feature("01. TC Verify that user can update the primary profile with valid data")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatUserCanUpdateProfileWithValidData() {
        JSONObject requestParamsForOfficeSubmitValidCredentials = new JSONObject();
        ParamsForValidCredentials(requestParamsForOfficeSubmitValidCredentials);

        Response officeLogin = getResponseOfficeLogin(requestParamsForOfficeSubmitValidCredentials);
        String accessTokenOffice = getAccessToken(officeLogin);

        Response officeEditUserProfile = putRequestEditOfficeUserProfileWithValidData(ParamsForEditProfileWithValidData (), accessTokenOffice);
        verifyThatOfficeUserUpdatedProfileDataSuccessfully(officeEditUserProfile);
    }
    @Test
    @Feature("02. TC Verify that user can't update the primary profile with an empty 'practiceName'")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatUserCannotUpdateProfileWithEmptyPracticeName() {
        JSONObject requestParamsForOfficeSubmitValidCredentials = new JSONObject();
        ParamsForValidCredentials(requestParamsForOfficeSubmitValidCredentials);

        Response officeLogin = getResponseOfficeLogin(requestParamsForOfficeSubmitValidCredentials);
        String accessTokenOffice = getAccessToken(officeLogin);

        Response officeEditUserProfile = putRequestEditOfficeUserProfileWithEmptyPracticeName(ParamsForEditProfileWithEmptyPracticeName(), accessTokenOffice);
        verifyThatOfficeUserUpdatedProfileDataUnsuccessfully(officeEditUserProfile);
    }

    private static Response putRequestEditOfficeUserProfileWithValidData(JSONObject requestParams, String accessTokenOffice) {
        Response officeEditUserProfile = given()
                .header("Authorization", "Bearer " + accessTokenOffice)
                .body(requestParams.toString())
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .put(officeEditUserProfileEndPoint)
                .andReturn()
                .then()
                .log().all()
                .extract().response();
        return officeEditUserProfile;
    }
    private static Response putRequestEditOfficeUserProfileWithEmptyPracticeName(JSONObject requestParams, String accessTokenOffice) {
        Response officeEditUserProfile = given()
                .header("Authorization", "Bearer " + accessTokenOffice)
                .body(requestParams.toString())
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .put(officeEditUserProfileEndPoint)
                .andReturn()
                .then()
                .log().all()
                .extract().response();
        return officeEditUserProfile;
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
