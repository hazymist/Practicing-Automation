package tests;
import loginpage.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase {
    WebDriver driver = new FirefoxDriver();
    HomePage home;
    @BeforeMethod
    public void browserSetup() {
        home = new HomePage(driver);
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void loginTestForInvaildAccount() {
        home.enterUsername("locked_out_user");
        home.enterPassword("secret_sauce");
        home.click();
        home.validatingErrorDisplay("Epic sadface: Sorry, this user has been locked out.");
    }

    @AfterTest
    public void closingBrowser() {
        driver.quit();
    }
}


