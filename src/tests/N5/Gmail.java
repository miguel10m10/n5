package tests.N5;

import core.helpers.ClickHelpers;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import pom.login.LoginPage;
import tests.Hooks;


public class Gmail extends Hooks {

    ClickHelpers click = new ClickHelpers();
    LoginPage loginPage = new LoginPage();

    @Test
    public void gmailTest_00002() throws InterruptedException {

        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;

        //email
        driver.findElementById(loginPage.emailField()).sendKeys("miguelangelmuro10@gmail.com");

        //password
        driver.findElementById(loginPage.passField()).sendKeys("000000");

        //SignIn
        driver.findElementById(loginPage.passField()).click();

        //assert
        MobileElement composeButton = driver.findElementById("username");
        assert composeButton.isDisplayed() : "Inicio de sesión fallido";

    }
}