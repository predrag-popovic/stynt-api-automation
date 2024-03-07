package utility;

import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager cInstance = null;

    private String PROFESSIONAL_ENVIRONMENT_LOGIN;
    private String OFFICE_ENVIRONMENT_LOGIN;

    private String OFFICE_USER_PROFILE;

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
         * Get URL of application environment and set browser type
         */
        PROFESSIONAL_ENVIRONMENT_LOGIN = prop.getProperty("PROFESSIONAL_LOGIN_END_POINT_URL");
        OFFICE_ENVIRONMENT_LOGIN = prop.getProperty("OFFICE_LOGIN_END_POINT_URL");
        OFFICE_USER_PROFILE = prop.getProperty("OFFICE_USER_PROFILE_END_POINT_URL");
        PROFESSIONAL_USER_PROFILE = prop.getProperty("PROFESSIONAL_USER_PROFILE_END_POINT_URL");
    }

    public String getEndPointLoginProfessional() {
        return PROFESSIONAL_ENVIRONMENT_LOGIN;
    }
    public String getEndPointLoginOffice() {
        return OFFICE_ENVIRONMENT_LOGIN;
    }
    public String getEndPointUserProfileOffice() {
        return OFFICE_USER_PROFILE;
    }
    public String getEndPointUserProfileProfessional() { return PROFESSIONAL_USER_PROFILE; }

}
