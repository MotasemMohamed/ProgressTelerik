package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;

    // this function remove the last allure report in the folder is called a allure-results
    @BeforeSuite
    public static void cleanAllureResults() {
        File allureResults = new File(System.getProperty("user.dir") + "/allure-results");
        if (allureResults.exists()) {
            for (File file : allureResults.listFiles()) {
                file.delete();
            }
        }
    }

    @BeforeTest
    public void startDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.telerik.com/support/demos");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

//    @Parameters({"browser"})
//    public void startDriver(@Optional("chrome") String browserName) {
//
//        if (browserName.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//
//        } else if (browserName.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//
//        } else if (browserName.equalsIgnoreCase("opera")) {
//            WebDriverManager.operadriver().setup();
//            driver = new OperaDriver();
//        } else if (browserName.equalsIgnoreCase("chrome-headless")) {
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions option = new ChromeOptions();
//            option.addArguments("--headless");
//            driver = new ChromeDriver(option);
//        }
//        driver.manage().deleteAllCookies();
//        driver.get("https://www.telerik.com/support/demos");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//    }

    // Capture screenshot on test failure or success
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SUCCESS) {
            try {
                attachScreenshotToAllure();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to capture and attach the screenshot to Allure report
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshotToAllure() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        return FileUtils.readFileToByteArray(screenshot);
    }

    // Here we will open the allure report
    // Assuming Allure is installed and available in the system path
    public static void generateReport() {
        try {
            String allurePath = "C:/Users/Motasem Fouad/scoop/shims/allure.cmd";
            ProcessBuilder processBuilder = new ProcessBuilder(allurePath, "serve", "allure-results");
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Close the Browser then will open the allure report
    @AfterSuite
    public void closeDriver() {
        driver.quit();
        generateReport();
    }
}
