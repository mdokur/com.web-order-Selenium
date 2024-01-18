import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WO_013_VAP_01 extends Hooks {
/*
1- Open the URL
2- Click "WebOrder" button on top bar.
3- Enter valid username "Inar" and password "Academy".
4- Click on the "Login" button.
5- Navigate to the view all products page.
6- Verify the all products are visible
 */


    @Test
    void verifyAllNameOfProductsAreVisible() throws InterruptedException {
        //2- Click "WebOrder" button on top bar.
        WebElement webOrderLink = driver.findElement(By.xpath("//header/nav[1]/div[1]/div[1]/a[1]"));
        webOrderLink.click();

        Thread.sleep(2000);

        //3- Enter valid username "Inar" and password "Academy".
        WebElement usernameInput = driver.findElement(By.id("login-username-input"));
        WebElement passwordInput = driver.findElement(By.id("login-password-input"));

        usernameInput.sendKeys("Inar");
        passwordInput.sendKeys("Academy");

        //4-Click on the "Login" button.
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        Thread.sleep(2000);

        //5- Navigate to the view all products page.
        WebElement viewAllProductsTab = driver.findElement(By.xpath("//a[contains(text(),'View all products')]"));
        viewAllProductsTab.click();
        Thread.sleep(2000);

        //6- Verify the all products are visible
        List<WebElement> productsList = driver.findElements(By.xpath("//tbody/tr/td[1]/span"));
        List<String> expectedList = List.of("MyMoney", "FamilyAlbum", "ScreenSaver", "TechGadget", "HomeDecor", "FashionApparel",
                "Electronics", "HealthWellness", "SportsEquipment", "Books", "KitchenAppliances", "ToysGames");

        for (int i = 0; i < expectedList.size(); i++) {
            Assertions.assertEquals(expectedList.get(i), productsList.get(i).getText(), "The list of all products is not expected");
        }
    }
}
