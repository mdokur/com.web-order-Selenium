
/*
1- Open the URL.
2- Click "WebOrder" button on top bar.
3- Enter "Inar" as username and "Academy" password.
4- Click on the "Login" button.
5- Verify that the user is successfully logged in.
*/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WO_001_LP_01 extends Hooks {

    @Test
    void verifyLoginFunctionality() throws InterruptedException {
        // 2- Click "WebOrder" button on top bar.
        WebElement webOrderLink = driver.findElement(By.xpath("//header/nav[1]/div[1]/div[1]/a[1]"));
        webOrderLink.click();

        Thread.sleep(5000);

        // 3- Enter "Inar" as username and "Academy" password.
        WebElement userNameInput = driver.findElement(By.id("login-username-input"));
        WebElement passwordInput = driver.findElement(By.id("login-password-input"));

        userNameInput.sendKeys("Inar");
        passwordInput.sendKeys("Academy");

        //4- Click on the "Login" button.
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        Thread.sleep(5000);

        //5- Verify that the user is successfully logged in.
        WebElement heading = driver.findElement(By.id("welcome-heading"));
        String headingText = heading.getText();

        Assertions.assertEquals("Welcome, Inar!", headingText, "Heading text is unexpected!");

    }
}
