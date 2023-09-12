package hongpn.com.projects.OrangeHRM.pages;

import hongpn.com.driver.DriverManager;
import hongpn.com.helpers.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEmpPage extends Menu{
    private final By firstNameInput=By.xpath("//input[@placeholder='First Name']");
    private final By midNameInput=By.xpath("//input[@placeholder='Middle Name']");
    private final By lastNameInput=By.xpath("//input[@placeholder='Last Name']");
    private final By empIdInput=By.xpath("//label[normalize-space()='Employee Id']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input");
    private final By createDetailCheck= By.xpath("//p[normalize-space()='Create Login Details']/ancestor::div[@class='oxd-form-row user-form-header']//div[@class='oxd-switch-wrapper']");
    private final By createDetailInputCheck= By.xpath("//p[normalize-space()='Create Login Details']/ancestor::div[@class='oxd-form-row user-form-header']//div[@class='oxd-switch-wrapper']//input");
    private final By usernameInput=By.xpath("//label[normalize-space()='Username']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input");
    private final By pwdInput=By.xpath("//label[normalize-space()='Password']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input");
    private final By confirmPwdInput=By.xpath("//label[normalize-space()='Confirm Password']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input");
    private final By enableCheck=By.xpath("//label[normalize-space()='Enabled']//following::span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input']");
    private final By enableStatus=By.xpath("//label[normalize-space()='Enabled']//ancestor::div[@class='oxd-radio-wrapper']//input");
    private final By disableCheck=By.xpath("//label[normalize-space()='Disabled']//following::span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input']");
    private final By disableStatus=By.xpath("//label[normalize-space()='Disabled']//ancestor::div[@class='oxd-radio-wrapper']//input");
    private final By cancelBtn=By.xpath("//button[normalize-space()='Cancel']");
    private final By saveBtn=By.xpath("//button[normalize-space()='Save']");
    public void selectDetailCheck()
    {
        WebDriver driver = DriverManager.getDriver();
        WebElement checkBoxElement=driver.findElement(createDetailCheck);
        WebElement checkBoxInputElement=driver.findElement(createDetailInputCheck);
        if(!checkBoxInputElement.isSelected())
            checkBoxElement.click();
    }
    public void InsertFullName(String firstName,String midName,String LastName)
    {
        WebUI.setText(firstNameInput,firstName);
        WebUI.setText(midNameInput,midName);
        WebUI.setText(lastNameInput,LastName);
    }
    public void InsertLoginDetails(String username,String pwd)
    {
        WebUI.setText(usernameInput,username);
        WebUI.setText(pwdInput,pwd);
        WebUI.setText(confirmPwdInput,pwd);
    }
    public void selectEnable(Boolean status)
    {
        if(status)
            WebUI.clickElement(enableCheck,2);
        else
            WebUI.clickElement(disableCheck,2);
    }
    public PIMPage ClickSave() throws InterruptedException {
        WebUI.clickElement(saveBtn);
        WebUI.waitForPageLoaded();
        return openPimMenu();
    }
    public void ClickCancel() throws InterruptedException {
        WebUI.clickElement(cancelBtn);
        Thread.sleep(3000);
    }
}
