package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.*;
import org.testng.annotations.Test;

public class CuraEndToEndTest extends DriverBaseTest {
    HomePage homePage;
    LoginPage loginPage;
    AppointmentPage appointmentPage;
    ProfilePage profilePage;
    Menu menu;

    @Test(groups = "smoke", description = "TC08: End-to-end test: testing login, make appointment, navigate to summary page and logout.")
    public void curaEndToEndTest() throws InterruptedException {
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        appointmentPage = new AppointmentPage(driver, wait);
        profilePage = new ProfilePage(driver, wait);
        menu = new Menu(driver, wait);

        homePage.loadHomePage();
        homePage.clickOnMakeAppointment();
        loginPage.loginSuccessful("John Doe", "ThisIsNotAPassword");
        appointmentPage.makeAppointment();
        menu.chooseHistoryMenu();
        profilePage.loadingProfilePage();
        loginPage.logout();
    }




}
