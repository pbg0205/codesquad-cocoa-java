package domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Member {
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

    /*
     * about validation
     */
    public boolean isPasswordType() {
        return REGULAR_EXPRESSION_OF_PASSWORD.matcher(this.password).find();
    }

    public boolean sameWith(Member member) {
        return this.equals(member);
    }

    public boolean sameIdWith(String id) {
        return this.getId().equals(id);
    }

    /*
     * about access dao
     */
    public StringBuilder getCsvRecords() {
        return this.recordList.getCsvRecords();
    }

    public String[][] getRecordsAsArrayForm() {
        return this.recordList.makeRecordsAsArrayForm();
    }

    public void loadRecordList(RecordList recordList){
        this.recordList = recordList;
        this.balance = this.recordList.calculateBalance(this.balance);
    }

    /*
     * calculate balance
     */
    public int calculateBalance(){
        return recordList.calculateBalance(this.balance);
    }

    /*
     * Member`s Record CRUD
     */
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

    /*
     * equals and hashcode overriding
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Member)) {
            return false;
        }

        Member other = (Member) o;

        return (other.id.equals(this.id) &&
                other.password.equals(this.password));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.password);
    }
}
