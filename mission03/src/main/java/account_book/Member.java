package account_book;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

class Member {
    private static final Pattern REGULAR_EXPRESSION_OF_PASSWORD
            = Pattern.compile("[ !@#$%^&*(),.?\":{}|<>]");

    private String id;
    private String password;
    private RecordList recordList;

    public Member(String id, String password) {
        this.id = id;
        this.password = password;
        this.recordList = new RecordList();
    }

    public String getId() {
        return id;
    }

    public boolean AllValidation() {
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

        if (this.id.equals("") || this.id == null) {
            return true;
        }

        return false;
    }

    public boolean isPasswordType() {
        if (REGULAR_EXPRESSION_OF_PASSWORD.matcher(this.password).find()) {
            return true;
        }
        return false;
    }

    public void printRecords() {
        recordList.printRecords();
    }

    public void insertRecord(Record record) {
        recordList.insertRecord(record);
    }

    public void modifyRecord(int index, Record record) {
        recordList.modifyRecord(index, record);
    }

    public void deleteRecord(int index) {
        recordList.deleteRecord(index);
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
