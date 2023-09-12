package hongpn.com.projects.OrangeHRM.testcases;

import hongpn.com.common.BaseTest;
import hongpn.com.helpers.ExcelHelpers;
import hongpn.com.projects.OrangeHRM.pages.AddEmpPage;
import hongpn.com.projects.OrangeHRM.pages.DashboardPage;
import hongpn.com.projects.OrangeHRM.pages.PIMPage;
import hongpn.com.projects.OrangeHRM.pages.SignInPage;
import hongpn.com.utils.LogUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PIMtest extends BaseTest {
    public SignInPage signInPage;
    public DashboardPage dashboardPage;
    private PIMPage pimPage;
    private AddEmpPage addEmpPage;
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
        //pimPage.ClickToJobTitle();
        //pimPage.ClickToElementStatus();
        pimPage.chooseSubUnit("Administration");
        pimPage.chooseIncludeStatus("Current Employees Only");
        pimPage.ClickSearch();
    }
    @Test(priority = 2, description = "Search PIM")
    @Step("Click Admin filters")
    public void AddUser() throws InterruptedException {
        String firstName="Hồng";
        String username="HONGPN3";
        dashboardPage = signInPage.SignIn("Admin", "admin123");
        pimPage= dashboardPage.openPimMenu();
        addEmpPage=pimPage.ClickAdd();
        LogUtils.info("Starting add System Users");
        addEmpPage.InsertFullName(firstName,"Nhật","Phạm");
        addEmpPage.selectDetailCheck();
        addEmpPage.selectEnable(true);
        addEmpPage.InsertLoginDetails(username,"Hong@@123789");
        pimPage=addEmpPage.ClickSave();
        Thread.sleep(3000);
        //check whether data is correct
        pimPage.setBasicEmpInfo(firstName,"","");
        pimPage.ClickSearch();
        Assert.assertTrue(pimPage.checkDataOnGrid(),"Create new employee fail because we can not find the corresponding result");
        Thread.sleep(3000);
    }
}
