package domain;

public enum Category {
    TRANSFORTATION("교통"),
    FOOD("음식"),
    CULTURE("문화"),
    HEALTH("건강"),
    BEAUTY("미용"),
    ETC("기타");

    private String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
