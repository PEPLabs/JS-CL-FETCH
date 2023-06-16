import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();
        File file = new File("cat-facts.html");
        // Open the HTML file
        driver.get(file.getAbsolutePath());
    }
    @Test
    public void testCatFact() {
        WebElement content = driver.findElement(By.id("content"));

        // to start, assert that the content is "placeholder"
        assertEquals("placeholder", content.getText());

        WebElement buttonElement = driver.findElement(By.id("button"));
        // click the button:
        buttonElement.click();        

        // Wait for the text content to change
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(content, "placeholder")));



        

    }

    @Test
    public void initialState() {
        WebElement content = driver.findElement(By.id("content"));

        // to start, assert that the content is "placeholder"
        assertEquals("placeholder", content.getText());
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}