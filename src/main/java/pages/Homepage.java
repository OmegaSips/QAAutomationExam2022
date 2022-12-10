package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
    private static WebDriver driver;
    private By makeAppointmentlink = By.id("btn-make-appointment");

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }


    public LoginPage clickMakeAppointment() {
        driver.findElement(makeAppointmentlink).click();
        return new LoginPage(driver);

    }
}



