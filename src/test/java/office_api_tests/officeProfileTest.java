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
                .header("Authorization", "Bearer " + "eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJTdHludCBvZmZpY2UiLCJpZCI6IjM1N2VjN2M4LTYxMmEtNGU5MS1iZmI4LWE0NTVlMmM4NTlmYyIsImVtYWlsIjoicWF0ZXN0cWE3NStkYjFAZ21haWwuY29tIiwiaWF0IjoxNzA5NzI0NDU3LCJleHAiOjE3MTAwODQ0NTd9.ktOF4eB0Y5B4KAnR7x9N6ONCSjBWk3GkEapOg1RXcdk")
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
