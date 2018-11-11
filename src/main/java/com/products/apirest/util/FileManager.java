package com.products.apirest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;

public class FileManager {

    private static Logger logger = LoggerFactory.getLogger(FileManager.class);

    public static void write(String content) {
        try {
            File file = new File("api_log.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            String fileContent = read();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(fileContent + content);
            bw.close();
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }

    public static String read() {
        StringBuilder resultStringBuilder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("api_log.txt")));
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
            br.close();
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return resultStringBuilder.toString();
    }

}


