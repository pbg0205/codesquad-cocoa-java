package domain;

import java.util.Comparator;
import java.util.Objects;

class UseDate implements Comparable<UseDate>{
    private static final String REGEULAR_REGEX_SPECIAL_CHARACTER = "[ ,.-]";
    private static final Comparator<UseDate> USE_DATE_COMPARATOR =
            Comparator.comparingInt((UseDate ud) -> -ud.year)
            .thenComparing(ud -> -ud.month)
            .thenComparing(ud -> -ud.date);

    private int year;
    private int month;
    private int date;

    public UseDate(String dateStr){
        initDate(dateStr);
    }

    private void initDate(String dateStr) {
        String[] dateSplited = dateStr.split(REGEULAR_REGEX_SPECIAL_CHARACTER);

        this.year = toInt(dateSplited[0]);
        this.month = toInt(dateSplited[1]);
        this.date = toInt(dateSplited[2]);
    }

    private int toInt(String value){
        return Integer.parseInt(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UseDate)){
            return false;
        }
        UseDate useDate = (UseDate) o;

        return year == useDate.year &&
                month == useDate.month &&
                date == useDate.date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, date);
    }

    @Override
    public int compareTo(UseDate other) {
        return USE_DATE_COMPARATOR.compare(this, other);
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d",year, month, date);
    }
}
