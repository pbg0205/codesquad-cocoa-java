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

    public int calculateBalance(int balance) {
        return balance + getSumOfRecords();
    }

    public void insertRecord(Record record) {
        this.recordList.add(record);
        sortByUseDate();
    }

    /*
     * Record 받아오기
     */
    public StringBuilder getCsvRecords() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Record record : recordList) {
            stringBuilder.append(record.getCsvRecord());
        }

        return stringBuilder;
    }

    private void sortByUseDate() {
        this.recordList.sort(Comparator.comparing(Record::getUseDate));
    }
}
