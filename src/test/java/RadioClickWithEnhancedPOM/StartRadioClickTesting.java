package RadioClickWithEnhancedPOM;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StartRadioClickTesting {
    WebDriver driver;
    static String driverPath = "/home/szeplaki/Documents/ChromeDriver/chromedriver_linux64/chromedriver";
    TestRadioClickWithPOM radioClickWithPOM;

    @BeforeAll
    public static void setProperty() {
        System.setProperty("webdriver.chrome.driver", driverPath);
    }
    @BeforeEach
    public void openTab() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        radioClickWithPOM = new TestRadioClickWithPOM(driver);
    }
    @Test
    @Order(1)
    public void testTheYesClick() {
        radioClickWithPOM.testClickYes();
    }

    @Test
    @Order(2)
    public void testTheImpressiveClick() {
        radioClickWithPOM.testClickImpressive();
    }

    @Test
    @Order(3)
    public void testTheNoClick() {
        radioClickWithPOM.testClickNo2();
    }

    @AfterEach
    public void closeWindows() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
