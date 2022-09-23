import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestLoginWithPOM {
    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;

    @FindBy(id = "firstName") WebElement firstNameField;
    @FindBy(id = "lastName") WebElement lastNameField;
    @FindBy(id = "userEmail") WebElement emailField;
    @FindBy(id = "userNumber") WebElement userNumberField;
    @FindBy(id = "uploadPicture") WebElement chooseFileButton;
    @FindBy(id = "dateOfBirthInput") WebElement day;
    @FindBy(id = "subjectsInput") WebElement subjectField;
    @FindBy(xpath = "(//input[@name='gender'])[2]") WebElement gender;
    @FindBy(id = "hobbies-checkbox-1") WebElement sport;
    @FindBy(id = "hobbies-checkbox-2") WebElement reading;
    @FindBy(id = "hobbies-checkbox-3") WebElement music;
    @FindBy(id = "currentAddress") WebElement addressField;
    @FindBy(xpath = "//*[@id=\"react-select-3-input\"]") WebElement stateField;
    @FindBy(xpath = "//*[@id=\"react-select-4-input\"]") WebElement cityField;
    @FindBy(id = "submit") WebElement submit;
    @FindBy(id = "example-modal-sizes-title-lg") WebElement successMessage;

    public TestLoginWithPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.executor = (JavascriptExecutor) this.driver;
    }

    public void setFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }
    public void setEmail(String email) {
        emailField.sendKeys(email);
    }
    public void setGender() {
        executor.executeScript("arguments[0].click()", gender);
    }
    public void setPhoneNumber(String phoneNumber) {
        userNumberField.sendKeys(phoneNumber);
    }
    public void setDate(String date) {
        day.click();

        actions = new Actions(driver);
        actions.sendKeys(Keys.HOME).build().perform();

        actions.keyDown(Keys.LEFT_SHIFT);
        for (int i = 0; i < date.length(); i++){
            actions.sendKeys(Keys.ARROW_RIGHT);
        }
        actions.keyUp(Keys.LEFT_SHIFT);
        actions.build().perform();

        day.sendKeys(date);
        day.sendKeys(Keys.ENTER);

    }
    public void setSubject(String subject) {
        executor.executeScript("arguments[0].click()", subjectField);
        subjectField.sendKeys(subject);
        subjectField.sendKeys(Keys.ENTER);
    }

    public void setSportAsHobby() {
        executor.executeScript("arguments[0].click()", sport);
    }
    public void setReadingAsHobby() {
        executor.executeScript("arguments[0].click()", reading);
    }
    public void setMusicAsHobby() {
        executor.executeScript("arguments[0].click()", music);
    }
    public void uploadFile(String route) {
        chooseFileButton.sendKeys(route);
    }
    public void setAddress(String address) {
        addressField.sendKeys(address);
    }
    public void setState(String state) {
        stateField.sendKeys(state);
        stateField.sendKeys(Keys.ENTER);
    }
    public void setCity(String city) {
        cityField.sendKeys(city);
        cityField.sendKeys(Keys.ENTER);
    }
    public void clickSubmit() {
        executor.executeScript("arguments[0].click()", submit);
    }
    public void checkSuccess() {
        Assertions.assertEquals("Thanks for submitting the form", successMessage.getText());
    }
}
