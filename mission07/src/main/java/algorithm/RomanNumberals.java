package algorithm;

class RomanNumberals {
    public static void main(String[] args) {
        RomanNumberals solution = new RomanNumberals();
        System.out.println(solution.romanToInt("IV"));
    }

    public int romanToInt(String s) {
        int result = 0;
        int previous = 0;

        for (int index = s.length() - 1; index >= 0; index--) {
            int current = getIntegerByRoman(s.charAt(index));

            if (index == s.length() - 1) {
                result += current;
            } else{
                if (current < previous) {
                    result -= current;
                } else {
                    result += current;
                }
            }
            previous = current;
        }

        return result;
    }

    public int getIntegerByRoman(char Roman) {
        int num = 0;

        switch (Roman) {
            case 'I':
                num = 1;
                break;
            case 'V':
                num = 5;
                break;
            case 'X':
                num = 10;
                break;
            case 'L':
                num = 50;
                break;
            case 'C':
                num = 100;
                break;
            case 'D':
                num = 500;
                break;
            case 'M':
                num = 1000;
                break;
        }
        return num;
    }
}
