package account_book;

import java.io.*;

public class RecordDao {
    private static final String RECORED_DIRECTORY_PATH = ".\\mission03\\src\\repository\\records\\";
    private final String memberRecordsPath;
    private final String csv = ".csv";

    private BufferedReader bufferedReader;
    private FileReader fileReader;

    private File file;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;

    public RecordDao(String memberId) {
        this.memberRecordsPath = RECORED_DIRECTORY_PATH + memberId + this.csv;
    }

    public void makeMemberCsvFile() {
        this.file = new File(memberRecordsPath);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RecordList loadRecords() {
        RecordList recordList = new RecordList();
        Record record;
        String line;

        connectReaderFromCsv();

        while ((line = readLine()) != null) {
            record = parseMember(line);
            recordList.insertRecord(record);
        }

        return recordList;
    }

    /*
     * save RecordList of Member
     */
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

    private String readLine() {
        try {
            return this.bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
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
     * parser
     */
    private Record parseMember(String line) {
        String[] data = line.split(",");

        String useDateStr = data[0];
        String detail = data[1];
        int money = toInt(data[2]);
        String payType = data[3];

        return new Record(useDateStr, detail, money, payType);
    }

    private int toInt(String value) {
        return Integer.parseInt(value);
    }
}
