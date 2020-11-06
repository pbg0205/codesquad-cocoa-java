package algorithm.baekjoon1085;

import java.util.Scanner;

/*
 * @problem     직사각형에서 탈출(1085)
 * @url         https://www.acmicpc.net//1085
 * @author      pbg0205
 * @created by  11.06.20
 */
class Main {

    public static void main(String[] args) {
        int nowX = Input.inputData();
        int nowY = Input.inputData();
        int width = Input.inputData();
        int height = Input.inputData();

        new App(nowX, nowY, width, height).start();
    }
}

class App{
    Square square;

    public App(int nowX, int nowY, int width, int height){
        this.square = new Square(nowX, nowY, width, height);
    }

    public void start(){
        int minDistance = square.getMinValue();

        System.out.println(minDistance);
    }
}

class Input{
    private static Scanner scanner = new Scanner(System.in);

    public static int inputData(){
        return scanner.nextInt();
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getMinDistanceFromUpDown(int height) {
        int distancFromUpper = Math.abs(height - this.y);
        int distanceFromDown = Math.abs(this.y - 0);

        return Math.min(distancFromUpper, distanceFromDown);
    }

    public int getDistanceFromLeftRight(int width) {
        int distanceFromLeft = Math.abs(this.x - 0);
        int distanceFromRight = Math.abs(width - this.x);

        return Math.min(distanceFromLeft, distanceFromRight);
    }
}

class Square {
    private Point nowPoint;
    private int width;
    private int height;

    public Square(int nowX, int nowY, int angleX, int angleY) {
        this.nowPoint = new Point(nowX, nowY);
        this.width = angleX;
        this.height = angleY;
    }

    public int getMinValue() {
        int distanceFromUpAndDown = nowPoint.getMinDistanceFromUpDown(height);
        int distanceFromLeftAndRight = nowPoint.getDistanceFromLeftRight(width);

        return Math.min(distanceFromUpAndDown, distanceFromLeftAndRight);
    }
}

