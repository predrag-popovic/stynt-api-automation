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

import data.userProfile.officeEditProfileTestData;
import utility.PropertyManager;

@Epic("Automate API for edit Office user profile")

public class officeEditProfileTest extends officeEditProfileTestData {

    private static PropertyManager properties = PropertyManager.getInstance();
    private static final String officeEditUserProfileEndPoint = properties.getEndPointEditUserProfileOffice();

    @Test
    @Feature("01. TC Verify that user can update the primary profile with valid data")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatUserCanUpdateProfileWithValidData() {

        JSONObject requestParamsForOfficeEditUserProfile = new JSONObject();
        Response officeEditUserProfile = putRequestEditOfficeUserProfileWithValidData(requestParamsForOfficeEditUserProfile);
        verifyThatOfficeUserUpdatedProfileDataSuccessfully(officeEditUserProfile);
    }
    @Test
    @Feature("02. TC Verify that user can't update the primary profile with an empty 'practiceName'")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatUserCannotUpdateProfileWithEmptyPracticeName() {

        JSONObject requestParamsForOfficeEditUserProfile = new JSONObject();
        Response officeEditUserProfile = putRequestEditOfficeUserProfileWithEmptyPracticeName(requestParamsForOfficeEditUserProfile);
        verifyThatOfficeUserUpdatedProfileDataUnsuccessfully(officeEditUserProfile);
    }

    private static Response putRequestEditOfficeUserProfileWithValidData(JSONObject requestParams) {
        Response officeEditUserProfile = given()
                .header("Authorization", "Bearer " + OFFICE_BEARER_TOKEN)
                .body(officeEditProfileTestData.verifyThatOfficeUserCanUpdateProfileWithValidData())
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
    private static Response putRequestEditOfficeUserProfileWithEmptyPracticeName(JSONObject requestParams) {
        Response officeEditUserProfile = given()
                .header("Authorization", "Bearer " + OFFICE_BEARER_TOKEN)
                .body(officeEditProfileTestData.verifyThatOfficeUserCannotUpdateProfileWithEmptyPracticeName())
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

}
