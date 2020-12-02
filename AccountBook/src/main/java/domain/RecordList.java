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
        int colSize = 6;

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

    /*
     * RecordList CRUD
     */
    private String[] insertEachRecord(int row) {
        int colSize = 6;
        String[] strArr_tmp = recordList.get(row).getStringArrayForm();
        String[] eachRecord = new String[colSize];

        for (int index = 0; index < colSize; index++) {
            if(index == 0){
                eachRecord[0] = String.valueOf(row);
                continue;
            }
            eachRecord[index] = strArr_tmp[index - 1];
        }

        return eachRecord;
    }

    public void modifyRecord(int index, Record record) {
        if(index >= recordList.size() || index < 0){
            return ;
        }

        this.recordList.remove(index);
        this.recordList.add(record);
        sortByUseDate();
    }

    public void deleteRecord(int index) {
        this.recordList.remove(index);
        sortByUseDate();
    }
}
