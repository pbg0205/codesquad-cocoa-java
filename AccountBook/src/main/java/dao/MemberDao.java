package dao;

import domain.Member;
import domain.RecordList;

import java.io.*;

public class MemberDao {
    private static final String MEMBER_LIST_PATH = ".\\AccountBook\\src\\repository\\MemberDB.csv";

    private BufferedReader bufferedReader;
    private FileReader fileReader;

    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;

    /*
     * login Member
     */
    public boolean hasMember(Member member) {
        Member memberInCsv;
        String line = "";

        connectReaderFromCsv();

        while ((line = readLine()) != null) {
            memberInCsv = parseMember(line);

            if (memberInCsv.sameWith(member)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasSameId(Member member) {
        Member memberInCsv;
        String line = "";

        connectReaderFromCsv();

        while ((line = readLine()) != null) {
            memberInCsv = parseMember(line);

            if (memberInCsv.sameIdWith(member.getId())) {
                return true;
            }
        }
        return false;
    }

    public Member getMemberData(Member member) {
        Member memberInCsv;
        String line = "";

        connectReaderFromCsv();

        while ((line = readLine()) != null) {
            memberInCsv = parseMember(line);

            if (memberInCsv.sameWith(member)) {
                memberInCsv = getMemberRecords(memberInCsv);
                return memberInCsv;
            }
        }
        return null;
    }

    private Member getMemberRecords(Member member) {
        String memberId = member.getId();
        RecordList recordList;

        recordList = new RecordDao(memberId).loadRecords();
        member.loadRecordList(recordList);

        return member;
    }

    /*
     * add Member
     */
    public void addMember(Member member) {
        String memberId = member.getId();
        StringBuilder stringBuilder;
        RecordDao recordDao = new RecordDao(memberId);

        connectWriterFromCsv();
        stringBuilder = getMemberInfo(member);
        addMemberToCsv(stringBuilder);

        recordDao.makeMemberCsvFile();

        try {
            this.bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private StringBuilder getMemberInfo(Member member) {
        StringBuilder memberInfo = new StringBuilder();

        memberInfo.append(member.getId() + ",");
        memberInfo.append(member.getPassword() + ",");
        memberInfo.append(member.getBalance() + "\n");

        return memberInfo;
    }

    private void addMemberToCsv(StringBuilder memberInfo) {
        try {
            this.bufferedWriter.write(String.valueOf(memberInfo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * readerConnection
     */
    private void connectReaderFromCsv() {
        initFileReader();
        initBufferedReader();
    }

    private void initFileReader() {
        try {
            this.fileReader = new FileReader(MEMBER_LIST_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initBufferedReader() {
        this.bufferedReader = new BufferedReader(fileReader);
    }

    private String readLine() {
        try {
            return this.bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * writerConnection
     */
    private void connectWriterFromCsv() {
        initFileWriter();
        initBufferedWriter();
    }

    private void initFileWriter() {
        try {
            this.fileWriter = new FileWriter(MEMBER_LIST_PATH, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initBufferedWriter() {
        this.bufferedWriter = new BufferedWriter(this.fileWriter);
    }

    /*
     * parser
     */
    private Member parseMember(String line) {
        String[] data = line.split(",");

        if(data.length == 0){
            return null;
        }

        String id = data[0].trim();
        String pw = data[1].trim();

        if (data.length >= 3) {
            int balance = Integer.parseInt(data[2].trim());
            return new Member(id, pw, balance);
        }
        return new Member(id, pw);
    }
}
