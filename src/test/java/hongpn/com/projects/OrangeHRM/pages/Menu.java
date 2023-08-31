package hongpn.com.projects.OrangeHRM.pages;

import hongpn.com.helpers.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Menu {
    private WebUI helper;

    private By headerPage;
    private String expectedHeader;
    private String url;
    // Element for Dashboard Page
    //menu
    private final By adminMenu = By.xpath("//ul[@class='oxd-main-menu']//span[normalize-space()='Admin']");
    private final By searchMenuInput = By.xpath("//ul[@class='oxd-main-menu']//input[@placeholder='Search']]");
    private final By pimMenu = By.xpath("//ul[@class='oxd-main-menu']//span[normalize-space()='PIM']");
    private final By leaveMenu = By.xpath("//ul[@class='oxd-main-menu']//span[normalize-space()='Leave']");
    private final By recruitmentMenu = By.xpath("//ul[@class='oxd-main-menu']//span[normalize-space()='Recruitment']");
    private final By myInfoMenu = By.xpath("//ul[@class='oxd-main-menu']//span[normalize-space()='My Info']");
    private final By performanceMenu = By.xpath("//ul[@class='oxd-main-menu']//span[normalize-space()='Performance']");
    private final By dashBoardMenu = By.xpath("//ul[@class='oxd-main-menu']//span[normalize-space()='Dashboard']");
    private final By directoryMenu = By.xpath("//ul[@class='oxd-main-menu']//span[normalize-space()='Directory']");
    private final By maintenanceMenu = By.xpath("//ul[@class='oxd-main-menu']//span[normalize-space()='Maintenance']");
    private final By claimMenu = By.xpath("//ul[@class='oxd-main-menu']//span[normalize-space()='Dashboard']");
    private final By BuzzMenu = By.xpath("//ul[@class='oxd-main-menu']//span[normalize-space()='Buzz']");

    private final By FachThat=By.xpath("//p[@class='oxd-userdropdown-name']");
    private final By LogoutMenu=By.xpath("//a[normalize-space()='Logout']");

    public  void setParameters(By headerPagePar, String urlPar,String expectedHeaderPar)
    {
        headerPage=headerPagePar;
        url=urlPar;
        expectedHeader=expectedHeaderPar;
    }
    public AdminPage openAdminMenu() throws InterruptedException {
        WebUI.clickElement(adminMenu);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(headerPage),"Can not open Admin page");
        String strHeader=WebUI.getElementText(headerPage);
        Assert.assertTrue(strHeader.contains(expectedHeader), "Wrong Admin page header, the expected header: " + expectedHeader);
        return new AdminPage();
    }
    public PIMPage openPimMenu() throws InterruptedException {
        WebUI.clickElement(pimMenu);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(headerPage),"Can not open PIM page");
        String strHeader=WebUI.getElementText(headerPage);
        Assert.assertTrue(strHeader.contains(expectedHeader), "Wrong PIM page header, the expected header: " + expectedHeader);
        return new PIMPage();
    }
    public LeavePage openLeaveMenu() throws InterruptedException {
        WebUI.clickElement(leaveMenu);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(headerPage),"Can not open Leave page");
        String strHeader=WebUI.getElementText(headerPage);
        Assert.assertTrue(strHeader.contains(expectedHeader), "Wrong Leave page header, the expected header: " + expectedHeader);
        return new LeavePage();
    }
    public SignInPage Logout() throws InterruptedException {
        WebUI.clickElement(FachThat);
        Thread.sleep(1000);
        WebUI.clickElement(LogoutMenu);
        return new SignInPage();
    }
}
