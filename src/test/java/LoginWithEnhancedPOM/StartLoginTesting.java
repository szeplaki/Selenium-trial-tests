package LoginWithEnhancedPOM;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StartLoginTesting {
    WebDriver driver;
    static String driverPath = "/home/szeplaki/Documents/ChromeDriver/chromedriver_linux64/chromedriver";
    TestLoginWithPOM loginWithPOM;


    @BeforeAll
    public static void setProperty() {
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @BeforeEach
    public void openTab() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
    }
    @Test
    public void testingMyFirstPom() {
        loginWithPOM = new TestLoginWithPOM(driver);
        loginWithPOM.setFirstName("Eva");
        loginWithPOM.setLastName("Szeplaki");
        loginWithPOM.setEmail("szeplaki.eva1@gmail.com");
        loginWithPOM.setGender();
        loginWithPOM.setPhoneNumber("0123456789");
        loginWithPOM.setDate("22 May 1982");
        loginWithPOM.setSubject("English");
        loginWithPOM.setSubject("Chemistry");
        loginWithPOM.setSubject("Computer Science");
        loginWithPOM.setSportAsHobby();
        loginWithPOM.setReadingAsHobby();
        loginWithPOM.setMusicAsHobby();
        loginWithPOM.uploadFile("/home/szeplaki/Pictures/screenShot.png");
        loginWithPOM.setAddress("Budapest, Hölgy utca 35. Fsz. 5.");
        loginWithPOM.setState("Haryana");
        loginWithPOM.setCity("Karnal");
        loginWithPOM.clickSubmit();
        loginWithPOM.checkSuccess();
    }

    @AfterEach
    public void closeWindows() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
