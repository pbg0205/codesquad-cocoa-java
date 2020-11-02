package gugudan.validator;

public class Validator {
    private String value;
    private String[] values;

    public Validator(String value) {
        this.value = value;
        this.values = value.split(" ");
    }

    public boolean AllValidation(){

        if(!hasTwoValues()){
            return false;
        }

        if(!areBothNumberics()){
            return false;
        }

        if(!areBothGugudanNumbers()){
            return false;
        }

        if(!isLowerThanEnd()){
            return false;
        }

        return true;
    }

    private boolean hasTwoValues() {
        String[] values = value.split(" ");
        int valueCount = values.length;

        if(valueCount != 2){
            System.out.println("값를 0개 혹은 1개 입력하셨습니다. 다시 입력해주세요.");
            return false;
        }

        return true;
    }

    private boolean areBothNumberics(){
        String startValue = this.values[0];
        String endValue = this.values[1];

        if(!isNumberic(startValue)){
            System.out.println("첫번째 값이 숫자가 아닙니다. 다시 입력해주세요");
            return false;
        }

        if(!isNumberic(endValue)){
            System.out.println("두번째 값이 숫자가 아닙니다. 다시 숫자를 입력해주세요.");
            return false;
        }

        return true;
    }

    private boolean isNumberic(String value) {
        try{
            Integer.parseInt(value);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    private boolean areBothGugudanNumbers(){
        String startValue = this.values[0];
        String endValue = this.values[1];

        if(!isGugudanNumber(startValue)){
            System.out.println("첫번 째 숫자가 2이상 9이하 값이 아닙니다. 다시 입력해주세요.");
            return false;
        }

        if(!isGugudanNumber(endValue)){
            System.out.println("두번 째 숫자가 2이상 9이하 값이 아닙니다. 다시 입력해주세요.");
            return false;
        }

        return true;
    }

    private boolean isGugudanNumber(String value){
        int number = Integer.parseInt(value);

        return (2 <= number && number <= 9);
    }

    private boolean isLowerThanEnd(){
        int startNumber = Integer.parseInt(this.values[0]);
        int endNumber = Integer.parseInt(this.values[1]);

        if(startNumber > endNumber){
            System.out.println("첫번째 수가 두 번째 수보다 큽니다.(첫번째 수 > 두번 째 수), 다시 입력해주세요");
            return false;
        }

        return true;
    }
}
