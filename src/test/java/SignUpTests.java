import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SignUpTests {
     private WebDriver driver;
     private SignUpPage page;

     @Before
     public void setUp(){
          System.setProperty("webdriver.gecko.driver", "C:\\Tools\\geckodriver.exe");
          driver = new FirefoxDriver();
          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          driver.get("https://www.spotify.com/us/signup/");
     }

     @Test
     public void typeInvalidYear(){
          page = new SignUpPage(driver);
          page.setMonth("December").typeDay("12").typeYear("77").setShare(true);
          assertTrue(page.isErrorVisible("Please enter a valid year."));
          assertFalse(page.isErrorVisible("When were you born?"));
     }

     @Test
     public void typeInvalidEmail(){
          page = new SignUpPage(driver);
          page.typeName("test@mail.test")
                  .typeConfirmEmail("wrong@mail.test")
                  .typeName("Testname")
                  .clickSignUpButton();
          assertTrue(page.isErrorVisible("Email address doesn't match."));
     }

     @Test
     public void signupWithEmptyPassword(){
          page = new SignUpPage(driver);
          page.typeEmail("test@mail.test")
                  .typeConfirmEmail("test@mail.test")
                  .typeName("Testname")
                  .clickSignUpButton();
          assertTrue(page.isErrorVisible("Please choose a password."));
     }

     @Test
     public void typeinvalidValues(){
          page = new SignUpPage(driver);
          page.typeEmail("testmail")
                  .typeConfirmEmail("wrong@test.mail")
                  .typePassword("qwerty1234")
                  .typeName("Name")
                  .setSex("Male")
                  .setShare(false)
                  .clickSignUpButton();
          Assert.assertEquals(6, page.getErrors().size());
          Assert.assertEquals("Please enter your birth month.",
                  page.getErrorByNumber(3));

     }

     @After
     public void tearDown(){
          driver.quit();
     }



}