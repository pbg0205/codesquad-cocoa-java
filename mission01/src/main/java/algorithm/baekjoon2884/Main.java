package algorithm.baekjoon2884;

import java.util.Scanner;

/*
 * @Problem     알람시계(2884)
 * @author      cooper
 * @created by  11.02.20
 */

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Clock alram;

        int hour = scanner.nextInt();
        int minute = scanner.nextInt();

        alram = new Clock(hour, minute);

        alram.setAlramBefore(45);

        scanner.close();
    }
}

class Clock{
    private int hour;
    private int minute;

    public Clock(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }

    public void setAlramBefore(int minute){
        setAlramMinute(minute);
        setAlramHour();
        printTime();
    }

    private void setAlramHour() {
        if(this.hour < 0){
            this.hour += 24;
        }
    }

    private void setAlramMinute(int minute) {
        this.minute = this.minute - minute;

        if(this.minute < 0){
            hour--;
            this.minute = 60 + this.minute;
        }
    }

    private void printTime() {
        System.out.println(this.hour + " " + this.minute);
    }
}
