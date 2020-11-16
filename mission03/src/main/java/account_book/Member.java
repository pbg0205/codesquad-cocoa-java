package account_book;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

class Member {
    private static final Pattern REGULAR_EXPRESSION_OF_PASSWORD
            = Pattern.compile("[ !@#$%^&*(),.?\":{}|<>]");

    private String id;
    private String password;
    private int balance;
    private RecordList recordList;

    public Member(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public Member(String id, String password, int balance) {
        this.id = id;
        this.password = password;
        this.balance = balance;
        this.recordList = new RecordList();
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public void loadRecordList(RecordList recordList){
        this.recordList = recordList;
        this.balance = this.recordList.calculateBalance(this.balance);
    }

    public boolean isAllValid() {
        if (hasNullOfId()) {
            return false;
        }

        if (!isPasswordType()) {
            return false;
        }

        return true;
    }

    public boolean hasNullOfId() {
        String id = this.id.trim();

        if (id.equals("") || id == null) {
            return true;
        }

        return false;
    }

    public boolean isPasswordType() {
        return REGULAR_EXPRESSION_OF_PASSWORD.matcher(this.password).find();
    }

    public void printRecords() {
        recordList.printRecords(this.balance);
    }

    public void insertRecord(Record record) {
        recordList.insertRecord(record);
        this.balance = calculateBalance();
    }

    public void modifyRecord(int index, Record record) {
        recordList.modifyRecord(index, record);
        this.balance = calculateBalance();
    }

    public void deleteRecord(int index) {
        recordList.deleteRecord(index);
        this.balance = calculateBalance();
    }

    public List<Integer> searchBy(UseDate useDate) {
        return recordList.searchByDate(useDate);
    }

    public List<Integer> searchBy(String value, int appCommand) {
        if(appCommand == 2){
            return recordList.searchByDetail(value);
        }

        if(appCommand == 4){
            return recordList.searchByPayType(value);
        }

        return null;
    }

    public List<Integer> searchBy(int money) {
        return recordList.searchByMoney(money);
    }

    public void printRecordsByIndex(List<Integer> searchList) {
        this.recordList.printRecordsOfIndex(searchList);
    }

    public int calculateBalance(){
        return recordList.calculateBalance(this.balance);
    }

    public StringBuilder getCsvRecords() {
        return this.recordList.getCsvRecords();
    }

    public boolean sameWith(Member member){
        return this.equals(member);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Member)) {
            return false;
        }

        Member other = (Member) o;

        return other.id.equals(this.id) &&
                other.password.equals((this.password));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.password);
    }
}
