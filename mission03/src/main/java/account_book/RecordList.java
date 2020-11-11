package account_book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecordList {
    private List<Record> recordList;

    public RecordList() {
        this.recordList = new ArrayList<>();
    }

    public void printRecords() {
        int recordsSize = this.recordList.size();

        if (recordsSize == 0) {
            OutputView.noRecordMessage();
            return;
        }
        printRecord(recordsSize);
    }

    public void printRecordsOfIndex(List<Integer> searchList) {
        for (Integer index : searchList) {
            System.out.printf("%5d %10s\n", index, this.recordList.get(index));
        }
    }

    private void printRecord(int recordsSize) {
        OutputView.recordListMessage();
        printEachRecord(recordsSize);
        printSum();
    }

    private void printEachRecord(int recordsSize) {
        for (int index = 0; index < recordsSize; index++) {
            System.out.printf("%5d %10s\n", index, this.recordList.get(index));
        }
    }

    private void printSum() {
        int sum = getSumOfRecords();
        System.out.printf("%20s %5d\n", " ", sum);
    }

    private int getSumOfRecords() {
        return recordList.stream().mapToInt(Record::getMoney).sum();
    }

    public void insertRecord(Record record) {
        this.recordList.add(record);
        sortByUseDate();
    }

    public void modifyRecord(int index, Record record) {
        this.recordList.remove(index);
        this.recordList.add(record);
        sortByUseDate();
    }

    public void deleteRecord(int index) {
        this.recordList.remove(index);
        sortByUseDate();
    }

    private void sortByUseDate() {
        Collections.sort(this.recordList);
    }

    public List<Integer> searchByDate(UseDate useDate) {
        List<Integer> searchIndex = new ArrayList<>();
        int recordListSize = recordList.size();

        for (int i = 0; i < recordListSize; i++) {
            Record record = this.recordList.get(i);
            if (record.matchByUseDate(useDate)) {
                searchIndex.add(i);
            }
        }

        return searchIndex;
    }

    public List<Integer> searchByDetail(String detail) {
        List<Integer> searchIndex = new ArrayList<>();
        int recordListSize = recordList.size();

        for (int i = 0; i < recordListSize; i++) {
            Record record = this.recordList.get(i);
            if (record.matchByDetail(detail)) {
                searchIndex.add(i);
            }
        }
        return searchIndex;
    }

    public List<Integer> searchByMoney(int money) {
        List<Integer> searchIndex = new ArrayList<>();
        int recordListSize = recordList.size();

        for (int i = 0; i < recordListSize; i++) {
            Record record = this.recordList.get(i);
            if (record.matchByMoney(money)) {
                searchIndex.add(i);
            }
        }
        return searchIndex;

    }

    public List<Integer> searchByPayType(String payType) {
        List<Integer> searchIndex = new ArrayList<>();
        int recordListSize = recordList.size();

        for (int i = 0; i < recordListSize; i++) {
            Record record = this.recordList.get(i);
            if (record.matchByPayType(payType)) {
                searchIndex.add(i);
            }
        }
        return searchIndex;
    }
}
