
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
public class OrderingMapsTest {

    @BeforeEach
    void setUp2() {
        open("http://localhost:9999");

    }

    @Test
    void shouldSuccessfully() {

        Configuration.holdBrowserOpen = true;

        $x("//*[@name=\"name\"]").setValue("Антон");
//        $("[name=\"name\"]").setValue("Антон");
        $x("//*[@name=\"phone\"]").setValue("+79060000000");
//        $("[name=\"phone\"]").setValue("+79060000000");
        $x("//*[@data-test-id=\"agreement\"]").click();
        $x("//*[@type=\"button\"]").click();
        $(withText("Ваша заявка успешно отправлена!")).shouldHave(visible);
    }
}
