package hongpn.com.projects.OrangeHRM.testcases;

import hongpn.com.common.BaseTest;
import hongpn.com.helpers.ExcelHelpers;
import hongpn.com.projects.OrangeHRM.pages.DashboardPage;
import hongpn.com.projects.OrangeHRM.pages.PIMPage;
import hongpn.com.projects.OrangeHRM.pages.SignInPage;
import hongpn.com.utils.LogUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PIMtest extends BaseTest {
    public SignInPage signInPage;
    public DashboardPage dashboardPage;
    private PIMPage pimPage;
    private ExcelHelpers excelHelpers;
    //private WebUI webUI;
    @BeforeMethod
    @Description("Init browser and corresppding classes")
    @Step("Init parameters and browser")
    public void SetUpTest(){
        //LogUtils.info("Starting SignInHRMPage");
        signInPage = new SignInPage();
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("datatest/Login.xlsx", "Sheet1");
    }

    @Test(priority = 1, description = "Search PIM")
    @Step("Click Pim filters")
    public void SearchEmployee() throws InterruptedException {
        dashboardPage = signInPage.SignIn("Admin", "admin123");
        LogUtils.info("Starting SearchEmployee");
        pimPage= dashboardPage.openPimMenu();
        pimPage.ClickToJobTitle();
        pimPage.ClickToElementStatus();
        pimPage.ClickToSubUnit();
        pimPage.ClickToInclude();
        pimPage.ClickSearch();
    }
}
