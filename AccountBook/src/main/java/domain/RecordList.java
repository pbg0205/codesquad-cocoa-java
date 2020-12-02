package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RecordList {
    private List<Record> recordList;

    public RecordList() {
        this.recordList = new ArrayList<>();
    }

    /*
     * balance 구하기
     */
    private int getSumOfRecords() {
        return recordList.stream().mapToInt(Record::getMoney).sum();
    }

    int calculateBalance(int balance) {
        return balance + getSumOfRecords();
    }

    public void insertRecord(Record record) {
        this.recordList.add(record);
        sortByUseDate();
    }

    /*
     * Record 받아오기
     */
    StringBuilder getCsvRecords() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Record record : recordList) {
            stringBuilder.append(record.getCsvRecord());
        }

        return stringBuilder;
    }

    private void sortByUseDate() {
        this.recordList.sort(Comparator.comparing(Record::getUseDate));
    }


    /*
     * RecordList -> String[][] 변환
     */
    String[][] makeRecordsAsArrayForm() {
        int rowSize = getRecordsSize();
        int colSize = 5;

        String[][] recordsArr = new String[rowSize][colSize];

        return getRecordAsArray(recordsArr);
    }

    private int getRecordsSize() {
        return this.recordList.size();
    }

    private String[][] getRecordAsArray(String[][] recordsArr) {
        for (int row = 0; row < recordsArr.length; row++) {
            recordsArr[row] = insertEachRecord(row);
        }

        return recordsArr;
    }

    private String[] insertEachRecord(int row) {
        return recordList.get(row).getStringArrayForm();
    }
}
