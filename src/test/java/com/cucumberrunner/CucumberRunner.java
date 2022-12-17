package com.cucumberrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin={"json:target/cucumber.json"},
		features ={"src/main/resources/LoginFunction.feature"},
		glue={"com.cucumberrunner"}
			
			)

public class CucumberRunner extends AbstractTestNGCucumberTests{

}
