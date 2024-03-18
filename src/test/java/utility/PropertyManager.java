package utility;

import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager cInstance = null;

    // *** OFFICE ***
    private String PREPROD_OFFICE;
    private String OFFICE_LOGIN_END_POINT;
    private String OFFICE_USER_PROFILE;
    private String OFFICE_EDIT_USER_PROFILE;

    // *** PROFESSIONAL ***
    private String PREPROD_PROFESSIONAL;
    private String PROFESSIONAL_LOGIN_END_POINT;
    private String PROFESSIONAL_USER_PROFILE;

    private PropertyManager() {
        loadData();
    }

    public static PropertyManager getInstance() {
        if (cInstance == null) {
            cInstance = new PropertyManager();
        }

        return cInstance;
    }

    private void loadData() {

        /**
         * Declare a properties object
         */
        Properties prop = new Properties();

        try {
            prop.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }

        // *** Get properties from configuration.properties ***

        /**
         * Get URL of application environment and set the end point
         */

        // *** OFFICE ***
        PREPROD_OFFICE = prop.getProperty("PREPROD_OFFICE");
        OFFICE_LOGIN_END_POINT = PREPROD_OFFICE + prop.getProperty("OFFICE_LOGIN_END_POINT");
        OFFICE_USER_PROFILE = PREPROD_OFFICE + prop.getProperty("OFFICE_USER_PROFILE_END_POINT");
        OFFICE_EDIT_USER_PROFILE = PREPROD_OFFICE + prop.getProperty("OFFICE_EDIT_USER_PROFILE_END_POINT");

        // *** PROFESSIONAL ***
        PREPROD_PROFESSIONAL = prop.getProperty("PREPROD_PROFESSIONAL");
        PROFESSIONAL_LOGIN_END_POINT = PREPROD_PROFESSIONAL + prop.getProperty("PROFESSIONAL_LOGIN_END_POINT");
        PROFESSIONAL_USER_PROFILE = PREPROD_PROFESSIONAL + prop.getProperty("PROFESSIONAL_USER_PROFILE_END_POINT");
    }

    public String getEndPointLoginProfessional() { return PROFESSIONAL_LOGIN_END_POINT;}
    public String getEndPointLoginOffice() {
        return OFFICE_LOGIN_END_POINT;
    }
    public String getEndPointUserProfileOffice() {
        return OFFICE_USER_PROFILE;
    }
    public String getEndPointEditUserProfileOffice() {
        return OFFICE_EDIT_USER_PROFILE;
    }
    public String getEndPointUserProfileProfessional() { return PROFESSIONAL_USER_PROFILE; }
}
