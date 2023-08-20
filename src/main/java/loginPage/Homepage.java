package loginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
public class Homepage {
    WebDriver driver;
    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id=\"user-name\"]")
    WebElement username;

    @FindBy(xpath = "//input[@id=\"password\"]") WebElement password;

    @FindBy(xpath = "//input[@id=\"login-button\"]") WebElement button;

    @FindBy(xpath = "//h3[@data-test = \"error\"]") WebElement error;

    public void enterUsername(String user) {
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void click() {
        button.click();
    }

    public void tearingItDown() {
        driver.quit();
    }

    public void errors(String err) {
        Assert.assertEquals(error.getText(),err);
    }
}
