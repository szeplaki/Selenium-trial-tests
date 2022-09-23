package LoginWithOldStyle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestLogin {

    @Test
    public void TestLogin() {
        System.setProperty("webdriver.chrome.driver", "/home/szeplaki/Documents/ChromeDriver/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement userNumberField = driver.findElement(By.id("userNumber"));

        WebElement uploadPicture = driver.findElement(By.id("uploadPicture"));
        WebElement day = driver.findElement(By.id("dateOfBirthInput"));


        firstNameField.sendKeys("Évi");
        lastNameField.sendKeys("Széplaki");
        email.sendKeys("szeplaki.eva1@gmail.com");
        userNumberField.sendKeys("0123456789");


        String query = "22 May 1982";
        day.click();  // beleklikkel a mezőbe


        Actions actions = new Actions(driver);  //kijelöli a szöveget
        actions.sendKeys(Keys.HOME).build().perform();

        actions.keyDown(Keys.LEFT_SHIFT);
        for (int i = 0; i < query.length(); i++){
            actions.sendKeys(Keys.ARROW_RIGHT);
        }
        actions.keyUp(Keys.LEFT_SHIFT);
        actions.build().perform();

        day.sendKeys(query); //beírja az új adatot
        day.sendKeys(Keys.ENTER);

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        WebElement subject = driver.findElement(By.id("subjectsInput"));
        jse.executeScript("arguments[0].click()", subject);
        subject.sendKeys("English");
        subject.sendKeys(Keys.ENTER);


        WebElement gender = driver.findElement(By.xpath("(//input[@name='gender'])[2]"));
        jse.executeScript("arguments[0].click()", gender);


        WebElement sport = driver.findElement(By.id("hobbies-checkbox-1"));
        jse.executeScript("arguments[0].click()", sport);

        WebElement reading = driver.findElement(By.id("hobbies-checkbox-2"));
        jse.executeScript("arguments[0].click()", reading);

        WebElement music = driver.findElement(By.id("hobbies-checkbox-3"));
        jse.executeScript("arguments[0].click()", music);

        uploadPicture.sendKeys("/home/szeplaki/Pictures/screenShot.png");

        WebElement address = driver.findElement(By.id("currentAddress"));
        address.sendKeys("Budapest");

        WebElement state = driver.findElement(By.xpath("//*[@id=\"react-select-3-input\"]"));
        state.sendKeys("Haryana");
        state.sendKeys(Keys.ENTER);


        WebElement city = driver.findElement(By.xpath("//*[@id=\"react-select-4-input\"]"));
        city.sendKeys("Karnal");
        city.sendKeys(Keys.ENTER);

        WebElement submit = driver.findElement(By.id("submit"));
        jse.executeScript("arguments[0].click()", submit);


//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        String element = wait.until(ExpectedConditions.elementToBeClickable(By.id("example-modal-sizes-title-lg"))).getText();
        String actual = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();

        String expected = "Thanks for submitting the form";
        Assertions.assertEquals(expected, actual);
    }
}