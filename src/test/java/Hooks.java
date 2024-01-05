
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {


    /**
     * This class contains setup and teardown methods for WebDriver
     * initialization and cleanup.
     */
    protected static WebDriver driver;

    /**
     * Sets up the WebDriver instance based on the specified browser.
     *
     * @throws InterruptedException if there is an interruption during
     *                              the thread sleep.
     */
    @BeforeAll
    public static void setUpBeforeTest() throws InterruptedException {
        String browser = System.getProperty("browser", "chrome");
        // Default to Chrome if not specified
        switch (browser.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                driver = new ChromeDriver();
                break;
        // Add cases for other browsers if needed
        }
        driver.manage().window().maximize();
        driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");
        Thread.sleep(1000);
        if (browser.equalsIgnoreCase("firefox")) {

        //refresh the page to avoid the "404 Not Found" error
            driver.navigate().refresh();
            Thread.sleep(1000);
        }
    }

    /**
     * Cleans up the WebDriver instance after test execution.
     */
    @AfterAll
    public static void tearDownAfterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}

