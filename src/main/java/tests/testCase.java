package tests;
import loginPage.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testCase {
    WebDriver driver = new FirefoxDriver();
    Homepage page;
    @BeforeMethod
    public void browserSetup() {
        page = new Homepage(driver);
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void runningElements() {
        page.enterUsername("locked_out_user");
        page.enterPassword("secret_sauce");
        page.click();
        page.errors("Epic sadface: Sorry, this user has been locked out.");
    }

    @AfterTest
    public void closingBrowser() {
        page.tearingItDown();
    }
}


