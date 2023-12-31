package hongpn.com.common;

import hongpn.com.constants.ConstantGlobal;
import hongpn.com.driver.DriverManager;
import hongpn.com.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class BaseTest {
    @BeforeMethod
    @Parameters({"BROWSER"})
    public static void createDriver(@Optional("chrome") String browserName) {
        //System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver = setupBrowser(browserName);
        DriverManager.setDriver(driver);
        //PropertiesHelpers.loadAllFiles();
    }

    //Viết hàm trung gian để lựa chọn Browser cần chạy với giá trị tham số "browser" bên trên truyền vào
    public static WebDriver setupBrowser(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    // Viết các hàm khởi chạy cho từng Browser đó
    private static WebDriver initChromeDriver() {
        WebDriver driver;
        System.out.println("Launching Chrome browser...");
       // WebDriverManager.chromedriver().setup();

        /*ChromeOptions options = new ChromeOptions();
        if(ConstantGlobal.HEADLESS){
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        }*/

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        WebDriver driver;
        System.out.println("Launching Edge browser...");
        //WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
        if(ConstantGlobal.HEADLESS){
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        }

        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        WebDriver driver;
        System.out.println("Launching Firefox browser...");
       // WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(ConstantGlobal.HEADLESS);

        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public static void closeDriver(ITestResult result) {
        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }
}
