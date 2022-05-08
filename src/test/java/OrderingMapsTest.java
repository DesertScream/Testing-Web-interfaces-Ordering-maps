
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
public class OrderingMapsTest {

    @BeforeEach
    void setUp2() {
        open("http://localhost:9999");

    }

    @Test
    void shouldSuccessfully() {

        Configuration.holdBrowserOpen = false;

        $x("//*[@name=\"name\"]").setValue("Антон");
        $x("//*[@name=\"phone\"]").setValue("+79060000000");
        $x("//*[@data-test-id=\"agreement\"]").click();
        $x("//*[@type=\"button\"]").click();
        $(withText("Ваша заявка успешно отправлена!")).shouldHave(visible);
    }

    @Test
    void shouldNotCorrectName1() {

        Configuration.holdBrowserOpen = false;

        $x("//*[@data-test-id=\"agreement\"]").click();
        $x("//*[@name=\"name\"]").setValue("Anton Dz");
        $x("//*[@name=\"phone\"]").setValue("+79060000000");
        $x("//*[@type=\"button\"]").click();
        $(withText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."))
                .shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldBeVoidArea1() {

        Configuration.holdBrowserOpen = false;

        $x("//*[@data-test-id=\"agreement\"]").click();
        $x("//*[@name=\"name\"]").setValue("");
        $x("//*[@name=\"phone\"]").setValue("+79060000000");
        $x("//*[@type=\"button\"]").click();
        $(withText("Поле обязательно для заполнения")).shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldNotCorrectName2() {

        Configuration.holdBrowserOpen = false;

        $x("//*[@data-test-id=\"agreement\"]").click();
        $x("//*[@name=\"name\"]").setValue("Антон");
        $x("//*[@name=\"phone\"]").setValue("qwerty");
        $x("//*[@type=\"button\"]").click();
        $(withText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."))
                .shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }
    @Test
    void shouldBeVoidArea2() {

        Configuration.holdBrowserOpen = false;

        $x("//*[@data-test-id=\"agreement\"]").click();
        $x("//*[@name=\"name\"]").setValue("Антон");
        $x("//*[@name=\"phone\"]").setValue("");
        $x("//*[@type=\"button\"]").click();
        $(withText("Поле обязательно для заполнения"))
                .shouldHave(exactText("Поле обязательно для заполнения"));
    }
}
