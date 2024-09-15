package TestCases;

import Base.TestBase;
import Data.CSVUtils;
import Data.ExcelReader;
import Data.ConfigLoader;
import Pages.DashboardPage;
import Pages.FreeTrialPage;
import Pages.RegistrationPage;
import Pages.SignInPage;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static Base.BagePage.*;

@Feature("Free Trial Test")
public class Get_Free_Trial_Test extends TestBase {
    @DataProvider(name = "ExcelData")
    public Object[][] userregisterData() throws IOException {
        ExcelReader ER = new ExcelReader();
        return ER.getExcelData();
    }

    @DataProvider(name = "testData")
    public static Object[] userData() {
        return new Object[]{"Egypt"};
    }

    CSVReader Reader;

    @Story("Test the free trial")
    @Description("Test the Free Trial cycle by opening it then select the UI for react from the Kendo UI plan")
    @Test(priority = 1, description = "1- This testcast for Tring the free trial")
    public void GetFreeTrial() {
        DashboardPage DashboardObject = new DashboardPage(driver);
        DashboardObject.Open_The_Free_Trial();
        FreeTrialPage FreeTrialObject = new FreeTrialPage(driver);
        FreeTrialObject.Open_The_UIforReact();
    }

    @Story("Test the free trial")
    @Description("Test the Free Trial cycle by adding a new valid email after that registration with valid data to create a new account")
    @Test(priority = 2, description = "2- SignIn By adding a new valid Emain", dependsOnMethods = {"GetFreeTrial"})
    public void SignIn() {
        String Email = generateFakeEmail();
        SignInPage SignInObject = new SignInPage(driver);
        SignInObject.Add_Email(Email);
        Assert.assertEquals(driver.findElement(SignInObject.EmaillEment).getText(), Email);
    }

    @Story("Test the free trial")
    @Description("Test the Free Trial cycle by adding a new valid email after that registration with valid data to create a new account")
    @Test(priority = 3, description = "3- Registration by adding a new valid data", dependsOnMethods = {"SignIn"}, dataProvider = "testData")
    public void Registration(String country) throws IOException, CsvValidationException, InterruptedException {
        //String CSV_file = System.getProperty("user.dir") + "/src/test/java/Data/UserData.csv";
        // Reader = new CSVReader(new FileReader(CSV_file));
        //String[] csvCell;
        // while ((csvCell = Reader.readNext()) != null) {
        // String Country = csvCell[0];
        RegistrationPage RegistrationObject = new RegistrationPage(driver);
        String csvFilePath = System.getProperty("user.dir") + "//src//test//java//Data//UserData.csv";
        List<String[]> data = CSVUtils.readCSV(csvFilePath);

        // Loop through the data from CSV and perform actions
        for (String[] row : data) {
            String Country = row[0];
            RegistrationObject.Add_Registration_data(generatePassword(), generateFirstName(), generateLastName(), generateCompanyName(), "01" + generatePhoneNumber(), country);
        }
        Assert.assertEquals(driver.findElement(By.xpath("//gdpr/div/div/label")).getText(), "By submitting this form, you understand and agree that your personal data will be processed by Progress Software or its Partners as described in our Privacy Policy. You may opt out from marketing communication at any time here or through the opt out option placed in the e-mail communication sent by us or our Partners.");
    }
}