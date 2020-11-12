package account_book;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class CsvReader {
    private final String MEMBER_LIST_CSV_PATH = ".\\mission03\\src\\repository\\MemberList.csv";
    private final String DERECTORY_PATH = ".\\mission03\\src\\repository\\";

    private BufferedReader bufferedReader;
    private FileReader fileReader;

    MemberList getMemberListFromCsv() throws IOException {
        readMemberListFromCsv();
        return getMemberListFromReader();
    }

    private MemberList getMemberListFromReader() throws IOException {
        MemberList memberList = new MemberList();
        Member member;
        String line;

        while(true){
            line = this.bufferedReader.readLine();

            if(line == null){
                break;
            }

            member = getMemberFromLine(line);
            memberList.addMember(member);
        }
        return memberList;
    }

    private Member getMemberFromLine(String line) {
        String[] strings;
        String id;
        String password;
        int balance;

        strings = line.split(",");

        id = strings[0];
        password = strings[1];
        balance = toInt(strings[2]);

        return new Member(id, password, balance);
    }

    private int toInt(String value) {
        return Integer.parseInt(value);
    }

    private void readMemberListFromCsv() {
        try {
            this.fileReader = new FileReader(MEMBER_LIST_CSV_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.bufferedReader = new BufferedReader(fileReader);
    }


}
