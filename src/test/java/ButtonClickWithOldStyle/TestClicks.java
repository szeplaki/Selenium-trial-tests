package ButtonClickWithOldStyle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestClicks {

    private WebDriver driver;

    @BeforeAll
    public static void setProperty() {
        System.setProperty("webdriver.chrome.driver", "/home/szeplaki/Documents/ChromeDriver/chromedriver_linux64/chromedriver");

    }

    @BeforeEach
    public void openTab() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
    }

    @Test
    public void TestDoubleClick() {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(element).perform();

        String expected = "You have done a double click";
        String actual = driver.findElement(By.id("doubleClickMessage")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestRightClick() {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(element).perform();

        String expected = "You have done a right click";
        String actual = driver.findElement(By.id("rightClickMessage")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestSimpleClick() {
        WebElement clickButton = driver.findElement(By.xpath("//*[text()='Click Me']"));
        clickButton.click();

        String expected = "You have done a dynamic click";
        String actual = driver.findElement(By.id("dynamicClickMessage")).getText();

        Assertions.assertEquals(expected, actual);
    }
}
