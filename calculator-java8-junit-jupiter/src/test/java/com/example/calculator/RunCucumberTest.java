package com.example.calculator;

import org.junit.platform.suite.api.ConfigurationParametersResource;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * Run Cucumber through the JUnit Platform Suite Engine.
 * 
 * <p>Surefire does not use JUnits Test Engine discovery functionality and can
 * only discover class based tests.
 */
@Suite
@IncludeEngines("cucumber")
@SelectPackages("com.example.calculator")
@ConfigurationParametersResource("cucumber.properties")
class RunCucumberTest {
}
