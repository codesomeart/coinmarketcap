package tests;

import General.WebDriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(features = {"src/test/resources/features"},glue = {"stepdefs"},plugin = { "pretty", "html:target/cucumber" },tags = "@All")

public class TestRunner extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void AfterClass() {

        WebDriverFactory.finishDriver();
    }}
