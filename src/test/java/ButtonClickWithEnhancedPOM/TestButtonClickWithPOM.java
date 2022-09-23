package ButtonClickWithEnhancedPOM;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestButtonClickWithPOM {
    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;

    @FindBy(id = "doubleClickBtn") WebElement doubleClickButton;
    @FindBy(id = "doubleClickMessage") WebElement doubleClickMessageHolder;
    @FindBy(id = "rightClickBtn") WebElement rightClickButton;
    @FindBy(id = "rightClickMessage") WebElement rightClickMessageHolder;
    @FindBy(xpath = "//*[text()='Click Me']") WebElement simpleButton;
    @FindBy(id = "dynamicClickMessage") WebElement simpleButtonMessage;

    public TestButtonClickWithPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.executor = (JavascriptExecutor) this.driver;
    }


    public void testDoubleClick() {
        actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();
        Assertions.assertEquals("You have done a double click", doubleClickMessageHolder.getText());
    }

    public void testRightClick() {
        actions = new Actions(driver);
        actions.contextClick(rightClickButton).perform();
        Assertions.assertEquals("You have done a right click", rightClickMessageHolder.getText());
    }

    public void testSimpleClick() {
        simpleButton.click();
        Assertions.assertEquals("You have done a dynamic click", simpleButtonMessage.getText());
    }

}
