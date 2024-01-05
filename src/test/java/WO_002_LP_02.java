
/*
1- Open the URL.
2- Click "WebOrder" button on top bar.
3- Enter invalid username "InvalidUserName" and/or password "InvalidPassword".
4- Click on the "Login" button
5- Verify that the appropriate error message is displayed.
 */


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WO_002_LP_02 extends Hooks {

    @Test
    void verifyLoginFailure() throws InterruptedException {
        //2- Click "WebOrder" button on top bar.
        WebElement webOrderLink = driver.findElement(By.xpath("//header/nav[1]/div[1]/div[1]/a[1]"));
        webOrderLink.click();

        Thread.sleep(5000);

        //3- Enter invalid username "InvalidUserName" and/or password "InvalidPassword".
        WebElement usernameInput = driver.findElement(By.id("login-username-input"));
        WebElement passwordInput = driver.findElement(By.id("login-password-input"));

        usernameInput.sendKeys("Denis");
        passwordInput.sendKeys("1996111");

        //4- Click on the "Login" button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        Thread.sleep(5000);

        //5- Verify that the appropriate error message is displayed.
        WebElement usernameAlert = driver.findElement(By.id("username-error-alert"));
        String alertText = usernameAlert.getText();

        Assertions.assertEquals("Invalid username", alertText, "Unexpected username.");
    }
}
