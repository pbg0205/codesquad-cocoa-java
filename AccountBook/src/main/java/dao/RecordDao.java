package dao;

import domain.Member;
import domain.Record;
import domain.RecordList;

import java.io.*;

public class RecordDao {
    private static final String RECORDS_DIRECTORY_PATH = ".\\AccountBook\\src\\repository\\member_records\\";
    private final String memberRecordsPath;
    private final String csv = ".csv";

    private File file;

    public RecordDao(String memberId) {
        this.memberRecordsPath = RECORDS_DIRECTORY_PATH + memberId + this.csv;
    }


    public RecordList loadRecords() {
        RecordList recordList = new RecordList();
        Record record;
        String line;

        try (FileReader fileReader = new FileReader(memberRecordsPath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                record = parseMemberRecord(line);
                recordList.insertRecord(record);
            }
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return recordList;
    }

    /*
     * records CRUD
     */
    public void makeMemberCsvFile() {
        this.file = new File(memberRecordsPath);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveRecords(Member member) {
        StringBuilder stringBuilder = member.getCsvRecords();

        try(FileWriter fileWriter = new FileWriter(memberRecordsPath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            bufferedWriter.write(String.valueOf(stringBuilder));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * parser
     */
    private Record parseMemberRecord(String line) {
        String[] data = line.split(",");

        String useDateStr = data[0];
        String detail = data[1];
        int money = toInt(data[2]);
        String category = data[3];
        String payType = data[4];

        return new Record(useDateStr, detail, money, category, payType);
    }

    private int toInt(String value) {
        return Integer.parseInt(value);
    }
}
