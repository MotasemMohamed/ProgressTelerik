package Base;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class BagePage {
    protected static WebDriver driver;
    public static WebDriverWait wait;
    public static Faker faker;

    public BagePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Wait for element To be clickable and visible")
    public void visibilityWaitForElementToBeClickable(By element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }

    @Step("Find elements")
    protected WebElement find(By locator) {
        visibilityWaitForElementToBeClickable(locator);
        return driver.findElement(locator);
    }

    @Step("Send Text")
    protected void type(String text, By locator) {
        visibilityWaitForElementToBeClickable(locator);
        find(locator).click();
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    @Step("Click on element")
    protected void click(By locator) {
        visibilityWaitForElementToBeClickable(locator);
        find(locator).click();
    }

    @Step("Scroll Down")
    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,2000)");
    }

    @Step("Generate a FakerEmail")
    public static String generateFakeEmail() {
        faker = new Faker();
        return faker.internet().emailAddress();
    }

    @Step("Generate a FakerNumber")
    public static String generateFakeNumber(int num) {
        faker = new Faker();
        return faker.number().digits(num);
    }

    @Step("Generate a FakerFirstName")
    public static String generateFirstName() {
        faker = new Faker();
        return faker.name().firstName();
    }

    @Step("Generate a FakerLastName")
    public static String generateLastName() {
        faker = new Faker();
        return faker.name().lastName();
    }

    @Step("Generate a FakerPassword")
    public static String generatePassword() {
        faker = new Faker();
        return faker.internet().password(10, 15, true, true, true);
    }

    @Step("Generate a FakerCompanyName")
    public static String generateCompanyName() {
        faker = new Faker();
        return faker.company().name();
    }

    @Step("Generate a FakerPhoneNumber")
    public static String generatePhoneNumber() {
        faker = new Faker();
        return faker.number().digits(9);  //fakerdata.number().digits(11)
    }

    @Step("Generate Egypt-specific data")
    public static String generateCountryName() {
        faker = new Faker(new Locale("ar-EG"));
        return faker.country().name();
    }
}
