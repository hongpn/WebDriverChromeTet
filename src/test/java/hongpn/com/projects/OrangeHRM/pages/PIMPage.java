package hongpn.com.projects.OrangeHRM.pages;

import hongpn.com.driver.DriverManager;
import hongpn.com.helpers.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class PIMPage extends Menu{
    // Internal Element
    private final By empNameInput=By.xpath("//label[normalize-space()='Employee Name']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input");
    private  final By empIDInput=By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    private  final By spNameInput=By.xpath("//label[normalize-space()='Supervisor Name']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input");
    private final By jobTitleDrop=By.xpath("//label[normalize-space()='Job Title']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//div[@class='oxd-select-text-input']");
    private final By empStatusDrop=By.xpath("//label[normalize-space()='Employment Status']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//div[@class='oxd-select-text-input']");
    private final By subUnitDrop=By.xpath("//label[normalize-space()='Sub Unit']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//div[@class='oxd-select-text-input']");
    private final By includeDrop=By.xpath("//label[normalize-space()='Include']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//div[@class='oxd-select-text-input']");
    private final By contextDrop =By.xpath("//div[@role='listbox']");
    private final By chiefExecutiveValue=By.xpath("//div[@role='listbox']//div[@role='option' and normalize-space()='Chief Executive Officer']");
    private final By fullTimeValue=By.xpath("//div[@role='listbox']//div[@role='option' and normalize-space()='Full-Time Contract']");
    private final By financeValue=By.xpath("//div[@role='listbox']//div[@role='option' and normalize-space()='Finance']");
    private final By currentPastValue=By.xpath("//div[@role='listbox']//div[@role='option' and normalize-space()='Current and Past Employees']");
    private final By searchBtn=By.xpath("//button[normalize-space()='Search']");
    private final By resetBtn=By.xpath("//button[normalize-space()='Reset']");
    private final By addBtn=By.xpath("//button[normalize-space()='Add']");
    private final By recordsFoundLabel= By.xpath("//span[contains(normalize-space(),'Records Found')]");
    //url Dashboard
    private  final String urlPIM="/pim";
    //Header Page
    private final By headerPage=By.xpath("//h6[normalize-space()='Dashboard']");
    private final By optionEle = By.xpath("//div[@role='option']");
    private WebElement lbElement;
    private WebElement chosenElement;
    Actions actions;


    /*public void ClickToJobTitle() throws InterruptedException {
        WebDriver driver=DriverManager.getDriver();
        WebUI.waitForPageLoaded();
        WebUI.clickElement(jobTitleDrop);
        Thread.sleep(2000);
        actions=new Actions(driver);
        //actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        //actions.sendKeys(Keys.ENTER).build().perform();
        if(WebUI.checkElementExist(contextDrop)) {
            lbElement = driver.findElement(contextDrop);
            String innerHTML= lbElement.getAttribute("innerHTML");
            System.out.println(innerHTML);
            if(WebUI.checkElementExist(chiefExecutiveValue))
            {
                chosenElement= driver.findElement(chiefExecutiveValue);
                actions.moveToElement(chosenElement).pause(Duration.ofSeconds(1)).click(chosenElement).build().perform();
            }
            else
                System.out.println("Can not find out Chief Executive");

        }
        else
            System.out.println("Can not get list item in JobTitle");
    }
    public void ClickToElementStatus() throws InterruptedException {
        WebDriver driver=DriverManager.getDriver();
        WebUI.waitForPageLoaded();
        WebUI.clickElement(empStatusDrop);
        Thread.sleep(2000);
        actions=new Actions(driver);
        //actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        //actions.sendKeys(Keys.ENTER).build().perform();
        if(WebUI.checkElementExist(contextDrop)) {
            lbElement = driver.findElement(contextDrop);
            String innerHTML= lbElement.getAttribute("innerHTML");
            System.out.println(innerHTML);
            if(WebUI.checkElementExist(fullTimeValue))
            {
                chosenElement= driver.findElement(fullTimeValue);
                actions.moveToElement(chosenElement).pause(Duration.ofSeconds(1)).click(chosenElement).build().perform();
            }
            else
                System.out.println("Can not find out Full time contract");

        }
        else
            System.out.println("Can not get list item in Employment status");
    }
    public void ClickToSubUnit() throws InterruptedException {
        WebDriver driver=DriverManager.getDriver();
        WebUI.waitForPageLoaded();
        WebUI.clickElement(subUnitDrop);
        Thread.sleep(2000);
        actions=new Actions(driver);
        //actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        //actions.sendKeys(Keys.ENTER).build().perform();
        if(WebUI.checkElementExist(contextDrop)) {
            lbElement = driver.findElement(contextDrop);
            String innerHTML= lbElement.getAttribute("innerHTML");
            System.out.println(innerHTML);
            if(WebUI.checkElementExist(financeValue))
            {
                chosenElement= driver.findElement(financeValue);
                actions.moveToElement(chosenElement).pause(Duration.ofSeconds(1)).click(chosenElement).build().perform();
            }
            else
                System.out.println("Can not find out Finance Value");

        }
        else
            System.out.println("Can not get list item in Sub Unit");
    }*/
     /*public void ClickToInclude() throws InterruptedException {
        WebDriver driver= DriverManager.getDriver();
        WebUI.waitForPageLoaded();
        WebUI.clickElement(includeDrop);
        Thread.sleep(2000);
        actions=new Actions(driver);
        //actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        //actions.sendKeys(Keys.ENTER).build().perform();
        if(WebUI.checkElementExist(contextDrop)) {
            lbElement = driver.findElement(contextDrop);
            String innerHTML= lbElement.getAttribute("innerHTML");
            System.out.println(innerHTML);
            if(WebUI.checkElementExist(currentPastValue))
            {
                chosenElement= driver.findElement(currentPastValue);
                actions.moveToElement(chosenElement).pause(Duration.ofSeconds(1)).click(chosenElement).build().perform();
            }
            else
                System.out.println("Can not find out current and past Value");

        }
        else
            System.out.println("Can not get list item in Include");
    }*/
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
    public void chooseEmpStatus(String emStatus) throws InterruptedException {
        Dictionary<String, By> empDict = new Hashtable<>();
        WebDriver driver = DriverManager.getDriver();
        WebUI.waitForPageLoaded();
        WebUI.clickElement(empStatusDrop);
        Thread.sleep(2000);
        getValueList(empDict);
        actions = new Actions(driver);
        By selectedOption = empDict.get(emStatus);
        if (WebUI.checkElementExist(selectedOption)) {
            WebElement chosenElement = driver.findElement(selectedOption);
            actions.moveToElement(chosenElement).pause(Duration.ofSeconds(1)).click(chosenElement).build().perform();
        } else
            System.out.println("Can not find out " + emStatus);
    }
    public void chooseIncludeStatus(String includeStatus) throws InterruptedException {
        Dictionary<String, By> includeDict = new Hashtable<>();
        WebDriver driver = DriverManager.getDriver();
        WebUI.waitForPageLoaded();
        WebUI.clickElement(includeDrop);
        Thread.sleep(2000);
        getValueList(includeDict);
        actions = new Actions(driver);
        By selectedOption = includeDict.get(includeStatus);
        if (WebUI.checkElementExist(selectedOption)) {
            WebElement chosenElement = driver.findElement(selectedOption);
            actions.moveToElement(chosenElement).pause(Duration.ofSeconds(1)).click(chosenElement).build().perform();
        } else
            System.out.println("Can not find out " + includeStatus);
    }
    public void chooseJobTitle(String jobTitle) throws InterruptedException {
        Dictionary<String, By> titleDict = new Hashtable<>();
        WebDriver driver = DriverManager.getDriver();
        WebUI.waitForPageLoaded();
        WebUI.clickElement(jobTitleDrop);
        Thread.sleep(2000);
        getValueList(titleDict);
        actions = new Actions(driver);
        By selectedOption = titleDict.get(jobTitle);
        if (WebUI.checkElementExist(selectedOption)) {
            WebElement chosenElement = driver.findElement(selectedOption);
            actions.moveToElement(chosenElement).pause(Duration.ofSeconds(1)).click(chosenElement).build().perform();
        } else
            System.out.println("Can not find out " + jobTitle);
    }
    public void chooseSubUnit(String subUnit) throws InterruptedException {
        Dictionary<String, By> subUnitDict = new Hashtable<>();
        WebDriver driver = DriverManager.getDriver();
        WebUI.waitForPageLoaded();
        WebUI.clickElement(subUnitDrop);
        Thread.sleep(2000);
        getValueList(subUnitDict);
        actions = new Actions(driver);
        By selectedOption = subUnitDict.get(subUnit);
        if (WebUI.checkElementExist(selectedOption)) {
            WebElement chosenElement = driver.findElement(selectedOption);
            actions.moveToElement(chosenElement).pause(Duration.ofSeconds(1)).click(chosenElement).build().perform();
        } else
            System.out.println("Can not find out " + subUnit);
    }
    public void setBasicEmpInfo(String empName,String empID,String supervisorName)
    {
        WebUI.setText(empNameInput,empName);
        WebUI.setText(empIDInput,empID);
        WebUI.setText(spNameInput,supervisorName);
    }
    public AddEmpPage ClickAdd()
    {
        WebUI.clickElement(addBtn);
        WebUI.waitForPageLoaded();
        return new AddEmpPage();
    }

    public void ClickSearch() throws InterruptedException {
        WebUI.clickElement(searchBtn);
        Thread.sleep(3000);
    }
    public Boolean checkDataOnGrid()
    {
        WebDriver driver = DriverManager.getDriver();
        // quick check on key word: Records Found
        WebUI.waitForElementVisible(recordsFoundLabel);
        String result=driver.findElement(recordsFoundLabel).getText();
        return result != "No Records Found";
    }
}
