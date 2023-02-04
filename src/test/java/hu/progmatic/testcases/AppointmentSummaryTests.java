package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.*;
import org.testng.annotations.Test;

public class AppointmentSummaryTests extends DriverBaseTest {
    HomePage homePage;
    LoginPage loginPage;
    AppointmentPage appointmentPage;
    ProfilePage profilePage;
    AppointmentSummaryPage appointmentSummaryPage;

    @Test(groups = "regression", description = "TC09: Testing clicking on Go to Home button navigates to the home page.")
    public void goToHomepageButtonTest() throws InterruptedException {
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        appointmentPage = new AppointmentPage(driver, wait);
        appointmentSummaryPage = new AppointmentSummaryPage(driver, wait);

        homePage.loadHomePage();
        homePage.clickOnMakeAppointment();
        loginPage.loginSuccessful("John Doe", "ThisIsNotAPassword");
        appointmentPage.makeAppointment();
        appointmentSummaryPage.clickingOnGoToHomePageButton();

    }
}
