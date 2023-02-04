package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import hu.progmatic.pages.ProfilePage;
import org.testng.annotations.Test;

public class CuraEndToEndTest extends DriverBaseTest {
    HomePage homePage;
    LoginPage loginPage;
    AppointmentPage appointmentPage;
    ProfilePage profilePage;

    @Test(groups = "smoke", description = "TC08: End-to-end test: testing login, make appointment, navigate to summary page and logout.")
    public void curaEndToEndTest() throws InterruptedException {
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        appointmentPage = new AppointmentPage(driver, wait);
        profilePage = new ProfilePage(driver, wait);

        homePage.loadHomePage();
        homePage.clickOnMakeAppointment();
        loginPage.loginSuccessful("John Doe", "ThisIsNotAPassword");
        appointmentPage.makeAppointment();
        profilePage.loadingProfilePage();
        loginPage.logout();
    }
}
