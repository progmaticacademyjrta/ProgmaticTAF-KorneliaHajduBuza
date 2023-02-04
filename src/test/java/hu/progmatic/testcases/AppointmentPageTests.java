package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import org.testng.annotations.Test;

public class AppointmentPageTests extends DriverBaseTest {
    HomePage homePage;
    LoginPage loginPage;
    AppointmentPage appointmentPage;

    @Test(groups = "smoke", description = "TC06: Testing the making an appointment funkction. Clicking on the Book Appointment button should navigate to the appointment summary page.")
    public void makeAppointTest() throws InterruptedException {
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        appointmentPage = new AppointmentPage(driver, wait);

        homePage.loadHomePage();
        homePage.clickOnMakeAppointment();
        loginPage.loginSuccessful("John Doe", "ThisIsNotAPassword");
        appointmentPage.makeAppointment();
    }
}
