/*
1- Open the URL
2- Click "WebOrder" button on top bar.
3- Enter valid username "Inar" and password "Academy".
4- Click on the "Login" button.
5- Navigate to the view all order page.
6- Click "Add More Data" "8" times.
7- Click 1st, 3rd and 5th order checkbox.
8- Click "Delete All" button.
9- Verify the orders are deleted.
 */


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WO_012_VAO_03 extends Hooks {

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

        //6- Click "Add More Data" "8" times.
        WebElement moreDateButton = driver.findElement(By.xpath("//button[contains(text(),'Add More Data')]"));
        for (int i = 0; i < 8; i++) {
            moreDateButton.click();
        }
        List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//input[@class='form-check-input']"));

        //7- Click 1st, 3rd and 5th order checkbox.
        WebElement firstCheckbox = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/input[1]"));
        WebElement thirdCheckbox = driver.findElement(By.xpath("//tbody/tr[3]/td[1]/div[1]/input[1]"));
        WebElement fifthCheckbox = driver.findElement(By.xpath("//tbody/tr[5]/td[1]/div[1]/input[1]"));

        firstCheckbox.click();
        thirdCheckbox.click();
        fifthCheckbox.click();

        Thread.sleep(5000);

        //8- Click "Delete All" button.
        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
        deleteButton.click();

        Thread.sleep(5000);

        List<WebElement> remainingCheckBoxes = driver.findElements(By.xpath("//input[@class='form-check-input']"));

        //9- Verify the orders are deleted.
        Assertions.assertEquals(allCheckBoxes.size() - 3, remainingCheckBoxes.size(), "Remaining order list is unexpected.");
    }
}
