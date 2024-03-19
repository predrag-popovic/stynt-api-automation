package office_api_tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;

import data.login.officeLoginTestData;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import utility.PropertyManager;

@Epic("Automate API for Office user login")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class officeLoginTest extends officeLoginTestData {

    private static PropertyManager properties = PropertyManager.getInstance();

    private static final String officeLoginEndPoint = properties.getEndPointLoginOffice();

    @Test
    @Order(1)
    @Feature("01. TC Verify that the verified Office user can successfully login")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatTheVerifyOfficeCanSuccessfullyLogin() {

        JSONObject requestParamsForOfficeSubmitValidCredentials = new JSONObject();
        ParamsForValidCredentials(requestParamsForOfficeSubmitValidCredentials);

        Response officeLogin = getResponseOfficeLogin(requestParamsForOfficeSubmitValidCredentials);

        verifyThaOfficeLoginSuccessfully(officeLogin);
    }
    @Test
    @Order(2)
    @Feature("02. TC Verify that verified user can't login with empty email and password")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatTheVerifiedOfficeCanNotLoginWithEmptyData() {

        JSONObject requestParamsForOfficeSubmitEmptyCredentials = new JSONObject();
        ParamsForEmptyCredentials(requestParamsForOfficeSubmitEmptyCredentials);

        Response officeLogin = getResponseOfficeLogin(requestParamsForOfficeSubmitEmptyCredentials);

        verifyThatOfficeLoginUnsuccessfully(officeLogin);
    }
    @Test
    @Order(3)
    @Feature("03. TC Verify that verified user can't login with valid email and empty password")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatTheVerifiedOfficeCanNotLoginWithValidEmailAndEmptyPassword() {

        JSONObject requestParamsForOfficeSubmitValidEmailAndEmptyPassword = new JSONObject();
        ParamsForValidEmailAndEmptyPassword(requestParamsForOfficeSubmitValidEmailAndEmptyPassword);

        Response officeLogin = getResponseOfficeLogin(requestParamsForOfficeSubmitValidEmailAndEmptyPassword);

        verifyThatOfficeLoginUnsuccessfully(officeLogin);
    }
    @Test
    @Order(4)
    @Feature("04. TC Verify that verified user can't login with empty email and valid password")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatTheVerifiedOfficeCanNotLoginWithEmptyEmailAndValidPassword() {

        JSONObject requestParamsForOfficeSubmitEmptyEmailAndValidPassword = new JSONObject();
        ParamsForEmptyEmailAndValidPassword(requestParamsForOfficeSubmitEmptyEmailAndValidPassword);

        Response officeLogin = getResponseOfficeLogin(requestParamsForOfficeSubmitEmptyEmailAndValidPassword);

        verifyThatOfficeLoginUnsuccessfully(officeLogin);
    }
    @Test
    @Order(5)
    @Feature("05. TC Verify that verified user can't login with invalid email and password")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatTheVerifiedOfficeCanNotLoginWithInvalidData() {

        JSONObject requestParamsForOfficeSubmitInvalidCredentials = new JSONObject();
        ParamsForInvalidCredentials(requestParamsForOfficeSubmitInvalidCredentials);

        Response officeLogin = getResponseOfficeLogin(requestParamsForOfficeSubmitInvalidCredentials);

        verifyThatOfficeLoginUnsuccessfully(officeLogin);
    }
    @Test
    @Order(6)
    @Feature("06. TC Verify that verified user can't login with invalid email and valid password")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatTheVerifiedOfficeCanNotLoginWithInvalidEmailAndValidPassword() {

        JSONObject requestParamsForOfficeSubmitInvalidEmailAndValidPassword = new JSONObject();
        ParamsForInvalidEmailAndValidPassword(requestParamsForOfficeSubmitInvalidEmailAndValidPassword);

        Response officeLogin = getResponseOfficeLogin(requestParamsForOfficeSubmitInvalidEmailAndValidPassword);

        verifyThatOfficeLoginUnsuccessfully(officeLogin);
    }
    @Test
    @Order(7)
    @Feature("07. TC Verify that verified user can't login with valid email and invalid password")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatTheVerifiedOfficeCanNotLoginWithValidEmailAndInvalidPassword() {

        JSONObject requestParamsForOfficeSubmitValidEmailAndInvalidPassword = new JSONObject();
        ParamsForValidEmailAndInvalidPassword(requestParamsForOfficeSubmitValidEmailAndInvalidPassword);

        Response officeLogin = getResponseOfficeLogin(requestParamsForOfficeSubmitValidEmailAndInvalidPassword);

        verifyThatOfficeLoginUnsuccessfully(officeLogin);
    }
    @Test
    @Order(8)
    @Feature("08. TC Verify that unverified user can login with valid email and password")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatTheUnverifiedOfficeCanSuccessfullyLogin() {

        JSONObject requestParamsForOfficeSubmitValidCredentialsForUnverifiedUser = new JSONObject();
        ParamsForUnverifiedUserValidCredentials(requestParamsForOfficeSubmitValidCredentialsForUnverifiedUser);

        Response officeLogin = getResponseOfficeLogin(requestParamsForOfficeSubmitValidCredentialsForUnverifiedUser);

        verifyThaOfficeLoginSuccessfully(officeLogin);
    }
    @Test
    @Order(9)
    @Feature("09. TC Verify that the disabled user can login with a valid email and password")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatTheDisabledOfficeCanSuccessfullyLogin() {

        JSONObject requestParamsForOfficeSubmitValidCredentialsForDisabledUser = new JSONObject();
        ParamsForDisabledUserValidCredentials(requestParamsForOfficeSubmitValidCredentialsForDisabledUser);

        Response officeLogin = getResponseOfficeLogin(requestParamsForOfficeSubmitValidCredentialsForDisabledUser);

        verifyThatOfficeLoginUnsuccessfully(officeLogin);
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

}
