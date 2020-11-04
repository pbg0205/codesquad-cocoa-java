package indian;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String birthDayStr;
        String IndianName;

        System.out.println("생년월일을 입력해 주세요>");

        birthDayStr = scanner.nextLine();
        IndianName = getIndianName(birthDayStr);

        System.out.println(IndianName);
    }

    public static String getIndianName(String birthDayStr) {
        String[] birth = birthDayStr.split(" ");

        int year = Integer.parseInt(birth[0]);
        int month = Integer.parseInt(birth[1]);
        int day = Integer.parseInt(birth[2]);

        String IndianName = genearateIndianName(year, month, day);

        return IndianName;
    }

    public static String genearateIndianName(int year, int month, int day) {
        String IndianName = "";

        IndianName += getYearName(year);
        IndianName += getMonthName(month);
        IndianName += getDayName(day);

        return IndianName;
    }

    private static String getDayName(int day) {
        if (day == 1) {
            return "와 함께 춤을";
        }

        if (day == 2) {
            return "의 기상";
        }
        if (day == 3) {
            return "은 그림자속에";
        }

        if (day == 7) {
            return "의 환생";
        }

        if (day == 8) {
            return "의 죽음";
        }

        if (day == 9) {
            return "아래에서";
        }

        if (day == 10) {
            return "을 보라";
        }

        if (day == 11) {
            return "가 노래하다.";
        }

        if (day == 12) {
            return "의 그림자";
        }

        if (day == 13) {
            return "의 일격";
        }

        if (day == 14) {
            return "에게 쫓기는 남자";
        }

        if (day == 15) {
            return "의 행진";
        }

        if (day == 16) {
            return "의 왕";
        }

        if (day == 17) {
            return "의 유령";
        }

        if (day == 18) {
            return "을 죽인자";
        }

        if (day == 19) {
            return "는 맨날 잠잔다.";
        }

        if (day == 20) {
            return "처럼";
        }

        if (day == 21) {
            return "의 고향";
        }

        if (day == 22) {
            return "의 전사";
        }

        if (day == 23) {
            return "은 나의 친구";
        }

        if (day == 24) {
            return "의 노래";
        }

        if (day == 25) {
            return "의 정령";
        }

        if (day == 26) {
            return "의 파수꾼";
        }

        if (day == 27) {
            return "의 악마";
        }

        if (day == 28) {
            return "와 같은 사나이";
        }

        if (day == 29) {
            return "을 쓰러트린자";
        }

        if (day == 30) {
            return "의 혼";
        }

        if (day == 31) {
            return "은 말이 없다.";
        }

        return "";
    }

    private static String getMonthName(int month) {
        if (month == 1) {
            return "늑대";
        }
        if (month == 2) {
            return "태양";
        }
        if (month == 3) {
            return "양";
        }
        if (month == 4) {
            return "매";
        }
        if (month == 5) {
            return "황소";
        }
        if (month == 6) {
            return "불꽃";
        }
        if (month == 7) {
            return "나무";
        }
        if (month == 8) {
            return "달빛";
        }
        if (month == 9) {
            return "말";
        }
        if (month == 10) {
            return "돼지";
        }
        if (month == 11) {
            return "하늘";
        }
        if (month == 12) {
            return "바람";
        }

        return "";
    }

    private static String getYearName(int year) {
        int endNumberOfYear = year % 10;
        if (endNumberOfYear == 0) {
            return "시끄러운";
        }
        if (endNumberOfYear == 1) {
            return "푸른 ";
        }
        if (endNumberOfYear == 2) {
            return "적색 ";
        }
        if (endNumberOfYear == 3) {
            return "조용한 ";
        }
        if (endNumberOfYear == 4) {
            return "웅크린 ";
        }
        if (endNumberOfYear == 5) {
            return "백색 ";
        }
        if (endNumberOfYear == 6) {
            return "지혜로운 ";
        }
        if (endNumberOfYear == 7) {
            return "용감한 ";
        }
        if (endNumberOfYear == 8) {
            return "날카로운 ";
        }
        if (endNumberOfYear == 9) {
            return "욕심많은 ";
        }

        return null;
    }
}