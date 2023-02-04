package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AppointmentSummaryPage {
    WebDriver driver;
    WebDriverWait wait;

    By goToHomepageButtonBy = By.linkText("Go to Homepage");

    public AppointmentSummaryPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickingOnGoToHomePageButton() {
        WebElement goToHomePageButton = driver.findElement(goToHomepageButtonBy);
        goToHomePageButton.click();

        Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/", driver.getCurrentUrl());
        System.out.println("Go to Homepage button is clickable on summary page.");

    }
}
