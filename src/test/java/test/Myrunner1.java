package test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/featurefile/gmailpom.feature", 
                  glue = "automation", 
                  plugin = { "pretty","html:target/run" }, 
                  monochrome = true)

public class Myrunner1 {

}
