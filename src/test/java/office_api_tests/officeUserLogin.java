package office_api_tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;

import data.login.officeTestData;

@Epic("Automate API for Office user login")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class officeUserLogin extends officeTestData {

    private static final String officeLoginEndPoint = OFFICE_LOGIN_END_POINT_URL;

    @Test
    @Order(1)
    @Feature("01. TC Verify That The Verify Office user can successfully login")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyThatTheVerifyOfficeCanSuccessfullyLogin() {

        JSONObject requestParamsForOfficeSubmitValidCredentials = new JSONObject();
        ParamsForValidCredentials(requestParamsForOfficeSubmitValidCredentials);

        Response officeLogin = getResponseOfficeLogin(requestParamsForOfficeSubmitValidCredentials);

        verifyThaOfficeLoginSuccessfully(officeLogin);
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
