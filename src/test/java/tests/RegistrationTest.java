package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationTest extends TestBase {


    @ParameterizedTest(name = "Тест #{index}: Имя: {0}, Email: {1}, ")
    @CsvSource({
            "Иван, ivan@test.com, Ленина 1, Пушкина 2",
            "Alina, alina@mail.ru, moscow55, piter77",
    })
    @DisplayName("Проверка текстового поля с разными комбинациями данных")
    void testTextBoxWithDifferentData(String name, String email, String currentAddress,
                                      String permanentAddress) {
        open("/text-box");
        $("#userName").setValue(name);
        $("#userEmail").setValue(email).pressEnter();
        $("#currentAddress").setValue(currentAddress).pressEnter();
        $("#permanentAddress").setValue(permanentAddress).pressEnter();
        $("#submit").click();

        $("#output").shouldHave(Condition.text(name));
        $("#output").shouldHave(Condition.text(email));
        $("#output").shouldHave(Condition.text(currentAddress));
        $("#output").shouldHave(Condition.text(permanentAddress));
    }
}



