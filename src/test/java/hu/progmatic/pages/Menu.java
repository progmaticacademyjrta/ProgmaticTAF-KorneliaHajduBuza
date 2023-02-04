package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Menu {
    WebDriver driver;
    WebDriverWait wait;

    By menuToggleBy = By.id("menu-toggle");
    By historyMenuBy = By.linkText("History");
    By historyTitleBy = By.xpath("//*[@id=\"history\"]/div/div[1]/div/h2");


    public Menu(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void chooseHistoryMenu() {
        WebElement menuToggle = driver.findElement(menuToggleBy);
        menuToggle.click();

        WebElement historyMenu = driver.findElement(historyMenuBy);
        historyMenu.click();

        Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/history.php#history", driver.getCurrentUrl());
        System.out.println("History page is successfully loaded.");
    }
}
