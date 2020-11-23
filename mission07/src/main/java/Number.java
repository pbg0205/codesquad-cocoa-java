import java.util.Objects;

public class Number {
    private static final int MAX_NUMBER = 2048;
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public void multiply() {
        this.number *= 2;
    }

    public boolean isMaxNumber() {
        return this.number == MAX_NUMBER;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Number)){
            return false;
        }

        Number otherNumber = (Number) other;
        return this.number == otherNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
