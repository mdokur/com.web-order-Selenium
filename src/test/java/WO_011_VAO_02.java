/*
1- Open the URL
2- Click "WebOrder" button on top bar.
3- Enter valid username "Inar" and password "Academy". 
4- Click on the "Login" button.
5- Navigate to the view all order page.
6- Click "Add More Data" "6" times.
7- Click "Check All" button.
8- Verify all orders selected.
9- Click "Uncheck All" button.
10- Verify all orders are unselected.
 */


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WO_011_VAO_02 extends Hooks {
    @Test
    void verifyUncheckAllFunctionalityInAllOrderPage() throws InterruptedException {

        //2- Click "WebOrder" button on top bar.
        WebElement webOrderLink = driver.findElement(By.xpath("//header/nav[1]/div[1]/div[1]/a[1]"));
        webOrderLink.click();

        Thread.sleep(5000);

        //3- Enter valid username "Inar" and password "Academy".
        WebElement usernameInput = driver.findElement(By.id("login-username-input"));
        WebElement passwordInput = driver.findElement(By.id("login-password-input"));

        usernameInput.sendKeys("Inar");
        passwordInput.sendKeys("Academy");

        //4-Click on the "Login" button.
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        Thread.sleep(5000);

        //5- Navigate to the view all order page.
        WebElement allOrdersTab = driver.findElement(By.cssSelector("#view-orders-tab > a"));
        allOrdersTab.click();

        //6- Click "Add More Data" "6" times.
        WebElement moreDateButton = driver.findElement(By.xpath("//button[contains(text(),'Add More Data')]"));
        for (int i = 0; i < 6; i++) {
            moreDateButton.click();
        }

        //7- Click "Check All" button.
        WebElement checkAllButton = driver.findElement(By.xpath("//button[contains(text(),'Check All')]"));
        checkAllButton.click();

        //8- Verify all orders selected.
        List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//input[@class='form-check-input']"));

        for (WebElement element : allCheckBoxes) {
            Assertions.assertTrue(element.isSelected());
        }

        //9- Click "Uncheck All" button.
        WebElement uncheckButton = driver.findElement(By.xpath("//button[contains(text(),'Uncheck All')]"));
        uncheckButton.click();

        //10- Verify all orders are unselected.
        List<WebElement> allUncheckBoxes = driver.findElements(By.xpath("//input[@class='form-check-input']"));

        for (WebElement element : allUncheckBoxes) {
            Assertions.assertFalse(element.isSelected());
        }
    }
}
