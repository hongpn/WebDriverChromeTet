package hongpn.com.projects.OrangeHRM.testcases;

import hongpn.com.common.BaseTest;
import hongpn.com.projects.OrangeHRM.pages.DashboardPage;
import hongpn.com.projects.OrangeHRM.pages.SignInPage;
import hongpn.com.utils.LogUtils;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    public SignInPage signInPage;
    public DashboardPage dashboardPage;
    @Test(priority = 0)
    public void SignInHRMPage() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opensource-demo.orangehrmlive.com/");

        LogUtils.info("Starting SignInHRMPage");
        signInPage = new SignInPage();
        dashboardPage = signInPage.SignIn("Admin", "admin123");
        //webUI.waitForPageLoaded();
    }

}
