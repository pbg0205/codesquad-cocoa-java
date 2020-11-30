package domain;

public enum PayType {
    CARD("현금"), CASH("카드");

    private String value;

    PayType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
