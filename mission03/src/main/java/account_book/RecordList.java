package account_book;

import java.util.ArrayList;
import java.util.List;

public class RecordList {
    private List<Record> recordList;

    public RecordList() {
        this.recordList = new ArrayList<>();
    }

    public int getSumOfRecords() {
        return recordList.stream().mapToInt(Record::getMoney).sum();
    }

    public void printRecords() {
        int recordsSize = this.recordList.size();

        if(recordsSize == 0){
            OutputView.noRecordMessage();
            return ;
        }

        OutputView.recordListMessage();
        printRecord(recordsSize);
    }

    private void printRecord(int recordsSize){
        for (int index = 0; index < recordsSize; index++) {
            System.out.printf("%5d %10s\n",index, this.recordList.get(index));
        }
    }

    public void insertRecord(Record record) {
        this.recordList.add(record);
    }

    public void modifyRecord(int index, Record record) {
        this.recordList.remove(index);
        this.recordList.add(record);
    }

    public void deleteRecord(int index) {
        this.recordList.remove(index);
    }
}
