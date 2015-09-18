package com.cimbel.client;

/**
 * Created by kevinyu on 9/18/15.
 */
public class Screen {

    private static int messageX = 0;
    private static int messageY = 0;

    private static int inputX = 40;
    private static int inputY = 0;

    public static void initialize() {
        clearScreen();
        printText(inputX,inputY,"Masukan input");
        moveCursor(inputX,inputY+1);
    }

    public static void printMessage(String message) {
        printText(messageX,messageY,message);
        messageY++;
    }

    public static void clearScreen() {
        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
    }

    public static void printText(int x,int y, String text) {
        moveCursor(x,y);
        System.out.println(text);
        moveCursor(inputX,inputY+1);
    }

    public static void moveCursor(int x,int y) {
        char escCode = 0x1B;
        int row = x; int column = y;
        System.out.print(String.format("%c[%d;%df",escCode,row,column));
    }
}
