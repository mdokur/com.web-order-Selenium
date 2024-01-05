import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

        /*
        1- Open the URL.
        2- Click "WebOrder" button on top bar.
        3- Enter valid username "Inar" and password "Academy".
        4- Click on the "Login" button.
        5- Navigate to the order page.
        6- Select "HomeDecor" from Product dropdown.
        7- Enter "5" as quantity number.
        8- Enter "15" as discount percentage.
        9- Click on the "Calculate" button.
        10- Verify that the total amount is successfully displayed.
        */

public class WO_004_CF_01 extends Hooks {

    @Test
    void verifyCalculateFunctionality() throws InterruptedException {

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

        //5- Navigate to the order page.
        WebElement orderLink = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        orderLink.click();

        //6- Select "HomeDecor" from Product dropdown.
        WebElement homeDecorDropDown = driver.findElement(By.id("productSelect"));
        Select productDropdown = new Select(homeDecorDropDown);
        productDropdown.selectByVisibleText("HomeDecor");

        //7- Enter "5" as quantity number.
        WebElement quantityNumberInput = driver.findElement(By.id("quantityInput"));
        quantityNumberInput.sendKeys("5");

        //8- Enter "15" as discount percentage.
        WebElement discountPercentageInput = driver.findElement(By.id("discountInput"));
        discountPercentageInput.sendKeys("15");

        //9- Click on the "Calculate" button.
        WebElement calculateButton = driver.findElement(By.xpath("//button[contains(text(),'Calculate')]"));
        calculateButton.click();

        //10- Verify that the total amount is successfully displayed.
        WebElement totalAmountDisplay = driver.findElement(By.id("totalInput"));
        String text = totalAmountDisplay.getAttribute("value");
        Assertions.assertEquals("638", text, "Total amount is not correctly displayed.");
    }
}
