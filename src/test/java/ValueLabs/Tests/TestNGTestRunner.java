package ValueLabs.Tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/ValueLabs/Tests",glue="ValueLabs.StepDefinitions",
monochrome=true, tags = "@Regression", plugin= 
{"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})


public class TestNGTestRunner extends AbstractTestNGCucumberTests{


}
