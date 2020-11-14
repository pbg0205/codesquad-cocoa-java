package account_book;

class Record implements Comparable<Record> {
    private UseDate useDate;
    private String detail;
    private int money;
    private String payType;

    public Record(String dateStr, String detail, int money, String payType) {
        this.useDate = new UseDate(dateStr);
        this.detail = detail;
        this.money = money;
        this.payType = setPayType(payType);
    }

    public int getMoney() {
        return money;
    }

    private String setPayType(String payType) {
        payType = payType.trim();

        if (payType.equals("현금") || payType.equalsIgnoreCase("cash")) {
            return "cash";
        }

        if (payType.equals("카드") || payType.equalsIgnoreCase("card")) {
            return "card";
        }

        return null;
    }

    public boolean matchByUseDate(UseDate useDate) {
        return this.useDate.equals(useDate);
    }

    public boolean matchByDetail(String detail) {
        return this.detail.equals(detail);
    }

    public boolean matchByMoney(int money) {
        return this.money == money;
    }

    public boolean matchByPayType(String payType){
        return this.payType.startsWith(payType);
    }

    public String getCsvRecord (){
        return String.format("%s,%s,%d,%s\n",this.useDate, this.detail, this.money, this.payType);
    }

    @Override
    public String toString() {
        return String.format("%25s %20s %20d %20s", this.useDate, this.detail, this.money, this.payType);
    }

    @Override
    public int compareTo(Record other) {
        return (this.useDate).compareTo(other.useDate);
    }
}
