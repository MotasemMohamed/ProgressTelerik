package Pages;

import Base.BagePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BagePage {
    By TryNowDDL = By.id("email");
    By NextBTN = By.cssSelector("button.btn.btn-accent.u-w100.loader-button");
    public By EmaillEment = By.cssSelector("span.u-wbba.page-body--bold");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    // The below method used to add a Valid Email then click on the next button navigate to the registration page
    public void Add_Email(String Email) {
        type(Email, TryNowDDL);
        click(NextBTN);
        visibilityWaitForElementToBeClickable(EmaillEment);
    }
}
