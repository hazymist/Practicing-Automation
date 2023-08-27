package loginpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='user-name']")
     private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;


    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginbutton;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement error;

    private WebElement getUsername() {
        return username;
    }

    public void enterUsername(String username) {
        getUsername().sendKeys(username);
    }

    private WebElement getPassword() {
        return password;
    }

    public void enterPassword(String password) {
        getPassword().sendKeys(password);
    }

    public void click() {
        loginbutton.click();
    }


    public void validatingErrorDisplay(String error_message) {
        Assert.assertEquals(error.getText(),error_message);
    }
}
