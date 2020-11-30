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

    public void loadRecordList(RecordList recordList){
        this.recordList = recordList;
        this.balance = this.recordList.calculateBalance(this.balance);
    }

    public boolean sameWith(Member member) {
        return this.equals(member);
    }

    public StringBuilder getCsvRecords() {
        return this.recordList.getCsvRecords();
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

        return (other.id.equals(this.id) &&
                other.password.equals(this.password));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.password);
    }
}
