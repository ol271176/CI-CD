import org.example.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseRunner {
    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/login");
    }

    @Test
    public void test1() {
        LoginPage loginPage = new LoginPage(driver);
        String actual = loginPage
                .enterUsername("username")
                .enterPassword("password")
                .tryInvalidLogin()
                .getError()
                .getText();
        Assert.assertEquals(actual, "Your username is invalid!\n×");
    }
}
