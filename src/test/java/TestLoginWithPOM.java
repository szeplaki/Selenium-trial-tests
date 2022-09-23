import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestLoginWithPOM {
    WebDriver driver;
    JavascriptExecutor executor;
    By firstNameField = By.id("firstName");
    By lastNameField = By.id("lastName");
    By emailField = By.id("userEmail");
    By userNumberField = By.id("userNumber");

    By uploadPicture = By.id("uploadPicture");
    By day = By.id("dateOfBirthInput");
    By subject = By.id("subjectsInput");
    By gender = By.xpath("(//input[@name='gender'])[2]");
    By sport = By.id("hobbies-checkbox-1");
    By reading = By.id("hobbies-checkbox-2");
    By music = By.id("hobbies-checkbox-3");
    By address = By.id("currentAddress");
    By state = By.xpath("//*[@id=\"react-select-3-input\"]");
    By city = By.xpath("//*[@id=\"react-select-4-input\"]");
    By submit = By.id("submit");

    public TestLoginWithPOM(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void setGender() {
        executor.executeScript("arguments[0].click()", driver.findElement(gender));
    }
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(userNumberField).sendKeys(phoneNumber);
    }
}
