import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String line = null;

        int lines = 0;
        int counter = 0;
        PrintStream out = new PrintStream(String.format("out-%03d.txt", counter++));

        if (in.hasNextLine()) {
            line = in.nextLine();
        } else {
            line = null;
        }

        while (! (line == null || "".equalsIgnoreCase(line)) ) {
            if(lines > 4) {
                out.close();
                out = new PrintStream(String.format("out-%03d.txt", counter++));
                lines = 0;
            }
            out.println(line);
            lines++;
            if (in.hasNextLine()) {
                line = in.nextLine();
            } else {
                line = null;
            }
        }
        out.close();
        System.out.println(String.format("Process completed. [%d] files were created.", counter));

        // List the files created
        File dir = new File(".");
        File[] filesList = dir.listFiles();
        for (File file : filesList) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

    }


}
