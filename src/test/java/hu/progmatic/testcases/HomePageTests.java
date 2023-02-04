package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTests extends DriverBaseTest {
    HomePage homePage;

    @Test(groups = "smoke", description = "TC01: Homepage loaded test that loads the page and validates whether the header is displayed or not.")
    public void homepageLoadedTest() {
        homePage = new HomePage(driver, wait);

        homePage.loadHomePage();
    }

    @Test(groups = "smoke", description = "TC02: Testing the Make Appointment button. Clicking on Make Appointment button navigates to the Login page.")
    public void clickingOnMageAppointButtonTest() throws InterruptedException {
        homePage = new HomePage(driver, wait);

        homePage.loadHomePage();
        homePage.clickOnMakeAppointment();
    }


}
