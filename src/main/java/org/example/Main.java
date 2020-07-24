package org.example;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        try {
            UpdatedFileWriter updatedFileWriter = new UpdatedFileWriter();
            while (consoleReader.hasNextLine()) {
                updatedFileWriter.write(consoleReader.getLine());
            }
            consoleReader.close();
            updatedFileWriter.close();

            System.out.println(String.format("Process completed. [%d] files were created.", updatedFileWriter.getFileCounts()));
            for (String fileName : updatedFileWriter.getCreatedFiles()) {
                System.out.println(fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
