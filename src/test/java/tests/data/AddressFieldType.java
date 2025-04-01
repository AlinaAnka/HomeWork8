package tests.data;

public enum AddressFieldType {
    CURRENT_ADDRESS(
            "#currentAddress",
            "Current Address",
            "Москва, ул. Тверская 5"
    ),
    PERMANENT_ADDRESS(
            "#permanentAddress",
            "Permananet Address",
            "Санкт-Петербург, Невский пр. 10"
    );

    public final String selector;
    public final String fieldName;
    public final String testValue;

    AddressFieldType(String selector, String fieldName, String testValue) {
        this.selector = selector;
        this.fieldName = fieldName;
        this.testValue = testValue;
    }
}
