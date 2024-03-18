package professional_api_tests;

import data.login.professionalTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import utility.PropertyManager;
import static io.restassured.RestAssured.*;

@Epic("Automate API for Professional user login")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class professionalUserLoginTest extends professionalTestData {

    private static PropertyManager properties = PropertyManager.getInstance();
    private static final String professionalLoginEndPoint = properties.getEndPointLoginProfessional();

    @Test
    @Order(1)
    @Feature("01. TC Verify That The Verify Professional user can successfully login")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatTheVerifyProfessionalCanSuccessfullyLogin() {

        JSONObject requestParamsForVerifiedProfessionalSubmitValidCredentials = new JSONObject();
        ParamsForValidCredentials(requestParamsForVerifiedProfessionalSubmitValidCredentials);

        Response verifiedProfessionalLogin = getResponseProfessionalLogin(requestParamsForVerifiedProfessionalSubmitValidCredentials);

        verifyThatProfessionalLoginSuccessfully(verifiedProfessionalLogin);
    }

    @Test
    @Order(2)
    @Feature("02.TC Verify that verified user can't login with empty email and password")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatVerifiedUserCanNotLogInWithEmptyEmailAndPassword() {

        JSONObject requestParamsForVerifiedProfessionalSubmitEmptyCredentials = new JSONObject();
        ParamsForEmptyCredentials(requestParamsForVerifiedProfessionalSubmitEmptyCredentials);

        Response verifiedProfessionalLogin = getResponseProfessionalLogin(requestParamsForVerifiedProfessionalSubmitEmptyCredentials);

        verifyThatVerifiedProfessionalCanNotLoginWithEmptyEmailAndPassword(verifiedProfessionalLogin);
    }

    @Test
    @Order(3)
    @Feature("03.TC Verify that verified user can't log in with valid email and empty password")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatVerifiedUserCanNotLogInWithValidEmailAndEmptyPassword() {

        JSONObject requestParamsForVerifiedProfessionalSubmitValidEmailAndEmptyPassword = new JSONObject();
        ParamsForValidEmailAndEmptyPassword(requestParamsForVerifiedProfessionalSubmitValidEmailAndEmptyPassword);

        Response verifiedProfessionalLogin = getResponseProfessionalLogin(requestParamsForVerifiedProfessionalSubmitValidEmailAndEmptyPassword);

        verifyThatVerifiedProfessionalCanNotLoginWithValidEmailAndEmptyPassword(verifiedProfessionalLogin);
    }

    @Test
    @Order(4)
    @Feature("04.TC Verify that verified user can't log in with empty email and valid password")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatVerifiedUserCanNotLogInWithEmptyEmailAndValidPassword() {

        JSONObject requestParamsForVerifiedProfessionalSubmitEmptyEmailAndValidPassword = new JSONObject();
        ParamsForEmptyEmailAndValidPassword(requestParamsForVerifiedProfessionalSubmitEmptyEmailAndValidPassword);

        Response verifiedProfessionalLogin = getResponseProfessionalLogin(requestParamsForVerifiedProfessionalSubmitEmptyEmailAndValidPassword);

        verifyThatVerifiedProfessionalCanNotLoginWithEmptyEmailAndValidPassword(verifiedProfessionalLogin);
    }

    @Test
    @Order(5)
    @Feature("05.TC Verify that verified user can't log in with valid email and invalid password")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatVerifiedUserCanNotLogInWithValidEmailAndInvalidPassword() {

        JSONObject requestParamsForVerifiedProfessionalSubmitValidEmailAndInvalidPassword = new JSONObject();
        ParamsForValidEmailAndInvalidPassword(requestParamsForVerifiedProfessionalSubmitValidEmailAndInvalidPassword);

        Response verifiedProfessionalLogin = getResponseProfessionalLogin(requestParamsForVerifiedProfessionalSubmitValidEmailAndInvalidPassword);

        verifyThatVerifiedProfessionalCanNotLoginWithValidEmailAndInvalidPassword(verifiedProfessionalLogin);
    }

    @Test
    @Order(6)
    @Feature("06.TC Verify that verified user can't log in with invalid email and valid password")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatVerifiedUserCanNotLogInWithInvalidEmailAndValidPassword() {
        JSONObject requestParamsForVerifiedProfessionalSubmitInvalidEmailAndValidPassword = new JSONObject();
        ParamsForInvalidEmailAndValidPassword(requestParamsForVerifiedProfessionalSubmitInvalidEmailAndValidPassword);

        Response verifiedProfessionalLogin = getResponseProfessionalLogin(requestParamsForVerifiedProfessionalSubmitInvalidEmailAndValidPassword);

        verifyThatVerifiedProfessionalCanNotLoginWithInvalidEmailAndValidPassword(verifiedProfessionalLogin);
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

}
