import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * This Class adding new prime numbers "fileBody" into selected File "pathAndFileName"
 * @author m.lukyaniuk
 */
public class CustomFileWriter {

    public static void usingBufferedWritter(String fileBody, String pathAndFileName) {

        BufferedWriter bufferedWriter;
        PrintWriter printWriter = null;
        try {
            bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream((pathAndFileName), true), StandardCharsets.UTF_8));

            printWriter = new PrintWriter(bufferedWriter);

            printWriter.print(fileBody);

            printWriter.flush();

        } catch (IOException e) {
            //TO DO insert Logger Instead
            System.out.println("IO Exception message: " + e.getMessage());
        } finally {
            assert printWriter != null;
            printWriter.close();
            printWriter.close();
            printWriter.close();
        }

    }
}
