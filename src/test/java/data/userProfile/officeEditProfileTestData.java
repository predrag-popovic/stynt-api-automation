package data.userProfile;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

public class officeEditProfileTestData {

    /********************************************************************************************
     TEST DATA THAT WE USE FOR OFFICE USERS
     ********************************************************************************************/
    public static final String OFFICE_BEARER_TOKEN = "eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJTdHludCBvZmZpY2UiLCJpZCI6IjM1N2VjN2M4LTYxMmEtNGU5MS1iZmI4LWE0NTVlMmM4NTlmYyIsImVtYWlsIjoicWF0ZXN0cWE3NStkYjFAZ21haWwuY29tIiwiaWF0IjoxNzEwMjM3NDUyLCJleHAiOjE3MTA1OTc0NTJ9.myUtvt0RvhACAnXTmzrX2mOKAutrVe0_62jcM2uOyX8";

    /********************************************************************************************
     METHOD FOR SENDING PARAMETERS FOR CREDENTIALS
     ********************************************************************************************/
    public static void ParamsForBearerToken(JSONObject requestParamsForOfficeBearerToken) {
        requestParamsForOfficeBearerToken.put("Bearer", OFFICE_BEARER_TOKEN);
    }

    /********************************************************************************************
     METHOD FOR VERIFICATION EXPECTED RESULT THAT WE GET FORM BODY
     ********************************************************************************************/
    public static void verifyThatOfficeUserUpdatedProfileDataSuccessfully(Response officeEditUserProfile) {
        Assert.assertEquals(200, officeEditUserProfile.statusCode());
    }
    public static void verifyThatOfficeUserUpdatedProfileDataUnsuccessfully(Response officeEditUserProfile) {
        Assert.assertEquals(400, officeEditUserProfile.statusCode());
        Assert.assertEquals("Required field is missing", officeEditUserProfile.jsonPath().getString("message"));
    }
    public static String verifyThatOfficeUserCanUpdateProfileWithValidData () {
        String request = "{\n" +
                "  \"load\": {\n" +
                "    \"practiceName\": \"Office DB Test 1\",\n" +
                "    \"speciality\": {\n" +
                "      \"id\": 52\n" +
                "    },\n" +
                "    \"owner\": {\n" +
                "      \"firstName\": \"test 1\",\n" +
                "      \"lastName\": \"test 1\"\n" +
                "    },\n" +
                "    \"contact\": {\n" +
                "      \"firstName\": \"test 1\",\n" +
                "      \"lastName\": \"test 1\",\n" +
                "      \"phone\": \"5555555555\",\n" +
                "      \"afterHoursPhone\": \"5555555555\",\n" +
                "      \"sms\": false\n" +
                "    },\n" +
                "    \"address\": {\n" +
                "      \"addressLine\": \"332 N Lorel Ave\",\n" +
                "      \"city\": \"Chicago\",\n" +
                "      \"state\": \"IL\",\n" +
                "      \"zip\": \"60644\"\n" +
                "    },\n" +
                "    \"access\": {\n" +
                "      \"parkingAvailable\": true,\n" +
                "      \"parkingFree\": true,\n" +
                "      \"publicTransit\": true\n" +
                "    },\n" +
                "    \"skills\": [],\n" +
                "    \"autoRepost\": true,\n" +
                "    \"officeLocationsNumber\": {\n" +
                "      \"id\": 2\n" +
                "    },\n" +
                "    \"dentalChairsNumber\": {\n" +
                "      \"id\": 5\n" +
                "    },\n" +
                "    \"employeesNumber\": {\n" +
                "      \"id\": 2\n" +
                "    },\n" +
                "    \"doctorsNumber\": {\n" +
                "      \"id\": 1\n" +
                "    },\n" +
                "    \"appointmentLength\": {\n" +
                "      \"id\": 1\n" +
                "    },\n" +
                "    \"practiceEstablishedYear\": 2020,\n" +
                "    \"billingContactEmail\": \"qatestqa75+demo1@gmail.com\",\n" +
                "    \"billingFirstName\": \"te\",\n" +
                "    \"billingLastName\": \"te\",\n" +
                "    \"billingContactEnabled\": false\n" +
                "  },\n" +
                "  \"metaData\": null\n" +
                "}";
        return request;
    }
    public static String verifyThatOfficeUserCannotUpdateProfileWithEmptyPracticeName () {
        String request = "{\n" +
                "  \"load\": {\n" +
                "    \"practiceName\": \"\",\n" +
                "    \"speciality\": {\n" +
                "      \"id\": 52\n" +
                "    },\n" +
                "    \"owner\": {\n" +
                "      \"firstName\": \"test 1\",\n" +
                "      \"lastName\": \"test 1\"\n" +
                "    },\n" +
                "    \"contact\": {\n" +
                "      \"firstName\": \"test 1\",\n" +
                "      \"lastName\": \"test 1\",\n" +
                "      \"phone\": \"5555555555\",\n" +
                "      \"afterHoursPhone\": \"5555555555\",\n" +
                "      \"sms\": false\n" +
                "    },\n" +
                "    \"address\": {\n" +
                "      \"addressLine\": \"332 N Lorel Ave\",\n" +
                "      \"city\": \"Chicago\",\n" +
                "      \"state\": \"IL\",\n" +
                "      \"zip\": \"60644\"\n" +
                "    },\n" +
                "    \"access\": {\n" +
                "      \"parkingAvailable\": true,\n" +
                "      \"parkingFree\": true,\n" +
                "      \"publicTransit\": true\n" +
                "    },\n" +
                "    \"skills\": [],\n" +
                "    \"autoRepost\": true,\n" +
                "    \"officeLocationsNumber\": {\n" +
                "      \"id\": 2\n" +
                "    },\n" +
                "    \"dentalChairsNumber\": {\n" +
                "      \"id\": 5\n" +
                "    },\n" +
                "    \"employeesNumber\": {\n" +
                "      \"id\": 2\n" +
                "    },\n" +
                "    \"doctorsNumber\": {\n" +
                "      \"id\": 1\n" +
                "    },\n" +
                "    \"appointmentLength\": {\n" +
                "      \"id\": 1\n" +
                "    },\n" +
                "    \"practiceEstablishedYear\": 2020,\n" +
                "    \"billingContactEmail\": \"qatestqa75+demo1@gmail.com\",\n" +
                "    \"billingFirstName\": \"te\",\n" +
                "    \"billingLastName\": \"te\",\n" +
                "    \"billingContactEnabled\": false\n" +
                "  },\n" +
                "  \"metaData\": null\n" +
                "}";
        return request;
    }

}
