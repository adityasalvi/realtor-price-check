package com.Realtor.Cucumber;

import org.junit.runner.RunWith; 
import cucumber.junit.Cucumber; 

@RunWith(Cucumber.class) 
@Cucumber.Options(
		features = "Features"
		,glue={"stepDefinition"}
		,monochrome = false
		,format = {"pretty", "html:target/Destination"}
		) 

public class RunTest { }
