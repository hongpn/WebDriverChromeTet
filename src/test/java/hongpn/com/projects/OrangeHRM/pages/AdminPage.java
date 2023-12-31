package hongpn.com.projects.OrangeHRM.pages;

import hongpn.com.driver.DriverManager;
import hongpn.com.helpers.WebUI;
import hongpn.com.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;


public class AdminPage extends Menu {
    // Internal Element
    // System search
    private final By userNameInput = By.xpath("//label[normalize-space()='Username']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input");
    private final By userRoleDrop = By.xpath("//label[normalize-space()='User Role']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//div[@class='oxd-select-wrapper']");
    private final By employeeNameInput = By.xpath("//label[normalize-space()='Employee Name']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input");
    private final By statusDrop = By.xpath("//label[normalize-space()='Status']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//div[@class='oxd-select-text oxd-select-text--active']");
    private final By resetBtn = By.xpath("//button[normalize-space()='Reset']");
    private final By searchBtn = By.xpath("//button[normalize-space()='Search']");
    private final By addBtn = By.xpath("//button[normalize-space()='Add']");
    private final By recordsFoundLabel= By.xpath("//span[contains(normalize-space(),'Records Found')]");
    private final By optionEle = By.xpath("//div[@role='option']");
    private final By trEles=By.xpath("//div[@class='orangehrm-container']//div[@class='oxd-table-body']//div[@class='oxd-table-card']");
    Actions actions;
    //
    public void setUserName(String value)
    {
        WebUI.setText(userNameInput,value);
    }
    public void setEmployeeNameInput(String value)
    {
        WebUI.setText(employeeNameInput,value);
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
    public void clickSearch() throws InterruptedException {
        WebUI.clickElement(searchBtn);
        Thread.sleep(3000);
    }
    public void clickReset() throws InterruptedException {
        WebUI.clickElement(resetBtn);
        Thread.sleep(3000);
    }
    public AddUserPage clickAdd()
    {
        WebUI.clickElement(addBtn);
        WebUI.waitForPageLoaded();
        return new AddUserPage();
    }
    public Boolean checkDataOnGrid(String value)
    {
        return true;
    }
    public Boolean checkDataOnGrid()
    {
        WebDriver driver = DriverManager.getDriver();
        // quick check on key word: Records Found
        WebUI.waitForElementVisible(recordsFoundLabel);
        String result=driver.findElement(recordsFoundLabel).getText();
        return result != "No Records Found";
    }
    //Handle Data Table
    public void checkContainsSearchTableByColumn(int column, String value) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebUI.waitForElementVisible(trEles);
        List < WebElement > totalRows = driver.findElements(trEles);
        LogUtils.info("There are "+totalRows.size()+(" + value + ")+" in the search User Grid ");
        System.out.println("Số kết quả cho từ khóa (" + value + "): " + totalRows.size());
        for (int i = 1; i <= totalRows.size(); i++) {
            boolean res = false;
            WebElement title = driver.findElement(By.xpath("[" + i + "]//div[@class='oxd-table-cell oxd-padding-cell'][" + column + "]"));
            js.executeScript("arguments[0].scrollIntoView(true);", title);
            res = title.getText().toUpperCase().contains(value.toUpperCase());
            System.out.println("line  " + i + ": " + res + " - " + title.getText());
            Assert.assertTrue(res, "Line " + i + " (" + title.getText() + ")" + " doesn't include " + value);
        }
    }

}
