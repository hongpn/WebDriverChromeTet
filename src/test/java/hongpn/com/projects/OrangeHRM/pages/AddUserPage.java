package hongpn.com.projects.OrangeHRM.pages;

import hongpn.com.driver.DriverManager;
import hongpn.com.helpers.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class AddUserPage extends Menu {
    private final By userNameInput = By.xpath("//label[normalize-space()='Username']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input");
    private final By userRoleDrop = By.xpath("//label[normalize-space()='User Role']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//div[@class='oxd-select-wrapper']");
    private final By employeeNameInput = By.xpath("//label[normalize-space()='Employee Name']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input");
    private final By statusDrop = By.xpath("//label[normalize-space()='Status']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//div[@class='oxd-select-text oxd-select-text--active']");
    private final By passwordInput = By.xpath("//label[normalize-space()='Password']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@type='password']");
    private final By conPasswordInput = By.xpath("//label[normalize-space()='Confirm Password']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@type='password']");
    private final By saveBtn = By.xpath("//button[normalize-space()='Save']");
    private final By cancelBtn = By.xpath("//button[normalize-space()='Cancel']");
    private final By optionEle = By.xpath("//div[@role='option']");
    private final By optionEmpName= By.xpath("//label[normalize-space()='Employee Name']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//div[@role='option']");
    private Actions actions;

    public void setUserName(String value) {
        WebUI.setText(userNameInput, value);
    }

    public void setEmployeeNameInput(String value) throws InterruptedException {
        WebUI.setText(employeeNameInput, value);
        WebUI.waitForElementClickable(optionEmpName,5);
        Thread.sleep(3000);
        WebDriver driver = DriverManager.getDriver();
        Dictionary<String, By> empDict = new Hashtable<>();
        getValueList(empDict);
        actions = new Actions(driver);
        By selectedOption = empDict.get(value);
        Assert.assertNotNull(selectedOption,"can not find the employee with name "+value);
        if (WebUI.checkElementExist(selectedOption)) {
            WebElement chosenElement = driver.findElement(selectedOption);
            actions.moveToElement(chosenElement).pause(Duration.ofSeconds(1)).click(chosenElement).build().perform();
        } else
            System.out.println("Can not find out " + value);


    }
    public void setPasswordInput(String value) {
        WebUI.setText(passwordInput, value);
        WebUI.setText(conPasswordInput, value);
    }
    public void getValueList(Dictionary<String, By> Dict) {
        WebDriver driver = DriverManager.getDriver();
        String strXPath;
        if (WebUI.checkElementExist(optionEle)) {
            List<WebElement> optionEleList = driver.findElements(optionEle);
            for (WebElement webElement : optionEleList) {
                strXPath = "//div[@role='listbox']//div[@role='option' and normalize-space()='" + webElement.getText() + "']";
                Dict.put(webElement.getText(), By.xpath(strXPath));
            }
        }
    }
    public void chooseUserRole(String userRole) throws InterruptedException {
        Dictionary<String, By> roleDict = new Hashtable<>();
        WebDriver driver = DriverManager.getDriver();
        WebUI.waitForPageLoaded();
        WebUI.clickElement(userRoleDrop);
        Thread.sleep(2000);
        getValueList(roleDict);
        actions = new Actions(driver);
        By selectedOption = roleDict.get(userRole);
        if (WebUI.checkElementExist(selectedOption)) {
            WebElement chosenElement = driver.findElement(selectedOption);
            actions.moveToElement(chosenElement).pause(Duration.ofSeconds(1)).click(chosenElement).build().perform();
        } else
            System.out.println("Can not find out " + userRole);
    }
    public void chooseStatus(String status) throws InterruptedException {
        Dictionary<String, By> statusDict = new Hashtable<>();
        WebDriver driver = DriverManager.getDriver();
        WebUI.waitForPageLoaded();
        WebUI.clickElement(statusDrop);
        Thread.sleep(2000);
        getValueList(statusDict);
        actions = new Actions(driver);
        By selectedOption = statusDict.get(status);
        if (WebUI.checkElementExist(selectedOption)) {
            WebElement chosenElement = driver.findElement(selectedOption);
            actions.moveToElement(chosenElement).pause(Duration.ofSeconds(1)).click(chosenElement).build().perform();
        } else
            System.out.println("Can not find out " + status);
    }
    public AdminPage clickSave()
    {
        WebUI.clickElement(saveBtn);
        WebUI.waitForPageLoaded();
        return new AdminPage();
    }
}

