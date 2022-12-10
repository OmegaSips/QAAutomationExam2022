package baseTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MakeanAppoAnotherTryPage;
import pages.ConfirmationPage;

public class LoginTest extends BaseTest {
    private WebDriver driver;
//This is a login test
    @Test(priority = 1, dataProvider = "LoginData")
    public void loginSuccessfulTest(String Username, String Password) {
        LoginPage loginTest = homePage.clickMakeAppointment();
        loginTest.setUsername(Username);
        loginTest.setPassword(Password);

         Assert.assertTrue(true,loginTest.getLoginPageTitle());
         System.out.println("The Login page heading is: " +loginTest.getLoginPageTitle());

        loginTest.clickLoginbutton();

    }
    @DataProvider()
    public Object[][] LoginData() {
        Object[][] data = new Object[1][2]; data[0][0] = "John Doe"; data[0][1] = "ThisIsNotAPassword";

        return data;
    }

// This is a make appointment test
        @Test(priority = 2, dataProvider = "MakeAppointment")
        public void makeanAppoTest(String InputFacility,Integer Radios, String Visitdate, String Comment) {

            MakeanAppoAnotherTryPage makeAppointmentpages = MakeAppoinstance.selectFacility(InputFacility);
            makeAppointmentpages.selectCheckbox();
            makeAppointmentpages.selectHealthCareRadios(Radios);
            makeAppointmentpages.selectVisitDate(Visitdate);
            makeAppointmentpages.selectComment(Comment);
            makeAppointmentpages.clickBookAppointmentbutton();

            ConfirmationPage confirmationPage = ConfirmationInstance.clickgotoHomepageButton();

            Assert.assertTrue(true, makeAppointmentpages.getAppointmentTitle());
            System.out.println("The Appoinment page heading is: " + makeAppointmentpages.getAppointmentTitle());

        }

        @DataProvider()
        public Object[][] MakeAppointment() {
            Object[][] data = new Object[3][4];
            data[0][0] = "Tokyo CURA Healthcare Center"; data[0][1] =1; data[0][2] = "10/11/2023"; data[0][3] = "This is a 1st Booking";
            data[1][0] = "Hongkong CURA Healthcare Center"; data[1][1] =0; data[1][2] = "10/11/2024"; data[1][3] = "This is a 2nd booking";
            data[2][0] = "Seoul CURA Healthcare Center"; data[2][1] = 2; data[2][2] = "10/11/2025"; data[2][3] = "This is a 3rd Booking";

            return data;
        }

    }