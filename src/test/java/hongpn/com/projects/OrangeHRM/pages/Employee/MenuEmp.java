package hongpn.com.projects.OrangeHRM.pages.Employee;

import hongpn.com.projects.OrangeHRM.pages.Menu;
import org.openqa.selenium.By;

public class MenuEmp extends Menu {
    private final By personalDetMenu= By.xpath("//a[normalize-space()='Personal Details']");
    private final By contactDetMenu= By.xpath("//a[normalize-space()='Contact Details']");
    private final By emergencyContactMenu= By.xpath("//a[normalize-space()='Emergency Contacts']");
    private final By dependentsMenu= By.xpath("//a[normalize-space()='Dependents']");
    private final By immigrationMenu= By.xpath("//a[normalize-space()='Immigration']");
    private final By salaryMenu= By.xpath("//a[normalize-space()='Salary']");
    private final By taxExemptionMenu= By.xpath("//a[normalize-space()='Tax Exemptions']");
    private final By reportToMenu= By.xpath("//a[normalize-space()='Report-to']");
    private final By qualificationMenu= By.xpath("//a[normalize-space()='Qualifications']");
    private final By memberShipMenu= By.xpath("//a[normalize-space()='Memberships']");

}
