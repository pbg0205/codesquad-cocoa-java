package game2048;

import java.util.Objects;

public class Number {
    private static final Number ZERO_INSTANCE = new Number(0);
    private static final int MAX_NUMBER = 2048;
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public static Number getZeroInstance(){
        return ZERO_INSTANCE;
    }

    public boolean is2048() {
        return this.number == MAX_NUMBER;
    }

    public void multiply() {
        this.number *= 2;
    }

    public int getNumber() {
        return number;
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
