package stepdefs;

import General.ReusableMethods;
import Validations.FrontendValidations;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class FEstepdefs {

    public static By dropdown = By.xpath("//*[contains(@class,\"sc-aef7b723\")][text()='100']");
    public static By firstButton = By.xpath("//div[@class='gv-close']");
    public static By secondButton = By.xpath("//button[contains(@class,\"sc-a4a6801\")][text()='100']");
    public static By validateRows=By.xpath("//div[contains(@class,'sc-e19573')]/table/tbody/tr");
    public static By subFilterButton=By.xpath("//button[contains(@class,\"sc-a4a6801b\")][text()=\"Add Filter\"]");
    public static By mainFilterButton=By.xpath("//div[contains(@class,\"sc-be3392e-4\")]//button[contains(@class,\"sc-a4a6801b-0\")][text()=\"Filters\"]");
    public static By marketCapFilter=By.xpath("//button[contains(@class,\"sc-a4a6801\")][text()=\"Market Cap\"]");
    public static By minValue=By.xpath("//input[contains(@class,\"sc-9cbf023e\")][@data-qa-id=\"range-filter-input-min\"]");
    public static By maxValue=By.xpath("//input[contains(@class,\"sc-9cbf023e\")][@data-qa-id=\"range-filter-input-max\"]");
    public static By priceFilter=By.xpath("//button[contains(@class,\"sc-a4a6801b-0\")][text()=\"Price\"]");
    public static By applyFilterBtn=By.xpath("//button[contains(@class,\"sc-a4a6801\")][text()=\"Apply Filter\"]");
    public static By closeFilters=By.xpath("//*[local-name()='svg'][@class=\"sc-aef7b723-0 dsDrxm icon\"]");
    public static By validateFilters=By.xpath("//*//tbody//a[@class=\"cmc-link\"]//span");
    public static By validateMarketCap=By.xpath("//*//tbody//span[contains(@class,\"sc-65d3c89-1\")]");
    public static By validateFilteredRows=By.xpath("//div[@class='sc-e19573c7-1 bbJVqf']/table[@class='sc-e19573c7-2 hgVzQQ cmc-table  ']/tbody/tr");

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
        ReusableMethods.IhaveGivenInput(minValue,"101");
        ReusableMethods.IhaveGivenInput(maxValue,"1000");
        ReusableMethods.ClickingOn(applyFilterBtn);
    }

    @And("^user selects market-cap filter$")
    public void user_selects_marketcap_filter() {
        ReusableMethods.ClickingOn(marketCapFilter);
        ReusableMethods.IhaveGivenInput(minValue,"1000000000");
        ReusableMethods.IhaveGivenInput(maxValue,"10000000000");
        ReusableMethods.ClickingOn(applyFilterBtn);
        ReusableMethods.ClickingOn(closeFilters);
    }

    @And("^user validates both filters$")
    public void user_validates_both_filters() {
        FrontendValidations.validateFilters(validateFilters,validateMarketCap,validateFilteredRows);
    }
}
