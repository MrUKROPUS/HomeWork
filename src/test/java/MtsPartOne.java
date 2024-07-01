import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MtsPartOne {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String URL = "https://www.mts.by/";
    private static final String EXPECTED_URL = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().driverVersion("126.0.6478.127").setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void acceptCookies() {
        WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cookie-agree']")));
        acceptCookiesButton.click();
    }

    private void scrollToBlock() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1800);");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pay-section']")));
    }

    @Test
    public void testXPathElement() {
        driver.get(URL);
        acceptCookies();
        scrollToBlock();

        WebElement blockElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/h2")));
        String blockText = blockElement.getText().trim();
        System.out.println("Блок с текстом: " + blockText);

        String[] lines = blockText.split("\n");
        assertEquals("Онлайн пополнение", lines[0].trim());
        assertEquals("без комиссии", lines[1].trim());
    }

    @Test
    public void testPaymentLogos() {
        driver.get(URL);
        acceptCookies();
        scrollToBlock();

        for (int i = 1; i <= 5; i++) {
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[" + i + "]/img")));
            assertEquals(true, logo.isDisplayed());
        }
    }

    @Test
    public void testMoreInfoLink() {
        driver.get(URL);
        acceptCookies();
        scrollToBlock();

        WebElement moreInfoLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/a")));
        moreInfoLink.click();

        wait.until(ExpectedConditions.urlToBe(EXPECTED_URL));
        assertEquals(EXPECTED_URL, driver.getCurrentUrl());
    }

    @Test
    public void testFillFormAndSubmit() {
        driver.get(URL);
        acceptCookies();
        scrollToBlock();

        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='connection-phone']")));
        WebElement sumField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='connection-sum']")));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='connection-email']")));
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-connection']/button")));

        phoneField.sendKeys("297777777");
        sumField.sendKeys("100");
        emailField.sendKeys("mrukropus@gmail.com");
        continueButton.click();

    }
}
