package CheckboxWithEnhancedPOM;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StartCheckboxTesting {
    WebDriver driver;
    static String driverPath = "/home/szeplaki/Documents/ChromeDriver/chromedriver_linux64/chromedriver";
    TestCheckboxWithPOM checkboxWithPOM;

    @BeforeAll
    public static void setProperty() {
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @BeforeEach
    public void openTab() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/checkbox");
        driver.manage().window().maximize();
        checkboxWithPOM = new TestCheckboxWithPOM(driver);
    }
    @Test
    @Order(1)
    public void testClickFirstCheckBox() {
        checkboxWithPOM.testClickCheckBox();

    }
    @Test
    @Order(2)
    public void testTheDropdown() {
        checkboxWithPOM.testDropdown();
    }
    @Test
    @Order(3)
    public void testHalfCheckIcon() {
        checkboxWithPOM.testIfHalfCheckIconAppears();
    }
}
