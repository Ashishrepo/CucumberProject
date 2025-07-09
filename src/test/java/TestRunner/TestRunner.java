package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features= "C://Users//ashish.jain3//IdeaProjects//CucumberProject//src//test//Resource//Features",
        glue="StepDef",
        monochrome = true,
        plugin = {"pretty","html:target/test-output.html","html:target/cucumber.html"},
        tags = "@smoke"
)
public class TestRunner
{

}
