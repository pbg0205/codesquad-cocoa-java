package dao;

import domain.Member;
import domain.Record;
import domain.RecordList;

import java.io.*;

public class RecordDao {
    private static final String RECORDS_DIRECTORY_PATH = ".\\AccountBook\\src\\repository\\member_records\\";
    private final String memberRecordsPath;
    private final String csv = ".csv";

    private BufferedReader bufferedReader;
    private FileReader fileReader;

    private File file;

    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;

    public RecordDao(String memberId) {
        this.memberRecordsPath = RECORDS_DIRECTORY_PATH + memberId + this.csv;
    }

    /*
     * Reader Connection
     */
    private void connectReaderFromCsv() {
        initFileReader();
        initBufferedReader();
    }

    private void initFileReader() {
        try {
            this.fileReader = new FileReader(memberRecordsPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initBufferedReader() {
        this.bufferedReader = new BufferedReader(fileReader);
    }

    public RecordList loadRecords() {
        RecordList recordList = new RecordList();
        Record record;
        String line;

        connectReaderFromCsv();

        while ((line = readLine()) != null) {
            record = parseMemberRecord(line);
            recordList.insertRecord(record);
        }

        closeReaders();
        return recordList;
    }

    private String readLine() {
        try {
            return this.bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void closeReaders() {
        try {
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
     * Writer Connection
     */
    private void connectWriterFromCsv() {
        initFileWriter();
        initBufferedWriter();
    }

    private void initFileWriter() {
        try {
            this.fileWriter = new FileWriter(memberRecordsPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initBufferedWriter() {
        this.bufferedWriter = new BufferedWriter(fileWriter);
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

    public void saveRecords(Member member){
        StringBuilder stringBuilder;

        connectWriterFromCsv();
        stringBuilder = member.getCsvRecords();

        try {
            this.bufferedWriter.write(String.valueOf(stringBuilder));
            bufferedWriter.close();
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
