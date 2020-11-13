package algorithm.programmers.year2016;
/*
 * @problem     2016년(프로그래머스)
 * @url         https://programmers.co.kr/learn/courses/30/lessons/12901
 * @author      cooper
 * @created by  11.13.20
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;

public class Solution {
    public String solution(int a, int b) throws ParseException {
        String answer = "";
        String dateOf2016 = getDate(a, b);

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = dateFormat.parse(dateOf2016);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch(day){
            case 1:	answer += "SUN";	break;
            case 2:	answer += "MON";	break;
            case 3:	answer += "TUE";	break;
            case 4:	answer += "WED";	break;
            case 5:	answer += "THU";	break;
            case 6:	answer += "FRI";	break;
            case 7:	answer += "SAT";	break;
        }

        return answer;
    }

    private String getDate(int a, int b) {
        String  year = "2016";
        String month;
        String day;

        if(a < 10){
            month = "0" + a;
        }else{
            month = String.valueOf(a);
        }

        if(b < 10){
            day = "0" + b;
        }else{
            day = String.valueOf(b);
        }

        return year + month + day;
    }
}