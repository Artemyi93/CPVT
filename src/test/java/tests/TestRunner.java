package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(//
        features = "src/test/resources/features",//
        dryRun = false,//
        strict = true,//
        snippets= SnippetType.UNDERSCORE )

public class TestRunner {
    @BeforeClass
    public static void setUp(){
        SetWebDriver.initDriver();
    }

    @AfterClass
    public static void tearDown() {
        SetWebDriver.getDriver().close();
    }
}

