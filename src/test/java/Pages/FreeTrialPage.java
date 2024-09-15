package Pages;

import Base.BagePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FreeTrialPage extends BagePage {
    By TryNowDDL = By.cssSelector("a.Dropdown-control.Btn.Btn--prim.u-fs19.u-mw20.u-p1.u-db.u-s-full.u-s-mwn");
    By UIForReactOption = By.xpath("(//div[@class='DashMenu Section--white u-dib u-fs20 u-pa u-ha u-zi1']/a)[2]");

    public FreeTrialPage(WebDriver driver) {
        super(driver);
    }

    // The below method will open the UI for react by clicking on the ( TryNow ) in the (Kendo UI) plan then click on the (UI for React)
    public void Open_The_UIforReact() {
        click(TryNowDDL);
        click(UIForReactOption);
    }
}
