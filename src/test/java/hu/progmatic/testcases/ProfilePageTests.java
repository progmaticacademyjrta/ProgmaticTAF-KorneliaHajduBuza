package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import hu.progmatic.pages.ProfilePage;
import org.testng.annotations.Test;

public class ProfilePageTests extends DriverBaseTest {
    HomePage homePage;
    LoginPage loginPage;
    ProfilePage profilePage;

    @Test(groups = "regression", description = "TC07: Testing that profile page loaded successfully after login. Logout button should appear.")
    public void homepageLoadedTest() throws InterruptedException {
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        profilePage = new ProfilePage(driver, wait);

        homePage.loadHomePage();
        homePage.clickOnMakeAppointment();
        loginPage.loginSuccessful("John Doe", "ThisIsNotAPassword");
        profilePage.loadingProfilePage();
    }
}
