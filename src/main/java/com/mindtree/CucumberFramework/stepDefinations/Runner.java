package com.mindtree.CucumberFramework.stepDefinations;

import java.io.File;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import gherkin.formatter.model.Scenario;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src\\test\\resources\\features\\landing.feature"
		,glue={"com.mindtree.CucumberFramework.stepDefinations"},
		tags= {"@LANDING"},
		plugin = {"pretty", "html:target/Destination","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report"+".html" }, 
		monochrome = false
		)

public class Runner extends AbstractTestNGCucumberTests {

	//@AfterClass
	public static void WriteExtentReport(Scenario scenario) {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")
				+"\\src\\main\\java\\com\\mindtree\\CucumberFramework\\utils\\ReportsConfig.xml"));
	}
	
}
