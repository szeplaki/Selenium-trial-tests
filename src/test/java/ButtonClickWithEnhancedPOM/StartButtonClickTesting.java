package ButtonClickWithEnhancedPOM;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StartButtonClickTesting {
    WebDriver driver;
    static String driverPath = "/home/szeplaki/Documents/ChromeDriver/chromedriver_linux64/chromedriver";
    TestButtonClickWithPOM buttonClickWithPOM;

    @BeforeAll
    public static void setProperty() {
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @BeforeEach
    public void openTab() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
        buttonClickWithPOM = new TestButtonClickWithPOM(driver);
    }
    @Test
    @Order(1)
    public void testTheDoubleClick() {
        buttonClickWithPOM.testDoubleClick();
    }
    @Test
    @Order(2)
    public void testTheRightClick() {
        buttonClickWithPOM.testRightClick();
    }

    @Test
    @Order(3)
    public void testTheSimpleClick() {
        buttonClickWithPOM.testSimpleClick();
    }
    @AfterEach
    public void closeWindows() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
