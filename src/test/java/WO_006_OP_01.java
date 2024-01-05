/*
1- Open the URL.
2- Click "WebOrder" button on top bar.
3- Enter valid username "Inar" and password "Academy".
4- Click on the "Login" button.
5- Navigate to the order page.
6- Select "MyMoney" from Product dropdown.
7- Enter "8" as quantity number.
8- Enter "20" as discount percentage.
9- Click on the "Calculate" button.
10- Enter "Inar Academy" as Name.
11- Enter "1100 Congress Ave" as Street.
12- Enter "Austin" as City.
13- Enter "TX" State.
14- Enter "78701" as Zip Code(number).
15- Select "Visa" as Card Type.
16- Enter "4938281746192845" as Card Number.
17- Enter "11/28" Expire Date(mm/yy format).
18- Click "Process"" button.
19- Verify the confirmation message is displayed.
20- Navigate to view all orders page.
21- Verify the order is successfully placed.
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WO_006_OP_01 extends Hooks {

    @Test
    void verifyOrderPlacement() throws InterruptedException {

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

        //6- Select "MyMoney" from Product dropdown.
        WebElement homeDecorDropDown = driver.findElement(By.id("productSelect"));
        Select productDropdown = new Select(homeDecorDropDown);
        productDropdown.selectByVisibleText("MyMoney");

        //7- Enter "8" as quantity number.
        WebElement quantityNumberInput = driver.findElement(By.id("quantityInput"));
        quantityNumberInput.sendKeys("8");

        //8- Enter "20" as discount percentage.
        WebElement discountPercentageInput = driver.findElement(By.id("discountInput"));
        discountPercentageInput.sendKeys("20");

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
        zipCodeInput.sendKeys("78701");

        //15- Select "Visa" as Card Type.
        WebElement cardType = driver.findElement(By.id("visa"));
        cardType.click();

        //16- Enter "4938281746192845" as Card Number.
        WebElement cardNumberInput = driver.findElement(By.id("cardNumber"));
        cardNumberInput.sendKeys("4938281746192845");

        //17- Enter "11/28" Expire Date(mm/yy format).
        WebElement expireDateInput = driver.findElement(By.id("expiryDate"));
        expireDateInput.sendKeys("11/28");

        //18- Click "Process"" button.
        WebElement processButton = driver.findElement(By.xpath("//button[contains(text(),'Process')]"));
        processButton.click();

        Thread.sleep(5000);

        //19- Verify the confirmation message is displayed.
        WebElement confirmationMessage = driver.findElement(By.cssSelector("div[role='alert']"));
        String confirmationText = confirmationMessage.getText();
        String expectedText = "New order has been successfully added.";
        Assertions.assertEquals(expectedText, confirmationText, "Confirmation is not successful");

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scroll(0,-1000)");

        Thread.sleep(1000);

        //20- Navigate to view all orders page.
        WebElement allOrdersTab = driver.findElement(By.cssSelector("#view-orders-tab > a"));
        allOrdersTab.click();

        //21- Verify the order is successfully placed.
        List<WebElement> tableRows = driver.findElements(By.cssSelector("tbody > tr"));
        List<WebElement> columnValuesInLastRow = tableRows.get(tableRows.size() - 1).findElements(By.xpath("td"));

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dateFormat = today.format(formatter);

        ArrayList<String> orderList = new ArrayList<>(List.of("Inar Academy", "MyMoney", "8", dateFormat,
                "1100 Congress Ave", "Austin", "TX", "78701", "Visa", "4938281746192845", "11/28"));

        for (int i = 0; i < orderList.size(); i++) {
            String expectedValue = orderList.get(i);
            String actualValue = columnValuesInLastRow.get(i + 1).getText();

            Assertions.assertEquals(expectedValue, actualValue, "Wrong Order Information");
        }
    }
}