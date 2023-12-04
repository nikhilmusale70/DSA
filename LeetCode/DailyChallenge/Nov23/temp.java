package DailyChallenge.Nov23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class temp {
    public static void main(String[] args) {
        try {
            // Specify the command to run CasperJS script
            String command = "casperjs C:/Nikhil/ChromeTest/Dummy/test.js";

            // Create ProcessBuilder
            ProcessBuilder processBuilder = new ProcessBuilder(command.split("\\s+"));

            // Redirect the error stream to the standard output stream
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output of the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();

            // Print the exit code
            System.out.println("Exit Code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
