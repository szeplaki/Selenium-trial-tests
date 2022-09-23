package CheckboxWithEnhancedPOM;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestCheckboxWithPOM {
    WebDriver driver;
    JavascriptExecutor executor;

    @FindBy(id = "tree-node-home") WebElement checkboxHome;
    @FindBy(xpath = "//*[@id=\"result\"]/span[1]") WebElement actualText;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/button") WebElement dropdown;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label") WebElement dropdownText;
    @FindBy(id = "tree-node-desktop") WebElement checkboxDesktop;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/label/span[1]/*") List<WebElement> checkboxField;

    public TestCheckboxWithPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.executor = (JavascriptExecutor) this.driver;
    }

    public void testClickCheckBox() {
        executor.executeScript("arguments[0].click()", checkboxHome);
        Assertions.assertEquals("You have selected :", actualText.getText());
    }

    public void testDropdown() {
        dropdown.click();
        Assertions.assertEquals("Desktop", dropdownText.getText());
    }

    public void testIfHalfCheckIconAppears() {
        dropdown.click();
        executor.executeScript("arguments[0].click()", checkboxDesktop);
        Assertions.assertEquals("rct-icon rct-icon-half-check", checkboxField.get(0).getAttribute("class"));
    }
}
