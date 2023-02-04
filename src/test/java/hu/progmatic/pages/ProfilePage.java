package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilePage {
    WebDriver driver;
    WebDriverWait wait;

    By menuToggleBy = By.id("menu-toggle");
    By profileMenuBy = By.linkText("Profile");
    By logoutButtonBy = By.cssSelector("a[href='https://katalon-demo-cura.herokuapp.com/authenticate.php?logout']");


    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loadingProfilePage() {
        WebElement menuToggle = driver.findElement(menuToggleBy);
        menuToggle.click();

        WebElement profileMenu = driver.findElement(profileMenuBy);
        profileMenu.click();
        
        WebElement logoutButton = driver.findElement(logoutButtonBy);

        Assert.assertTrue(logoutButton.isDisplayed());
        System.out.println("Profile page loaded successfully.");
    }
}
