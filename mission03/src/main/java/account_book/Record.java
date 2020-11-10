package account_book;

import java.text.SimpleDateFormat;
import java.util.Calendar;

class Record {
    private static final String REGULAR_ExPRESSION_OF_NUMBER = "";//TODO 정규식

    private Calendar calendar;
    private String detail;
    private int money;

    public Record(String dateStr, String detail, int money) {
        this.calendar = initDate(dateStr);//TODO 입력에 맞는 date 입력되도록 하기
        this.detail = detail;
        this.money = money;
    }

    private Calendar initDate(String dateStr){
        final String REGEULAR_REGEX_SPECIAL_CHARACTER= "[ ,.-]";

        String[] date_str = dateStr.split(REGEULAR_REGEX_SPECIAL_CHARACTER);
        Calendar calendar = Calendar.getInstance();

        int year = Integer.parseInt(date_str[0]);
        int month = Integer.parseInt(date_str[1]);
        int date = Integer.parseInt(date_str[2]);

        calendar.set(year, month, date);

        return calendar;
    }

    public int getMoney() {
        return money;
    }

    //TODO 날짜에 대한 validation method로 분리하기
    //TODO 숫자에 대한 validation method로 생성해서 입력하기

    @Override
    public String toString() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String dFormat = sf.format(this.calendar.getTime());

        return String.format("%25s %20s %20d",dFormat, detail, money);
    }
}
