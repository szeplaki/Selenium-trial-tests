package RadioClickWithEnhancedPOM;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestRadioClickWithPOM {
    WebDriver driver;
    JavascriptExecutor executor;

    @FindBy(id = "yesRadio") WebElement yesRadio;
    @FindBy(id = "impressiveRadio") WebElement impressiveRadio;
    @FindBy(id = "noRadio") WebElement noRadio;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span") WebElement successTextField;

    public TestRadioClickWithPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        executor = (JavascriptExecutor) this.driver;
    }
    public void testClickYes() {
        executor.executeScript("arguments[0].click()", yesRadio);
        Assertions.assertEquals("Yes", successTextField.getText());
    }
    public void testClickImpressive() {
        executor.executeScript("arguments[0].click()", impressiveRadio);
        Assertions.assertEquals("Impressive", successTextField.getText());
    }
    public void testClickNo() {
        executor.executeScript("arguments[0].click()", noRadio);
        Assertions.assertEquals("true", noRadio.getAttribute("disabled"));
    }

    public void testClickNo2() {
        executor.executeScript("arguments[0].click()", noRadio);
        Assertions.assertTrue(driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span")).size() < 1);
    }
}
