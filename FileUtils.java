package libs.logger;

import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
    public static void writeToFile(String path, String message) throws Exception {
        File f = new File(path);
        if(!f.exists()) {
            f.getParentFile().mkdirs();
            f.createNewFile();
        }
        try (FileWriter fw = new FileWriter(f, true)) {
            fw.write(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String path, String message, boolean append) throws Exception {
        File f = new File(path);
        if(!f.exists()) {
            f.getParentFile().mkdirs();
            f.createNewFile();
        }
        try (FileWriter fw = new FileWriter(f, append)) {
            fw.write(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String loadAsString(String path){
        try {
            File yourFile = new File(path);
            yourFile.getParentFile().mkdirs();
            yourFile.createNewFile();
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded, Charset.forName("utf8"));
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
