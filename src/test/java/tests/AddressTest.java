package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import tests.data.AddressFieldType;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddressTest extends TestBase {

    @DisplayName("Проверка полей адресов с аннотацией EnumSource")
    @ParameterizedTest(name = "{index} - Проверка поля: {0}")
    @EnumSource(AddressFieldType.class)
    void testAddressFields(AddressFieldType addressField) {

        open("/text-box");
        $(addressField.selector).setValue(addressField.testValue);
        $("#submit").click();
        $("#output").shouldHave(
                Condition.text(addressField.fieldName + " :" + addressField.testValue)
        );
    }

    @DisplayName("Проверка полей адресов с аннотацией MethodSource")
    @ParameterizedTest(name = "{index} - Проверка поля: {0}")
    @MethodSource("methodSourceExampleTest")
    void testAddressFields2(String selector, String fieldName, String testValue) {

        open("/text-box");
        $(selector).setValue(testValue);
        $("#submit").click();
        $("#output").shouldHave(
                Condition.text(fieldName + " :" + testValue)
        );
    }
    static Stream<Arguments> methodSourceExampleTest() {
        return Stream.of(
                Arguments.of("#currentAddress", "Current Address",
                        "Москва, ул. Тверская 5"),
                Arguments.of("#permanentAddress", "Permananet Address",
                        "Санкт-Петербург, Невский пр. 10")
        );
    }
}
