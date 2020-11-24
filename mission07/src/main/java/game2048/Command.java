package game2048;

public enum Command {
    UP("w"), DOWN("s"), LEFT("a"), RIGHT("d");

    private String value;

    Command(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
