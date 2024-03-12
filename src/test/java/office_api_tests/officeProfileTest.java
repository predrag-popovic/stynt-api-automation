package office_api_tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.given;

import data.userProfile.officeProfileTestData;
import utility.PropertyManager;

@Epic("Automate API for Office user profile")

public class officeProfileTest extends officeProfileTestData {

    private static PropertyManager properties = PropertyManager.getInstance();
    private static final String officeUserProfileEndPoint = properties.getEndPointUserProfileOffice();

    @Test
    @Feature("01. TC Verify that the appropriate data is returned for the office user")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyUserProfileDataForOfficeUser() {

        JSONObject requestParamsForOfficeSubmitValidCredentials = new JSONObject();

        Response officeUserProfile = getResponseOfficeUserProfile(requestParamsForOfficeSubmitValidCredentials);

        verifyThatOfficeGetUserProfileDataSuccessfully(officeUserProfile);
    }

    private static Response getResponseOfficeUserProfile(JSONObject requestParams) {
        Response officeUserProfile = given()
                .header("Authorization", "Bearer " + OFFICE_BEARER_TOKEN)
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

}
