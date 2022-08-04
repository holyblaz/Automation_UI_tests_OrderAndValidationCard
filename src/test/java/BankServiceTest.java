import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BankServiceTest {

    @BeforeEach
    void openBrowser() {
        open("http://localhost:9999/");
    }

    // Positive test
    @Test
    void shouldSendForm() {
        SelenideElement form = $(".form");
        form.$("[data-test-id = 'name'] input").setValue("Петров-Комаров Василий");
        form.$("[data-test-id = 'phone'] input").setValue("+79099864579");
        form.$("[data-test-id = 'agreement']").click();
        form.$("button").click();
        $("[data-test-id='order-success']").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldNoValidNameWithEmptyField() {
        SelenideElement form = $(".form");
        form.$("[data-test-id='phone'] input").setValue("+79099876325");
        form.$("[data-test-id='agreement']").click();
        form.$(".button").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldNotValidPhoneWithEmptyField() {
        SelenideElement form = $(".form");
        form.$("[data-test-id='name'] input").setValue("Иванов-Козлов Сергей");
        form.$("[data-test-id='agreement']").click();
        form.$(".button").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldNoTSendFormWithEmptyCheckbox() {
        SelenideElement form = $(".form");
        form.$("[data-test-id='name'] input").setValue("Иванов-Козлов Сергей");
        form.$("[data-test-id='phone'] input").setValue("+79099555545");
        form.$(".button").click();
        $("[data-test-id='agreement'].input_invalid").shouldBe(visible);
    }

    @Test
    void shouldNoValidNameWithNoValidData() {
        SelenideElement form = $(".form");
        form.$("[data-test-id='name'] input").setValue("+79099876532");
        form.$("[data-test-id='phone'] input").setValue("+79099876542");
        form.$("[data-test-id='agreement']").click();
        form.$(".button").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldNoTValidPhoneWithNoValidData() {
        SelenideElement form = $(".form");
        form.$("[data-test-id='name'] input").setValue("Иванов-Козлов Сергейн");
        form.$("[data-test-id='phone'] input").setValue("Иванов-Козлов Сергей");
        form.$("[data-test-id='agreement']").click();
        form.$(".button").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }
}
