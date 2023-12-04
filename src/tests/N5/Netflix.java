package tests.N5;

import core.helpers.WaitHelpers;
import org.openqa.selenium.WebElement;
import pom.home.HomePage;
import org.testng.annotations.Test;
import tests.Hooks;

import java.util.List;


public class Netflix extends Hooks {

    HomePage homePage = new HomePage();
    WaitHelpers waitHelpers = new WaitHelpers();

    @Test
    public void netflixTest_00001() throws InterruptedException {

        //Imprimir titulos
        //---------------------------
        waitHelpers.waitClickeable(driver, homePage.titles());
        WebElement browseTitles = driver.findElement(homePage.titles());
        List<WebElement> titleElements = browseTitles.findElements(homePage.titlesList());
        // Imprimir los títulos
        for (WebElement titleElement : titleElements) {
            System.out.println(titleElement.getText());
        }

        //Imprimir URL
        //---------------------------
        System.out.println("URL: " + driver.getCurrentUrl());
    }
}