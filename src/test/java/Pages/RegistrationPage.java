package Pages;

import Base.BagePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BagePage {
    By PasswordText = By.id("password");
    By FirstNameText = By.id("fist-name");
    By LastNameText = By.id("last-name");
    By CompanyText = By.id("company");
    By PhoneNumberText = By.id("phone");
    //By CountryofResidenceDDL = By.xpath("//kendo-combobox[@id='country']/kendo-searchbar/input");
    By CountryofResidenceDDL = By.xpath("//kendo-combobox[@id='country']/kendo-searchbar/input");
    By CreateAccountBTN = By.cssSelector("button.btn.btn-accent.u-w100.loader-button");
    By Footer = By.cssSelector("div.u-mb15.label.label--small.u-tac");
    WebElement CountryofResidenceDDLOption = driver.findElement(By.xpath("//kendo-combobox[@id='country']/kendo-searchbar/input"));

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    // The below method used to add a valid data in the Registration page and click on the Create a ccount button
    public void Add_Registration_data(String Password, String FirstName, String LastName, String CompanyName, String PhoneNumber, String Country) throws InterruptedException {
        Thread.sleep(1000);
        type(Password, PasswordText);
        type(FirstName, FirstNameText);
        type(LastName, LastNameText);
        type(CompanyName, CompanyText);
        type(PhoneNumber, PhoneNumberText);
        type(Country, CountryofResidenceDDL);
        Thread.sleep(1000);
        CountryofResidenceDDLOption.sendKeys(Keys.ENTER);
        scroll();
        click(CreateAccountBTN);
        //scroll();
        //click(CreateAccountBTN);
    }
}
