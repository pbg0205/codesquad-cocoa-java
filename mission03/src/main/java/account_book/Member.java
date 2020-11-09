package account_book;

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
