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
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MtsPartTwo {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String URL = "https://www.mts.by/";

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
    public void testPlaceholdersForAllServices() throws InterruptedException {
        driver.get(URL);

        // Принять куки
        acceptCookies();

        // Прокрутить страницу вниз
        scrollToBlock();

        // Проверить плейсхолдеры в полях формы "Услуги связи"
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='connection-phone']")));
        WebElement sumField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='connection-sum']")));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='connection-email']")));

        assertEquals("Номер телефона", phoneField.getAttribute("placeholder"));
        assertEquals("Сумма", sumField.getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", emailField.getAttribute("placeholder"));

        // Открыть аккордеон для выбора "Домашний интернет"
        WebElement accordionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
        accordionButton.click();

        // Выбрать "Домашний интернет"
        WebElement internetOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p")));
        internetOption.click();

        // Проверить плейсхолдеры в полях формы "Домашний интернет"
        WebElement internetPhoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='internet-phone']")));
        WebElement internetSumField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='internet-sum']")));
        WebElement internetEmailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='internet-email']")));

        assertEquals("Номер абонента", internetPhoneField.getAttribute("placeholder"));
        assertEquals("Сумма", internetSumField.getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", internetEmailField.getAttribute("placeholder"));

        // Открыть аккордеон для выбора "Рассрочка"
        accordionButton.click();

        // Выбрать "Рассрочка"
        WebElement instalmentOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p")));
        instalmentOption.click();

        // Проверить плейсхолдеры в полях формы "Рассрочка"
        WebElement instalmentPhoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='score-instalment']")));
        WebElement instalmentSumField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='instalment-sum']")));
        WebElement instalmentEmailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='instalment-email']")));

        assertEquals("Номер счета на 44", instalmentPhoneField.getAttribute("placeholder"));
        assertEquals("Сумма", instalmentSumField.getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", instalmentEmailField.getAttribute("placeholder"));

        // Открыть аккордеон для выбора "Задолженность"
        accordionButton.click();

        // Выбрать "Задолженность"
        WebElement arrearsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p")));
        arrearsOption.click();

        // Проверить плейсхолдеры в полях формы "Задолженность"
        WebElement arrearsPhoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='score-arrears']")));
        WebElement arrearsSumField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='arrears-sum']")));
        WebElement arrearsEmailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='arrears-email']")));

        assertEquals("Номер счета на 2073", arrearsPhoneField.getAttribute("placeholder"));
        assertEquals("Сумма", arrearsSumField.getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", arrearsEmailField.getAttribute("placeholder"));
    }
    @Test
    public void testFillConnectionServicesFormAndVerifyDetails() {
        driver.get(URL);
        acceptCookies();
        scrollToBlock();

        // Заполняем поля в услугах связи
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#connection-phone")));
        phoneInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.cssSelector("#connection-sum"));
        sumInput.sendKeys("100");

        WebElement emailInput = driver.findElement(By.cssSelector("#connection-email"));
        emailInput.sendKeys("mrukropus@gmail.com");

        // Нажимаем кнопку "Продолжить"
        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection > button"));
        continueButton.click();

        // Переключаемся на iframe, если он есть
        WebElement iframeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe.bepaid-iframe")));
        driver.switchTo().frame(iframeElement);

        // Проверяем корректность отображения суммы
        WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.pay-description__cost span")));
        assertEquals("100.00 BYN", amountElement.getText());

        // Проверяем сумму на кнопке оплаты
        WebElement payButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button")));
        assertTrue(payButton.getText().contains("Оплатить 100.00 BYN"));

        // Проверяем номер телефона
        WebElement phoneNumberLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > div > div.pay-description__text > span")));
        assertEquals("Оплата: Услуги связи Номер:375297777777", phoneNumberLabel.getText());

        // Проверяем плейсхолдеры в полях для реквизитов карты
        WebElement cardNumberPlaceholder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(1) > app-input > div > div > div.content.ng-tns-c46-1 > label")));
        assertEquals("Номер карты", cardNumberPlaceholder.getText());

        WebElement expiryDatePlaceholder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(2) > div.expires-input.ng-tns-c61-0.ng-star-inserted > app-input > div > div > div.content.ng-tns-c46-4 > label")));
        assertEquals("Срок действия", expiryDatePlaceholder.getText());

        WebElement cvcPlaceholder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(2) > div.cvc-input.ng-tns-c61-0.ng-star-inserted > app-input > div > div > div.content.ng-tns-c46-5 > label")));
        assertEquals("CVC", cvcPlaceholder.getText());

        WebElement cardholderNamePlaceholder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(3) > app-input > div > div > div.content.ng-tns-c46-3 > label")));
        assertEquals("Имя держателя (как на карте)", cardholderNamePlaceholder.getText());

        // Проверяем логотипы платежных сервисов
        WebElement paymentIconsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(1) > app-input > div > div > div.icons-container.ng-tns-c46-1")));
        List<WebElement> paymentIcons = paymentIconsContainer.findElements(By.tagName("img"));
        assertEquals(5, paymentIcons.size());  // Предполагаем, что должно быть 5 логотипов

    }
}