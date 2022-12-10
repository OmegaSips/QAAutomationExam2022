package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class ConfirmationPage {

    private WebDriver driver;
        private By goToHomepagebutton = By.xpath("//*[@id=\"summary\"]/div/div/div[7]/p/a");

    public ConfirmationPage(WebDriver driver){
        this.driver = driver;
    }


     public ConfirmationPage clickgotoHomepageButton() {
        driver.findElement(goToHomepagebutton).click();
        return new ConfirmationPage(driver);

    }
}
