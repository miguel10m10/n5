package pom.home;

import org.openqa.selenium.By;

public class HomePage {

    public By titles(){
        return By.className("nm-content-horizontal-row");
    }
    public By titlesList(){
        return By.className("nm-collections-title-list");
    }


}
