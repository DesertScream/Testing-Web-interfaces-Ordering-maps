import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.SelenideElementDescriber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class OrderingMapsTest {

    private WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    }

    @BeforeEach
    void setUp2() {

        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

    }

    @AfterEach
    public void close() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldSuccessfully() {
        open("http://localhost:9999");
        $x("//*[@name=\"name\"]").setValue("Антон");
//        $("[name=\"name\"]").setValue("Антон");
        $x("//*[@name=\"phone\"]").setValue("+79060000000");
//        $("[name=\"phone\"]").setValue("+79060000000");
        $x("//*[@data-test-id=\"agreement\"]").click();
        $x("//*[@type=\"button\"]").click();
        $(withText("Ваша заявка успешно отправлена!")).shouldHave(visible);
    }
}
