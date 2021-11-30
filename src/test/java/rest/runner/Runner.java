package rest.runner;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/java/restFeature"},
		glue={"rest.stepdefination"}
		)
public class Runner {

}
