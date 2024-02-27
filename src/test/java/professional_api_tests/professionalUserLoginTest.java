package professional_api_tests;
import data.login.professionalTestData;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.*;

@Epic("Automate API for Professional user login")
public class professionalUserLoginTest extends professionalTestData {

    private static final String professionalLoginEndPoint = PROFESSIONAL_LOGIN_END_POINT_URL;

    @Test
    @Feature("01. TC Verify That The Verify Professional user can successfully login")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatTheVerifyProfessionalCanSuccessfullyLogin() {

        JSONObject requestParamsForVerifiedProfessionalSubmitValidCredentials = new JSONObject();
        ParamsForValidCredentials(requestParamsForVerifiedProfessionalSubmitValidCredentials);

        Response verifiedProfessionalLogin = getResponseProfessionalLogin(requestParamsForVerifiedProfessionalSubmitValidCredentials);

        verifyThatProfessionalLoginSuccessfully(verifiedProfessionalLogin);
    }

    @Test
    @Feature("02.TC Verify that verified user can't login with empty email and password")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatVerifiedUserCanNotLogInWithEmptyEmailAndPassword() {

        JSONObject requestParamsForVerifiedProfessionalSubmitEmptyCredentials = new JSONObject();
        ParamsForEmptyCredentials(requestParamsForVerifiedProfessionalSubmitEmptyCredentials);

        Response verifiedProfessionalLogin = getResponseProfessionalLogin(requestParamsForVerifiedProfessionalSubmitEmptyCredentials);

        verifyThatVerifiedProfessionalCanNotLoginWithEmptyEmailAndPassword(verifiedProfessionalLogin);
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
