import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;
//https://www.spotify.com/us/signup/

public class SignUpPage {


    private By emailField = By.cssSelector("input#register-email");
    private By confirmEmailField = By.cssSelector("input#register-confirm-email");
    private By passwordField = By.cssSelector("input#register-password");
    private By nameField = By.cssSelector("input#register-displayname");
    private By monthDropDown = By.cssSelector("select#register-dob-month");
    private String monthDropDownOption = "//select[@id='register-dob-month']/option[text()='%s']";
    private By dayField = By.cssSelector("input#register-dob-day");
    private By yearField = By.cssSelector("input#register-dob-year");
    private String sexRadioButton = "//li[@id='li-gender']//label[normalize-space()='Male']/input";
    private By shareCheckbox = By.cssSelector("input#register-thirdparty");
    private By registerButton = By.cssSelector("a#register-button-email-submit");
    private By errorLabel = xpath("//label[@class='has-error' and string-length(text())>0]");
    private String errorByText = "//label[@class=\"has-error\" and text()=\"%s\"]";

    public SignUpPage open() {
        Selenide.open("/");
        return this;
    }

    public SignUpPage typeEmail(String email) {
        $(emailField).setValue(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String email) {
        $(confirmEmailField).setValue(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        $(passwordField).setValue(password);
        return this;
    }

    public SignUpPage typeName(String name) {
        $(nameField).setValue(name);
        return this;
    }

    public SignUpPage setMonth(String month) {
        $(monthDropDown).selectOption(month);
        return this;
    }

    public SignUpPage typeDay(String day) {
        $(dayField).setValue(day);
        return this;
    }

    public SignUpPage typeYear(String year) {
        $(yearField).setValue(year);
        return this;
    }

    public SignUpPage setSex(String value) {
        $(By.xpath(format(sexRadioButton, value))).click();
        return this;
    }

    public SignUpPage setShare(boolean value) {
        $(shareCheckbox).setSelected(value);
        return this;
    }

    public void clickSignUpButton() {
        $(registerButton).click();
    }

    public ElementsCollection getErrors() {
        return $$(errorLabel);
    }

    public SelenideElement getErrorByNumber(int number) {
        return getErrors().get(number - 1);
    }

    public SelenideElement getError(String message) {
        return $(xpath(format(errorByText, message)));
    }
}