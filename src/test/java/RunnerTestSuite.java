import office_api_tests.officeUserLogin;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import professional_api_tests.professionalUserLogin;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        officeUserLogin.class,
        professionalUserLogin.class
})
public class RunnerTestSuite {


}
