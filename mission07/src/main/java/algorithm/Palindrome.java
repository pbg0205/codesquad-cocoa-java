package algorithm;

public class Palindrome {
    public boolean isPalindrome(int x) {
        char[] numbers = String.valueOf(x).toCharArray();
        int numberLen = numbers.length;

        for (int index = 0; index < numberLen / 2; index++) {
            char left_char = numbers[index];
            char right_char = numbers[numberLen - (index + 1)];

            if(left_char != right_char) {
                return false;
            }
        }

        return true;
    }
}
