import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestRadio {
    private static WebDriver driver;
    private static JavascriptExecutor jse;


    @BeforeAll
    public static void setProperty() {
        System.setProperty("webdriver.chrome.driver", "/home/szeplaki/Documents/ChromeDriver/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        jse = (JavascriptExecutor)driver;
    }

    @Order(1)
    @Test
    public void TestClickYes() {
        WebElement yesRadio = driver.findElement(By.id("yesRadio"));
        jse.executeScript("arguments[0].click()", yesRadio);
        String excepted = "Yes";
        String actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span")).getText();
        Assertions.assertEquals(excepted, actual);
    }

    @Order(2)
    @Test
    public void TestClickImpressive() {
        WebElement impressiveRadio = driver.findElement(By.id("impressiveRadio"));
        jse.executeScript("arguments[0].click()", impressiveRadio);
        String excepted = "Impressive";
        String actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span")).getText();
        Assertions.assertEquals(excepted, actual);
    }

    @Order(3)
    @Test
    public void TestClickNo() {
        WebElement noRadio = driver.findElement(By.id("noRadio"));
        jse.executeScript("arguments[0].click()", noRadio);

        String excepted = "true";
        String actual = noRadio.getAttribute("disabled");
        Assertions.assertEquals(excepted, actual);
    }
}
