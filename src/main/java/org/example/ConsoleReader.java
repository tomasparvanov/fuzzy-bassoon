package org.example;

import java.util.Scanner;

public class ConsoleReader {

    Scanner in;
    String line;

    public ConsoleReader() {
        this.in = new Scanner(System.in);
    }

    public boolean hasNextLine() {
        if (in.hasNextLine()){
            line = in.nextLine();
            return !line.isEmpty();
        }
        return false;
    }

    public String getLine() {
        return line;
    }

    public void close() {
        in.close();
    }
}

