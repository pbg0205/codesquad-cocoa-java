package domain;

public class Record {
    private UseDate useDate;
    private String detail;
    private int money;
    private Category category;
    private PayType payType;

    public Record(String useDateStr, String detail, int money, String category, String payType) {
        this.useDate = new UseDate(useDateStr);
        this.detail = detail;
        this.money = money;
        this.category = setCategory(category);
        this.payType = setPayType(payType);
    }

    /*
     * 지불 방식(payType)
     */
    private PayType setPayType(String payTypeStr) {
        return PayType.valueOf(payTypeStr.trim());
    }

    /*
     * 카테고리 선정
     */
    private Category setCategory(String categoryStr) {
        return Category.valueOf(categoryStr.trim());
    }

    /*
     * getter
     */
    public UseDate getUseDate() {
        return useDate;
    }

    public int getMoney() {
        return money;
    }

    public String getCsvRecord (){
        return String.format("%s,%s,%d,%s,%s\n",this.useDate, this.detail, this.money, this.payType, this.category);
    }

    @Override
    public String toString() {
        return String.format("%25s %20s %20d %20s", this.useDate, this.detail, this.money, this.payType, this.category);
    }
}
