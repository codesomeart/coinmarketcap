package stepdefs;

import General.ReusableMethods;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

public class FEstepdefs {

    public static By dropdown = By.xpath("//*[@class=\"sc-aef7b723-0 sc-dae82938-0 coScOT\"][text()='100']");
    public static By firstButton = By.xpath("//div[@class='gv-close']");
    public static By secondButton = By.xpath("//*[@class=\"sc-612ec9ca-0 RqNTy\"][text()='100']");
    public static By validateRows=By.xpath("//div[@class='sc-853bfcae-1 eibzVK']/table/tbody/tr");

    @And("user wants to run case")
    public void user_wants_to_run_case() {
        ReusableMethods.arriveToWebsite();
    }

    @And("user wants to scroll")
    public void user_wants_to_scroll() {
        ReusableMethods.ClickingOn(firstButton);
        ReusableMethods.scrollToSpecificHeight();
        ReusableMethods.ClickingOn(dropdown);
        ReusableMethods.ClickingOn(secondButton);
        ReusableMethods.validation(validateRows);
    }
}
