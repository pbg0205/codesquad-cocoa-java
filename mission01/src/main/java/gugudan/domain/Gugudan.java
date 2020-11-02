package gugudan.domain;

public class Gugudan {
    private int dan;
    private int[] danValue;

    public Gugudan(String value) {
        this.dan = Integer.parseInt(value);
        this.danValue = caculateGuGudan(dan);
    }

    public Gugudan(int value) {
        this.dan = value;
        this.danValue = caculateGuGudan(dan);
    }

    public void print(){

        System.out.printf("________%d단________\n", this.dan);

        for (int index = 1; index <= 9; index++) {
            System.out.printf("%d × %d = %d\n", this.dan, index, danValue[index]);
        }
    }

    private int[] caculateGuGudan(int dan){
        int[] danArray = new int[10];

        for (int index = 1; index <= 9; index++) {
            danArray[index] = multiply(dan, index);
        }

        return danArray;
    }

    private int multiply(int dan, int value){
        return dan * value;
    }
}
