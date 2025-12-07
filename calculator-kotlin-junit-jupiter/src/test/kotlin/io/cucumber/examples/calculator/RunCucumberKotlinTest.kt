package io.cucumber.examples.calculator

import io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME
import org.junit.platform.suite.api.Suite
import org.junit.platform.suite.api.IncludeEngines
import org.junit.platform.suite.api.SelectPackages
import org.junit.platform.suite.api.ConfigurationParameter

/**
 * Run Cucumber through the JUnit Platform Suite Engine.
 *
 * <p>Surefire does not use JUnits Test Engine discovery functionality and can
 * only discover class based tests.
 */
@Suite
@IncludeEngines("cucumber")
@SelectPackages("io.cucumber.examples.calculator")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "io.cucumber.examples.calculator")
class RunCucumberKotlinTest
