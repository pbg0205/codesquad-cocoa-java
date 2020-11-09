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

    public void addRecord(String dateStr, String deatil, int money) {
        if (isValid(dateStr, deatil, money)) {
            recordList.add(new Record(dateStr, deatil, money));
        }
    }

    //TODO 입력 데이터 유형성 검사 메소드 구현하기
    private boolean isValid(String dateStr, String deatil, int money) {
        return true;
    }

    public void printRecords() {
        int recordsSize = this.recordList.size();
        if(recordsSize == 0){
            System.out.println("조회할 목록이 존재하지 않습니다.");
            return ;
        }

        OutputView.recordListMessage();

        for (int index = 0; index < recordsSize; index++) {
            System.out.println(index + " : " + this.recordList.get(index));
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
