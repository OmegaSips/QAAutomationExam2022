package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MakeanAppoAnotherTryPage {

    private  static WebDriver driver;
    private By facilityField = By.id("combo_facility");
    private By applyCheckbox = By.xpath("//*[@id=\"chk_hospotal_readmission\"]");
    private By healthCareRadios = By.name("programs");
    private By visitDate = By.cssSelector("#txt_visit_date");
    private By commentField = By.id("txt_comment");
    private By bookAppointmentbutton = By.id("btn-book-appointment");

    private By confirmationTitle = By.cssSelector("#summary > div > div > div.col-xs-12.text-center > h2");

    private By makeappointmentTitle = By.tagName ("h2");


    public MakeanAppoAnotherTryPage(WebDriver driver) {
        this.driver = driver;
    }

    public MakeanAppoAnotherTryPage selectFacility(String inputFacility){
        driver.findElement(facilityField).sendKeys(inputFacility);
        return new MakeanAppoAnotherTryPage(driver);
    }

    public void selectCheckbox() {
        driver.findElement(applyCheckbox).click();
        // driver.findElement(applyCheckbox).clear();
    }

    public void selectHealthCareRadios(Integer inputRadios) {
       int a = driver.findElements(healthCareRadios).size();
        driver.findElements(healthCareRadios).get(inputRadios.intValue()).click();
    }

    public void selectVisitDate(String inputVisitdate) {
        driver.findElement(visitDate).sendKeys(inputVisitdate);
        // driver.findElement(visitDate).clear();
    }

    public void selectComment(String inputComment) {
        driver.findElement(commentField).sendKeys(inputComment);
        //driver.findElement(commentField).clear();
    }

    public MakeanAppoAnotherTryPage clickBookAppointmentbutton() {
        driver.findElement(bookAppointmentbutton).submit();
        return new MakeanAppoAnotherTryPage(driver);
    }

    public String getAppointmentTitle(){
        return driver.findElement(makeappointmentTitle).getText();
    }



}
