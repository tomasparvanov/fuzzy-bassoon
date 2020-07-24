package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomFileWriter {

    private static final String FILE_FORMAT = "out-%03d.txt";
    private static final int MAX_LINES_IN_FILE = 5;
    private int fileCount = 1;
    private FileWriter writer;
    private int linesInFile = 0;

    public CustomFileWriter() throws IOException {
        writer = new FileWriter(String.format(FILE_FORMAT,fileCount));
    }

    public void write(String s) throws IOException {
        FileWriter writer = getWriter();
        writer.write(s);
        writer.write('\n');
        writer.flush();
    }

    private FileWriter getWriter() throws IOException {
        linesInFile++;
        if(linesInFile % (MAX_LINES_IN_FILE + 1) == 0){
            writer.close();
            fileCount++;
            writer = new FileWriter(String.format(FILE_FORMAT,fileCount));
            linesInFile = 1;
        }
        return writer;
    }

    public void close() throws IOException {
        writer.close();
    }

    public List<String> getCreatedFiles() {
        return Stream.iterate(1, n -> n+1)
                .limit(fileCount)
                .map(value -> String.format(FILE_FORMAT, value))
                .collect(Collectors.toList());  //just for fun :)
    }

    public int getFileCounts() {
        return fileCount;
    }
}
