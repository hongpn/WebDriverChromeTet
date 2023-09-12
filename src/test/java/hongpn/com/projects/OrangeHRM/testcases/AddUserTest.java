package hongpn.com.projects.OrangeHRM.testcases;

import hongpn.com.common.BaseTest;
import hongpn.com.helpers.ExcelHelpers;
import hongpn.com.helpers.WebUI;
import hongpn.com.projects.OrangeHRM.pages.AddUserPage;
import hongpn.com.projects.OrangeHRM.pages.AdminPage;
import hongpn.com.projects.OrangeHRM.pages.DashboardPage;
import hongpn.com.projects.OrangeHRM.pages.SignInPage;
import hongpn.com.utils.LogUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddUserTest extends BaseTest {
    public SignInPage signInPage;
    public DashboardPage dashboardPage;
    public AdminPage adminPage;
    public AddUserPage addUserPage;
    private ExcelHelpers excelHelpers;
    @BeforeMethod
    @Description("Init browser and corresppding classes")
    @Step("Init parameters and browser")
    public void SetUpTest(){
        //LogUtils.info("Starting SignInHRMPage");
        signInPage = new SignInPage();
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("datatest/Login.xlsx", "Sheet1");
    }
    @Test(priority = 1, description = "Add system user")
    @Step("Click Save System User")
    public void AddUserSystem() throws InterruptedException {
        String newUserName="HongPN3";
        String employeeName="Virat Kohli";
        dashboardPage = signInPage.SignIn("Admin", "admin123");
        LogUtils.info("Starting System Users");
        adminPage = dashboardPage.openAdminMenu();
        addUserPage = adminPage.clickAdd();
        addUserPage.setPasswordInput("Hong&&123999");
        addUserPage.setEmployeeNameInput(employeeName);
        addUserPage.chooseStatus("Enabled");
        addUserPage.chooseUserRole("Admin");
        adminPage=addUserPage.clickSave();
        //check whether we've already created it successfully
        adminPage.setUserName(newUserName);
        adminPage.clickSearch();
        Assert.assertTrue(adminPage.checkDataOnGrid(),"Create new user fail because we can not find the corresponding result");
    }


}
