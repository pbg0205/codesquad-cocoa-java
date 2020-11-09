package account_book;

import java.text.SimpleDateFormat;
import java.util.Calendar;

class Record {
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

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String dFormat = sf.format(this.calendar.getTime());

        return String.format("%10s %20s %10d",dFormat, detail, money);
    }
}
