package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private static WebDriver driver;

    private By LoginpageTitle = By.tagName ("h2");
    private By username = By.id("txt-username");
    private By password = By.name("password");
    private By Loginbtn = By.cssSelector("#btn-login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }



    public void setUsername(String inputUsername) {
        driver.findElement(username).sendKeys(inputUsername);
    }

    public void setPassword(String inputPassword) {
        driver.findElement(password).sendKeys(inputPassword);
    }

    public LoginPage clickLoginbutton() {
        driver.findElement(Loginbtn).click();

        return new LoginPage(driver);

    }
    public String getLoginPageTitle() {
        return driver.findElement(LoginpageTitle).getText();
    }
}
