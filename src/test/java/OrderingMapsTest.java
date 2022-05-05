import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.SelenideElementDescriber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Condition.exactText;
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
    }

    @AfterEach
    public void close() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldSuccessfully() {
        open("http://localhost:9999");
        SelenideElement form = $x("//form");
//        SelenideElement form = $("[data-test-id=callback-form]");
        form.$("[data-test-id=name] input").setValue("Антон");
        form.$("[data-test-id=phone] input").setValue("+79060000000");
        form.$("[data-test-id=agreement]").click();
        form.$("[data-test-id=submit]").click();
        $(".alert-success").shouldHave(exactText("Ваша заявка успешно отправлена!"));
    }
}
