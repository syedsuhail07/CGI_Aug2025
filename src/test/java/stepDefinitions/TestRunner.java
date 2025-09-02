package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\suhai\\eclipse-workspace\\Aug22\\src\\test\\resources\\Features"
,glue= {"stepDefinitions"}
,dryRun=false
,monochrome=true)

public class TestRunner {
		 
}