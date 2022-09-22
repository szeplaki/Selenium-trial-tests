import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestCheckBox {

    private WebDriver driver;

    @BeforeAll
    public static void setProperty() {
        System.setProperty("webdriver.chrome.driver", "/home/szeplaki/Documents/ChromeDriver/chromedriver_linux64/chromedriver");

    }

    @BeforeEach
    public void openTab() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/checkbox");
        driver.manage().window().maximize();
    }
    @Test
    public void TestClickCheckBox() {

        WebElement checkbox = driver.findElement(By.id("tree-node-home"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("arguments[0].click()", checkbox);

        String expected = "You have selected :";
        String actual = driver.findElement(By.xpath("//*[@id=\"result\"]/span[1]")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestDropDown() {
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
        dropdown.click();

        String expected = "Desktop";
        String actual = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestIfHalfCheckIconAppears() {
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
        dropdown.click();


        WebElement checkbox = driver.findElement(By.id("tree-node-desktop"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("arguments[0].click()", checkbox);

        String excepted = "rct-icon rct-icon-half-check";
        WebElement element = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[1]"));
        List<WebElement> allChildElements = element.findElements(By.xpath("*"));
        System.out.println(allChildElements.stream().count());

        String icon = allChildElements.get(0).getAttribute("class");

        System.out.println(icon);

        Assertions.assertEquals(excepted, icon);

    }
}
