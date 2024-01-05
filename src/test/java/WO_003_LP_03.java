/*
1- Open the URL
2- Click "WebOrder" button on top bar.
3- Enter valid username "Inar" and password "Academy".
4- Click on the "Login" button.
5- Click "Logout" button.
6- Verify logout successfully.
 */


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WO_003_LP_03 extends Hooks {

    @Test
    void verifyLogoutFunctionality() throws InterruptedException {

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

        //5- Click "Logout" button.
        WebElement logoutButtonLink = driver.findElement(By.id("logout-button"));
        logoutButtonLink.click();

        //6- Verify logout successfully.
        WebElement loginText = driver.findElement(By.xpath("//h2[contains(text(),'Login')]"));
        String loginPage = loginText.getText();

        Assertions.assertEquals("Login", loginPage, "Unexpected logout");
    }
}
