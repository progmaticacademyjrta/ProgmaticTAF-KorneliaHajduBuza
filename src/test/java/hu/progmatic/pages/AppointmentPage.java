package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AppointmentPage {
    WebDriver driver;
    WebDriverWait wait;

    By facilityBy = By.id("combo_facility");
    By hospitalReadmissionBy = By.id("chk_hospotal_readmission");
    By healthcareProgramBy = By.xpath("//*[@id=\"appointment\"]/div/div/form/div[3]/div/label[2]");
    By datepickerBy = By.id("txt_visit_date");
    By commentBy = By.id("txt_comment");
    By bookAppointmentButtonBy = By.id("btn-book-appointment");

    public AppointmentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void makeAppointment() throws InterruptedException {
        Select facility = new Select(driver.findElement(facilityBy));
        facility.selectByValue("Hongkong CURA Healthcare Center");

        WebElement hospitalReadmission = driver.findElement(hospitalReadmissionBy);
        hospitalReadmission.click();

        WebElement healthcareProgram = driver.findElement(hospitalReadmissionBy);
        healthcareProgram.click();

        WebElement datePicker = driver.findElement(datepickerBy);
        datePicker.sendKeys("01/11/2023");

        WebElement comment = driver.findElement(commentBy);
        comment.sendKeys("No comment.");

        WebElement bookAppointmentButton = driver.findElement(bookAppointmentButtonBy);
        bookAppointmentButton.click();

        Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/appointment.php#summary", driver.getCurrentUrl());
        System.out.println("Making an appointment was successful.");
    }
}
