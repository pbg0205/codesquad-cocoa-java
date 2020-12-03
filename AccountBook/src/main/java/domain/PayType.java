package domain;

public enum PayType {
    CARD("카드"),
    CASH("현금");

    private String value;

    PayType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
