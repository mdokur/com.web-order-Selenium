/*
1- Open the URL.
2- Click "WebOrder" button on top bar.
3- Enter valid username "Inar" and password "Academy".
4- Click on the "Login" button.
5- Navigate to the order page.
6- Select "SportsEquipment" from Product dropdown.
7- Enter "1" as quantity number.
8- Enter "10" as discount percentage.
9- Click on the "Calculate" button.
10- Enter "Inar Academy" as Name.
11- Enter "1100 Congress Ave" as Street.
12- Enter "Austin" as City.
13- Enter "TX" State.
14- Enter "78701" as Zip Code(number).
15- Enter "4938220192845" as Card Number.
16- Enter "09/26" Expire Date(mm/yy format).
17- Click "Process"" button.
18- Verify the Card Type error message is displayed.
 */


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WO_009_OP_04 extends Hooks{

    @Test
    void verifyOrderPlacementWithoutCardType() throws InterruptedException {

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

        //6- Select "SportsEquipment" from Product dropdown.
        WebElement homeDecorDropDown = driver.findElement(By.id("productSelect"));
        Select productDropdown = new Select(homeDecorDropDown);
        productDropdown.selectByVisibleText("SportsEquipment");

        //7- Enter "8" as quantity number.
        WebElement quantityNumberInput = driver.findElement(By.id("quantityInput"));
        quantityNumberInput.sendKeys("1");

        //8- Enter "20" as discount percentage.
        WebElement discountPercentageInput = driver.findElement(By.id("discountInput"));
        discountPercentageInput.sendKeys("10");

        //9- Click on the "Calculate" button.
        WebElement calculateButton = driver.findElement(By.xpath("//button[contains(text(),'Calculate')]"));
        calculateButton.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,1000)");

        Thread.sleep(1000);

        //10- Enter "Inar Academy" as Name.
        WebElement nameInput = driver.findElement(By.id("name"));
        nameInput.sendKeys("Inar Academy");

        //11- Enter "1100 Congress Ave" as Street.
        WebElement streetInput = driver.findElement(By.id("street"));
        streetInput.sendKeys("1100 Congress Ave");

        //12- Enter "Austin" as City.
        WebElement cityInput = driver.findElement(By.id("city"));
        cityInput.sendKeys("Austin");

        //13- Enter "TX" State.
        WebElement stateInput = driver.findElement(By.id("state"));
        stateInput.sendKeys("TX");

        //14- Enter "78701" as Zip Code(number).
        WebElement zipCodeInput = driver.findElement(By.id("zip"));
        zipCodeInput.sendKeys("92@#83");


        //15- Enter "4938220192845" as Card Number.
        WebElement cardNumberInput = driver.findElement(By.id("cardNumber"));
        cardNumberInput.sendKeys("4938220192845");

        //16- Enter "09/26" Expire Date(mm/yy format).
        WebElement expireDateInput = driver.findElement(By.id("expiryDate"));
        expireDateInput.sendKeys("09/26");

        //17- Click "Process"" button.
        WebElement processButton = driver.findElement(By.xpath("//button[contains(text(),'Process')]"));
        processButton.click();

        Thread.sleep(5000);

        //18- Verify the Card Type error message is displayed.
        WebElement cardTypeMessage = driver.findElement(By.xpath("//em[contains(text(),'Card type cannot be empty')]"));
        String cardTypeText = cardTypeMessage.getText();
        String expectedText = "Card type cannot be empty";
        Assertions.assertEquals(expectedText, cardTypeText, "Card type message is not expected!");
    }
}
