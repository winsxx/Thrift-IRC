package com.cimbel.client;

/**
 * Created by kevinyu on 9/18/15.
 */
public class Screen {

    private static int columnWidth = 50;

    private static int messageX = 0;
    private static int messageY = 10;

    private static int notificationY = 10;
    private static int notificationX = 60;

    private static int inputX = 1;
    private static int inputY = 1;

    private static String whitespace ="                                                                                                                       " +
            "                                                                                                                                                 ";

    public static void initialize() {
        clearScreen();
        printText(messageX, messageY, "Message : ");
        messageY += 1;

        printText(inputX,inputY,"Masukan input : ");
        inputY += 1;

        printText(notificationX,notificationY,"Notification : ");
        notificationY += 1;

        moveCursor(inputX,inputY);
    }

    public static void printMessage(String message) {
        message = insertPeriodically(message,"\n",columnWidth);
        String[] textSplit = message.split("\n");
        for (int i=0;i<textSplit.length;i++) {
            moveCursor(messageX, messageY);
            System.out.println(textSplit[i]);
            moveCursor(inputX, inputY);
            messageY += 1;
        }
    }

    public static void printNotification(String notification) {
        notification = insertPeriodically(notification,"\n",columnWidth);
        String[] textSplit = notification.split("\n");
        for (int i=0;i<textSplit.length;i++) {
            moveCursor(notificationX, notificationY);
            System.out.println(textSplit[i]);
            moveCursor(inputX, inputY);
            notificationY += 1;
        }
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
        moveCursor(inputX, inputY);
    }

    public static void moveCursor(int x,int y) {
        char escCode = 0x1B;
        int row = y; int column = x;
        System.out.print(String.format("%c[%d;%df", escCode, row, column));
    }

    public static void nextInput() {
        moveCursor(inputX, inputY);
        System.out.print(whitespace);
        moveCursor(inputX, inputY);
    }

    public static String insertPeriodically(
            String text, String insert, int period)
    {
        StringBuilder builder = new StringBuilder(
                text.length() + insert.length() * (text.length()/period)+1);

        int index = 0;
        String prefix = "";
        while (index < text.length())
        {
            builder.append(prefix);
            prefix = insert;
            builder.append(text.substring(index,
                    Math.min(index + period, text.length())));
            index += period;
        }
        return builder.toString();
    }
}
