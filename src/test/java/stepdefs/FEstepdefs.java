package stepdefs;

import General.ReusableMethods;
import Validations.FrontendValidations;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class FEstepdefs {

    public static By dropdown = By.xpath("//*[@class=\"sc-aef7b723-0 sc-dae82938-0 coScOT\"][text()='100']");
    public static By firstButton = By.xpath("//div[@class='gv-close']");
    public static By secondButton = By.xpath("//button[@class=\"sc-a4a6801b-0 jgNqHP\"][text()='100']");
    public static By validateRows=By.xpath("//div[@class='sc-853bfcae-1 eibzVK']/table/tbody/tr");
    public static By subFilterButton=By.xpath("//button[@class=\"sc-a4a6801b-0 gNHIvn sc-cc37dd9f-0 sc-7b31fd38-0 cmPAGl\"][text()=\"Add Filter\"]");
    public static By mainFilterButton=By.xpath("//div[@class=\"sc-be3392e-4 evcgfK hide_on_mobile_wrapper\"]//button[@class=\"sc-a4a6801b-0 gNHIvn sc-c8c9e58f-0 eTWSGQ table-control-filter\"][text()=\"Filters\"]");
    public static By marketCapFilter=By.xpath("//button[@class=\"sc-a4a6801b-0 cGFzGl cmc-filter-button\"][text()=\"Market Cap\"]");
    public static By minMarketCap=By.xpath("//input[@class=\"sc-9cbf023e-0 WbXLA sc-67bdc129-3 eduQxS\"][@data-qa-id=\"range-filter-input-min\"]");
    public static By maxMarketCap=By.xpath("//input[@class=\"sc-9cbf023e-0 WbXLA sc-67bdc129-3 eduQxS\"][@data-qa-id=\"range-filter-input-max\"]");
    public static By priceFilter=By.xpath("//button[@class=\"sc-a4a6801b-0 cGFzGl cmc-filter-button\"][text()=\"Price\"]");
    public static By maxPriceFilter=By.xpath("//input[@class=\"sc-9cbf023e-0 WbXLA sc-67bdc129-3 eduQxS\"][@data-qa-id=\"range-filter-input-max\"]");
    public static By minPriceFilter=By.xpath("//input[@class=\"sc-9cbf023e-0 WbXLA sc-67bdc129-3 eduQxS\"][@data-qa-id=\"range-filter-input-min\"]");
    public static By applyFilterBtn=By.xpath("//button[@class=\"sc-a4a6801b-0 glxMF cmc-filter-button\"][text()=\"Apply Filter\"]");
    public static By closeFilters=By.xpath("//*[local-name()='svg'][@class=\"sc-aef7b723-0 dsDrxm icon\"]");
    public static By validateFilters=By.xpath("//*[@class=\"sc-853bfcae-2 eVOXbZ cmc-table  \"]//tbody//a[@class=\"cmc-link\"]//span");
    public static By validateMarketCap=By.xpath("//*[@class=\"sc-853bfcae-2 eVOXbZ cmc-table  \"]//tbody//span[@class=\"sc-65d3c89-1 dKgvPU\"]");


    @And("^user lands on coinmarketcap website$")
    public void user_lands_on_coinmarketcap_website() {
        ReusableMethods.arriveToWebsite();
    }

    @And("^user wants to scroll$")
    public void user_wants_to_scroll() {
        ReusableMethods.ClickingOn(firstButton);
        ReusableMethods.scrollToSpecificHeight();
    }

    @Then("^user clicks on row filter dropdown$")
    public void user_clicks_on_row_filter_dropdown() {
        ReusableMethods.ClickingOn(dropdown);
        ReusableMethods.ClickingOn(secondButton);
    }

    @And("^user validates the number of rows$")
    public void user_validates_the_number_of_rows() {
        FrontendValidations.validateRows(validateRows);
    }

    @And("^user clicks on filter button$")
    public void user_clicks_on_filter_button() {
        ReusableMethods.ClickingOn(firstButton);
        ReusableMethods.scrollToSpecificHeight();
        ReusableMethods.ClickingOn(mainFilterButton);
        ReusableMethods.ClickingOn(subFilterButton);
    }

    @And("^user selects price filter$")
    public void user_selects_price_filter() {
        ReusableMethods.ClickingOn(priceFilter);
        ReusableMethods.IhaveGivenInput(minPriceFilter,"101");
        ReusableMethods.IhaveGivenInput(maxPriceFilter,"1000");
        ReusableMethods.ClickingOn(applyFilterBtn);
    }

    @And("^user selects market-cap filter$")
    public void user_selects_marketcap_filter() {
        ReusableMethods.ClickingOn(marketCapFilter);
        ReusableMethods.IhaveGivenInput(minMarketCap,"1000000000");
        ReusableMethods.IhaveGivenInput(maxMarketCap,"10000000000");
        ReusableMethods.ClickingOn(applyFilterBtn);
        ReusableMethods.ClickingOn(closeFilters);
    }

    @And("^user validates both filters$")
    public void user_validates_both_filters() {
        FrontendValidations.validateFilters(validateFilters,validateMarketCap);
    }
}
