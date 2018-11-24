import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//https://www.spotify.com/us/signup/

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    By emailField = By.cssSelector("input#register-email");
    By confirmEmailField = By.cssSelector("input#register-confirm-email");
    By passwordField = By.cssSelector("input#register-password");
    By nameField = By.cssSelector("input#register-displayname");
    By monthDropDown = By.cssSelector("select#register-dob-month");
    String monthDropDownOption = "//select[@id='register-dob-month']/option[text()='%s']";
    By dayField = By.cssSelector("input#register-dob-day");
    By yearField = By.cssSelector("input#register-dob-year");
    String sexRadioButton = "//li[@id=\"li-gender\"]/label[normalize-space()='%s']/input";
    By shareCheckbox = By.cssSelector("register-thirdparty");
    By registerButton = By.cssSelector("register-button-email-submit");
    By errorLabel = By.xpath("//label[@class='has-error' and string-length(text())>0]");
    By errorByText = By.xpath("//label[@class='has-error' and text()='%s']");


}