package algorithm.hackerrank.timeconversion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        String[] dateArray = s.split(":");
        int hour = Integer.parseInt(dateArray[0]);
        int minute = Integer.parseInt(dateArray[1]);
        int second = Integer.parseInt(dateArray[2].substring(0, 2));
        String AM_PM = dateArray[2].substring(2, 4);

        if(AM_PM.equals("PM") && hour < 12){
            hour += 12;
        }

        if(AM_PM.equals("AM") && hour == 12){
            hour = 0;
        }

        String hour_str = hour >= 10 ? String.valueOf(hour) : "0" + hour;
        String minute_str = minute >= 10 ? String.valueOf(minute) : "0" + minute;
        String second_str = second >= 10 ? String.valueOf(second) : "0" + second;

        return String.format("%2s:%2s:%2s",hour_str, minute_str, second_str);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
