import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderingMapsTest {

    private WebDriver driver;

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    }
    @BeforeEach
    void setUp2() {
        driver = new ChromeDriver();
    }
    @AfterEach
    public void close() {
        driver.quit();
        driver = null;
    }



}
