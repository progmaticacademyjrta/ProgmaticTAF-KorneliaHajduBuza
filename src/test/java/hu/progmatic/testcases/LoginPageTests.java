package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTests extends DriverBaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @Test(groups = "regression", description = "TC03: Testing login functionality with wrong username and valid password. Login failed error message should appear.")
    public void loginWithWrongUsernameAndValidPasswordTest() throws InterruptedException {
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        homePage.loadHomePage();
        homePage.clickOnMakeAppointment();
        loginPage.failedLogin("wrongusername", "ThisIsNotAPassword");

    }

    @Test(groups = "regression", description = "TC04: Testing login functionality with valid username and wrong password. Login failed error message should appear.")
    public void loginWithValidUsernameAndWrongPasswordTest() throws InterruptedException {
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        homePage.loadHomePage();
        homePage.clickOnMakeAppointment();
        loginPage.failedLogin("John Doe", "wrongpassword");
    }

    @Test(groups = "smoke", description = "TC05: Testing login functionality with valid username and valid password. Clicking on Login button navigates to the appointment page.")
    public void loginWithValidUsernameAndValidPasswordTest() throws InterruptedException {
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);

        homePage.loadHomePage();
        homePage.clickOnMakeAppointment();
        loginPage.loginSuccessful("John Doe", "ThisIsNotAPassword");
    }
}
