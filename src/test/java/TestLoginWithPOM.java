import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class TestLoginWithPOM {
    WebDriver driver;
    JavascriptExecutor executor;

    Actions actions;

    By firstNameField = By.id("firstName");
    By lastNameField = By.id("lastName");
    By emailField = By.id("userEmail");
    By userNumberField = By.id("userNumber");

    By chooseFileButton = By.id("uploadPicture");
    By day = By.id("dateOfBirthInput");
    By subjectField = By.id("subjectsInput");
    By gender = By.xpath("(//input[@name='gender'])[2]");
    By sport = By.id("hobbies-checkbox-1");
    By reading = By.id("hobbies-checkbox-2");
    By music = By.id("hobbies-checkbox-3");
    By addressField = By.id("currentAddress");
    By stateField = By.xpath("//*[@id=\"react-select-3-input\"]");
    By cityField = By.xpath("//*[@id=\"react-select-4-input\"]");
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
    public void setDate(String date) {
        driver.findElement(day).click();

        actions = new Actions(driver);
        actions.sendKeys(Keys.HOME).build().perform();

        actions.keyDown(Keys.LEFT_SHIFT);
        for (int i = 0; i < date.length(); i++){
            actions.sendKeys(Keys.ARROW_RIGHT);
        }
        actions.keyUp(Keys.LEFT_SHIFT);
        actions.build().perform();

        driver.findElement(day).sendKeys(date);
        driver.findElement(day).sendKeys(Keys.ENTER);

    }
    public void setSubject(String subject) {
        executor.executeScript("arguments[0].click()", driver.findElement(subjectField));
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(subjectField).sendKeys(Keys.ENTER);
    }

    public void setSportAsHobby() {
        executor.executeScript("arguments[0].click()", driver.findElement(sport));
    }
    public void setReadingAsHobby() {
        executor.executeScript("arguments[0].click()", driver.findElement(reading));
    }
    public void setMusicAsHobby() {
        executor.executeScript("arguments[0].click()", driver.findElement(music));
    }
    public void uploadFile(String route) {
        driver.findElement(chooseFileButton).sendKeys(route);
    }
    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    public void setState(String state) {
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(stateField).sendKeys(Keys.ENTER);
    }
    public void setCity(String city) {
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(cityField).sendKeys(Keys.ENTER);
    }
}
