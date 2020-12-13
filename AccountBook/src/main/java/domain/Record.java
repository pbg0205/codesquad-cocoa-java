package domain;

public final class Record {
    private final UseDate useDate;
    private final String detail;
    private final int money;
    private final Category category;
    private final PayType payType;

    public Record(String useDateStr, String detail, int money, String category, String payType) {
        this.useDate = new UseDate(useDateStr);
        this.detail = detail;
        this.money = money;
        this.category = setCategory(category);
        this.payType = setPayType(payType);
    }

    /*
     * initilization of payType
     */
    private PayType setPayType(String payTypeStr) {
        return PayType.valueOf(payTypeStr.trim());
    }

    /*
     * initilization of category
     */
    private Category setCategory(String categoryStr) {
        return Category.valueOf(categoryStr.trim());
    }

    /*
     * getter
     */
    UseDate getUseDate() {
        return useDate;
    }

    int getMoney() {
        return money;
    }

    String getCsvRecord (){
        return String.format("%s,%s,%d,%s,%s\n",this.useDate, this.detail, this.money, this.category, this.payType);
    }

    /*
     * return stringArray for mainview
     */
    String[] getStringArrayForm() {
        return new String[] {useDate.toString(),
                detail,
                String.valueOf(money),
                category.getValue(),
                payType.getValue()};
    }

    @Override
    public String toString() {
        return String.format("%25s %20s %20d %20s", this.useDate, this.detail, this.money, this.category, this.payType);
    }
}
