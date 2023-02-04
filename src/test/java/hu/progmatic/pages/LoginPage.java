package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;


    By userNameBy = By.id("txt-username");
    By passwordBy = By.id("txt-password");
    By loginButtonBy = By.id("btn-login");
    By loginFailedMessageBy = By.cssSelector("p[class='lead text-danger']");
    By menuToggleBy = By.id("menu-toggle");
    By logoutMenuBy = By.cssSelector("a[href='authenticate.php?logout']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void failedLogin(String username, String password) throws InterruptedException {
        WebElement userNameInput = driver.findElement(userNameBy);
        userNameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(passwordBy);
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();

        WebElement loginFailedMessage = driver.findElement(loginFailedMessageBy);

        Assert.assertTrue(loginFailedMessage.isDisplayed());
        System.out.println("Login with wrong user credentials was successfully done.");
    }

    public void loginSuccessful(String username, String password) throws InterruptedException {
        WebElement userNameInput = driver.findElement(userNameBy);
        userNameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(passwordBy);
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();

        Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/#appointment", driver.getCurrentUrl());
        System.out.println("Login with valid user credentials was successfully done.");
    }

    public void logout() {
        WebElement menuToggle = driver.findElement(menuToggleBy);
        menuToggle.click();

        WebElement logoutMenu = driver.findElement(logoutMenuBy);
        logoutMenu.click();

        Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/", driver.getCurrentUrl());
        System.out.println("Successfully logout.");
    }
}
