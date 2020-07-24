package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UpdatedFileWriter {

    private static final String FILE_FORMAT = "out-%03d.txt";
    private static final int MAX_BYTES_IN_FILE = 10;
    private int fileCount = 1;
    private FileWriter writer;
    private int byteCount = 0;

    public UpdatedFileWriter() throws IOException {
        writer = new FileWriter(String.format(FILE_FORMAT,fileCount));
    }

    public void write(String s) throws IOException {
        FileWriter writer = getWriter();
        writer.write(s);
        writer.write('\n');
        byteCount += s.getBytes().length + 1;
        writer.flush();
    }

    private FileWriter getWriter() throws IOException {
        if(byteCount - MAX_BYTES_IN_FILE >= 0){
            writer.close();
            fileCount++;
            writer = new FileWriter(String.format(FILE_FORMAT,fileCount));
            byteCount = 0;
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
