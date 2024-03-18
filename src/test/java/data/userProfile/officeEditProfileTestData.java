package data.userProfile;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

public class officeEditProfileTestData {

    /********************************************************************************************
     TEST DATA THAT WE USE FOR OFFICE USERS
     ********************************************************************************************/
    public static final String OFFICE_PRACTICE_NAME = "Office DB Test 1";
    public static final String OFFICE_EMPTY_PRACTICE_NAME = "";
    public static final Integer OFFICE_SPECIALITY_ID = 52;
    public static final String OFFICE_OWNER_FIRST_NAME = "test";
    public static final String OFFICE_OWNER_LAST_NAME = "test";
    public static final String OFFICE_CONTACT_FIRST_NAME = "test";
    public static final String OFFICE_CONTACT_LAST_NAME = "test";
    public static final String OFFICE_CONTACT_PHONE = "5555555555";
    public static final String OFFICE_CONTACT_AFTER_HOURS_PHONE = "5555555555";
    public static final Boolean OFFICE_CONTACT_SMS = false;
    public static final String OFFICE_ADDRESS_LINE = "332 N Lorel Ave";
    public static final String OFFICE_ADDRESS_CITY = "CHICAGO";
    public static final String OFFICE_ADDRESS_STATE = "IL";
    public static final String OFFICE_ADDRESS_ZIP = "60644";
    public static final Boolean OFFICE_ACCESS_PARKING_AVAILABLE = true;
    public static final Boolean OFFICE_ACCESS_PARKING_FREE = true;
    public static final Boolean OFFICE_ACCESS_PUBLIC_TRANSIT = true;
    public static final Integer OFFICE_SKILLS_ID = 158;
    public static final String OFFICE_SKILLS_NAME = "Athena Health";
    public static final Boolean OFFICE_AUTO_REPOST = true;
    public static final Integer OFFICE_LOCATION_NUMBER_ID = 2;
    public static final Integer OFFICE_DENTAL_CHAIRS_NUMBER_ID = 5;
    public static final Integer OFFICE_EMPLOYEES_NUMBER_ID = 2;
    public static final Integer OFFICE_DOCTORS_NUMBER_ID = 1;
    public static final Integer OFFICE_APPOINTMENT_LENGTH_ID = 1;
    public static final Integer OFFICE_PRACTICE_ESTABLISHED_YEAR = 2020;
    public static final String OFFICE_BILLING_CONTACT_EMAIL = "qatestqa75+demo1@gmail.com";
    public static final String OFFICE_BILLING_FIRST_NAME = "test";
    public static final String OFFICE_BILLING_LAST_NAME = "test";
    public static final Boolean OFFICE_BILLING_CONTACT_ENABLED = false;
    public static final String OFFICE_META_DATA = null;
    public static final String OFFICE_VERIFIED_EMAIL = "qatestqa75+db1@gmail.com";
    public static final String OFFICE_VERIFIED_PASSWORD = "Gecko123";

    /********************************************************************************************
     METHOD FOR SENDING PARAMETERS FOR USER PROFILE DATA
     ********************************************************************************************/
    public static JSONObject ParamsForEditProfileWithValidData() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("metaData", OFFICE_META_DATA);

        JSONObject load = new JSONObject();

        load.put("practiceName", OFFICE_PRACTICE_NAME);
        load.put("autoRepost", OFFICE_AUTO_REPOST);
        load.put("practiceEstablishedYear", OFFICE_PRACTICE_ESTABLISHED_YEAR);
        load.put("billingContactEmail", OFFICE_BILLING_CONTACT_EMAIL);
        load.put("billingFirstName", OFFICE_BILLING_FIRST_NAME);
        load.put("billingLastName", OFFICE_BILLING_LAST_NAME);
        load.put("billingContactEnabled", OFFICE_BILLING_CONTACT_ENABLED);

        JSONObject loadSpeciality = new JSONObject();
        loadSpeciality.put("id", OFFICE_SPECIALITY_ID);
        load.put("speciality", loadSpeciality);

        JSONObject loadOwner = new JSONObject();
        loadOwner.put("firstName", OFFICE_OWNER_FIRST_NAME);
        loadOwner.put("lastName", OFFICE_OWNER_LAST_NAME);
        load.put("owner", loadOwner);

        JSONObject loadContact = new JSONObject();
        loadContact.put("firstName", OFFICE_CONTACT_FIRST_NAME);
        loadContact.put("lastName", OFFICE_CONTACT_LAST_NAME);
        loadContact.put("phone", OFFICE_CONTACT_PHONE);
        loadContact.put("afterHoursPhone", OFFICE_CONTACT_AFTER_HOURS_PHONE);
        loadContact.put("sms", OFFICE_CONTACT_SMS);
        load.put("contact", loadContact);

        JSONObject loadAddress = new JSONObject();
        loadAddress.put("addressLine", OFFICE_ADDRESS_LINE);
        loadAddress.put("city", OFFICE_ADDRESS_CITY);
        loadAddress.put("state", OFFICE_ADDRESS_STATE);
        loadAddress.put("zip", OFFICE_ADDRESS_ZIP);
        load.put("address", loadAddress);

        JSONObject loadAccess = new JSONObject();
        loadAccess.put("parkingAvailable", OFFICE_ACCESS_PARKING_AVAILABLE);
        loadAccess.put("parkingFree", OFFICE_ACCESS_PARKING_FREE);
        loadAccess.put("publicTransit", OFFICE_ACCESS_PUBLIC_TRANSIT);
        load.put("access",loadAccess);

        JSONObject skill = new JSONObject();
        skill.put("id", OFFICE_SKILLS_ID);
        skill.put("name", OFFICE_SKILLS_NAME);
        JSONArray loadSkills = new JSONArray();
        loadSkills.put(skill);
        load.put("skills", loadSkills);

        JSONObject loadOfficeLocationsNumber = new JSONObject();
        loadOfficeLocationsNumber.put("id", OFFICE_LOCATION_NUMBER_ID);
        load.put("officeLocationsNumber", loadOfficeLocationsNumber);

        JSONObject loadDentalChairsNumber = new JSONObject();
        loadDentalChairsNumber.put("id", OFFICE_DENTAL_CHAIRS_NUMBER_ID);
        load.put("dentalChairsNumber", loadDentalChairsNumber);

        JSONObject loadEmployeesNumber = new JSONObject();
        loadEmployeesNumber.put("id", OFFICE_EMPLOYEES_NUMBER_ID);
        load.put("employeesNumber", loadEmployeesNumber);

        JSONObject loadDoctorsNumber = new JSONObject();
        loadDoctorsNumber.put("id", OFFICE_DOCTORS_NUMBER_ID);
        load.put("doctorsNumber", loadDoctorsNumber);

        JSONObject loadAppointmentLength = new JSONObject();
        loadAppointmentLength.put("id", OFFICE_APPOINTMENT_LENGTH_ID);
        load.put("appointmentLength", loadAppointmentLength);

        requestBody.put("load", load);
        return requestBody;
    }
    public static JSONObject ParamsForEditProfileWithEmptyPracticeName() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("metaData", OFFICE_META_DATA);

        JSONObject load = new JSONObject();

        load.put("practiceName", OFFICE_EMPTY_PRACTICE_NAME);
        load.put("autoRepost", OFFICE_AUTO_REPOST);
        load.put("practiceEstablishedYear", OFFICE_PRACTICE_ESTABLISHED_YEAR);
        load.put("billingContactEmail", OFFICE_BILLING_CONTACT_EMAIL);
        load.put("billingFirstName", OFFICE_BILLING_FIRST_NAME);
        load.put("billingLastName", OFFICE_BILLING_LAST_NAME);
        load.put("billingContactEnabled", OFFICE_BILLING_CONTACT_ENABLED);

        JSONObject loadSpeciality = new JSONObject();
        loadSpeciality.put("id", OFFICE_SPECIALITY_ID);
        load.put("speciality", loadSpeciality);

        JSONObject loadOwner = new JSONObject();
        loadOwner.put("firstName", OFFICE_OWNER_FIRST_NAME);
        loadOwner.put("lastName", OFFICE_OWNER_LAST_NAME);
        load.put("owner", loadOwner);

        JSONObject loadContact = new JSONObject();
        loadContact.put("firstName", OFFICE_CONTACT_FIRST_NAME);
        loadContact.put("lastName", OFFICE_CONTACT_LAST_NAME);
        loadContact.put("phone", OFFICE_CONTACT_PHONE);
        loadContact.put("afterHoursPhone", OFFICE_CONTACT_AFTER_HOURS_PHONE);
        loadContact.put("sms", OFFICE_CONTACT_SMS);
        load.put("contact", loadContact);

        JSONObject loadAddress = new JSONObject();
        loadAddress.put("addressLine", OFFICE_ADDRESS_LINE);
        loadAddress.put("city", OFFICE_ADDRESS_CITY);
        loadAddress.put("state", OFFICE_ADDRESS_STATE);
        loadAddress.put("zip", OFFICE_ADDRESS_ZIP);
        load.put("address", loadAddress);

        JSONObject loadAccess = new JSONObject();
        loadAccess.put("parkingAvailable", OFFICE_ACCESS_PARKING_AVAILABLE);
        loadAccess.put("parkingFree", OFFICE_ACCESS_PARKING_FREE);
        loadAccess.put("publicTransit", OFFICE_ACCESS_PUBLIC_TRANSIT);
        load.put("access",loadAccess);

        JSONObject skill = new JSONObject();
        skill.put("id", OFFICE_SKILLS_ID);
        skill.put("name", OFFICE_SKILLS_NAME);
        JSONArray loadSkills = new JSONArray();
        loadSkills.put(skill);
        load.put("skills", loadSkills);

        JSONObject loadOfficeLocationsNumber = new JSONObject();
        loadOfficeLocationsNumber.put("id", OFFICE_LOCATION_NUMBER_ID);
        load.put("officeLocationsNumber", loadOfficeLocationsNumber);

        JSONObject loadDentalChairsNumber = new JSONObject();
        loadDentalChairsNumber.put("id", OFFICE_DENTAL_CHAIRS_NUMBER_ID);
        load.put("dentalChairsNumber", loadDentalChairsNumber);

        JSONObject loadEmployeesNumber = new JSONObject();
        loadEmployeesNumber.put("id", OFFICE_EMPLOYEES_NUMBER_ID);
        load.put("employeesNumber", loadEmployeesNumber);

        JSONObject loadDoctorsNumber = new JSONObject();
        loadDoctorsNumber.put("id", OFFICE_DOCTORS_NUMBER_ID);
        load.put("doctorsNumber", loadDoctorsNumber);

        JSONObject loadAppointmentLength = new JSONObject();
        loadAppointmentLength.put("id", OFFICE_APPOINTMENT_LENGTH_ID);
        load.put("appointmentLength", loadAppointmentLength);

        requestBody.put("load", load);
        return requestBody;
    }
    public static void ParamsForValidCredentials(JSONObject requestParamsForOfficeSubmitValidCredentials) {
        requestParamsForOfficeSubmitValidCredentials.put("email", OFFICE_VERIFIED_EMAIL);
        requestParamsForOfficeSubmitValidCredentials.put("password", OFFICE_VERIFIED_PASSWORD);
    }

    /********************************************************************************************
     METHOD FOR VERIFICATION EXPECTED RESULT THAT WE GET FORM BODY
     ********************************************************************************************/
    public static void verifyThatOfficeUserUpdatedProfileDataSuccessfully(Response officeEditUserProfile) {
        Assertions.assertEquals(200, officeEditUserProfile.statusCode());
    }
    public static void verifyThatOfficeUserUpdatedProfileDataUnsuccessfully(Response officeEditUserProfile) {
        Assertions.assertEquals(400, officeEditUserProfile.statusCode());
        Assertions.assertEquals("Required field is missing", officeEditUserProfile.jsonPath().getString("message"));
    }

}
