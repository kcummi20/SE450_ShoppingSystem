package edu.depaul.shoppingsystem.log;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Create a logging system to record important events and transactions.

public class Logging {
	
	private static final String logFile = "shoppingSystem.log"; // log file location
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String source, String level, String message) {
        try (FileWriter fw = new FileWriter(logFile, true)) {
            String timestamp = LocalDateTime.now().format(dtf);
            String formattedMessage = timestamp + " [" + level + "] [" + source + "] - " + message + "\n";
            fw.write(formattedMessage);
            System.out.println(formattedMessage); // print the log to the console
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void info(String source, String message) {
        log(source, "INFO", message);
    }

    public static void error(String source, String message) {
        log(source, "ERROR", message);
    }

}
