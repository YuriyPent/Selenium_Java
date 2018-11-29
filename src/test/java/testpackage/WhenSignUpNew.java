package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import testpackage.steps.serenity.SignUpSteps;

@RunWith(SerenityRunner.class)
public class WhenSignUpNew {

    @Steps
    SignUpSteps steps;

    @Managed
    WebDriver driver;

    @Test
    @Title("When the user types invalid year TEST")
    public void typeInvalidYear() {
        steps.open_signup_page();
        steps.set_month("December");
        steps.set_day("20");
        steps.set_year("77");
        steps.set_share(true);
        steps.should_see_error("Please enter a valid year.");
        steps.should_not_see_error("When were you born?");
    }

}