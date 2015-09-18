package com.cimbel.client;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/**
 * Created by kevinyu on 9/17/15.
 */
public class InputReaderTask implements Runnable {

    private BlockingQueue<String> mInputQueue;

    public InputReaderTask(BlockingQueue inputQueue) {
        mInputQueue = inputQueue;
    }

    @Override
    public void run() {

        while(!Thread.currentThread().isInterrupted()) {
            Scanner reader = new Scanner(System.in);
            String input = reader.nextLine();

            try {
                mInputQueue.put(input);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
