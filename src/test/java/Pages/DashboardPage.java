package Pages;

import Base.BagePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BagePage {
    By GetFreeTrialBTN = By.cssSelector("a.TK-Button.TK-Button--CTA");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void Open_The_Free_Trial() {
        click(GetFreeTrialBTN);
    }
}
