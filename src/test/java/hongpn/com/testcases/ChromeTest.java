package hongpn.com.testcases;

import hongpn.com.helpers.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeTest {
    private By searchField=By.xpath("//textarea[@id='APjFqb']");
    private By searchButton=By.xpath("(//input[@name='btnK'])[2]");
    private WebDriver driver;
    @Test(priority = 0)
    public void SearchOnGG() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com.vn/");
        //WebUI.setText(searchField,"Anh tester");
        //WebUI.clickElement(searchButton);
        Thread.sleep(5000);
        driver.quit();
    }
}
