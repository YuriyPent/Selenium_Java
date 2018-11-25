import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;


public class SignUpTests {

    private SignUpPage page;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Tools\\geckodriver.exe");
        baseUrl = "https://www.spotify.com/us/signup";
        //browser = "marionette";
        //WebDriverRunner.setWebDriver(new FirefoxDriver());
    }

    @Test
    public void typeInvalidYear() {
        page = new SignUpPage();
        page.open()
                .setMonth("December")
                .typeDay("12")
                .typeYear("77")
                .setShare(true);
        page.getError("Please enter a valid year.")
                .shouldBe(visible);
        page.getError("When were you born?")
                .shouldNotBe(visible);
    }

    @Test
    public void typeInvalidEmail() {
        page = new SignUpPage();
        page.open()
                .typeName("test@mail.test")
                .typeConfirmEmail("wrong@mail.test")
                .typeName("Testname")
                .clickSignUpButton();
        page.getError("Email address doesn't match.")
                .shouldBe(visible);
    }

    @Test
    public void signupWithEmptyPassword() {
        page = new SignUpPage();
        page.open()
                .typeEmail("test@mail.test")
                .typeConfirmEmail("test@mail.test")
                .typeName("Testname")
                .clickSignUpButton();
        page.getError("Please choose a password.")
                .shouldBe(visible);
    }

    @Test
    public void typeinvalidValues() {
        page = new SignUpPage();
        page.open()
                .typeEmail("testmail")
                .typeConfirmEmail("wrong@test.mail")
                .typePassword("qwerty1234")
                .typeName("Name")
                .setSex("Male")
                .setShare(false)
                .clickSignUpButton();
        page.getErrors().shouldHave(size(6));
        page.getErrorByNumber(3)
                .shouldHave(text("Please enter your birth month."));

    }

}