package ch.heigvd.dai.pw1;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;

@Command(name = "count",
        description = "Counts lines, words, and characters in the input file and prints the results.")
public class CountCommand implements Callable<Integer> {

        @Option(names = {"-i", "--input"}, required = true, description = "The input file to process.")
    private File inputFile;

    @Override
    public Integer call() throws Exception {
        System.out.println("--- Count Command Started ---");
        System.out.println("Input File: " + inputFile.getAbsolutePath());

        String output = readAndCount(inputFile);

        if (output != null) {
            writeOutputFile(output);
            System.out.println("Counting complete." + output);
        }

        return 0;
    }

    /**
     * Reads the file and count lines, words, chars.
     * <p>
     * If file does not exist return {@code null}
     *
     * @param inputFile file to read
     * @return a formatted string containing the counting results.
     */
    public String readAndCount(File inputFile) {

        if (!inputFile.exists()) {
            System.out.println("File " + inputFile + " does not exist");
            return null;
        }

        int lines = 0;
        int words = 0;
        int chars = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile, StandardCharsets.UTF_8))) {
            String line;

            while ((line = reader.readLine()) != null) {

                lines++;
                words += countWords(line);
                chars += countChars(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return String.format("Results:\n- Lines: %d\n- Words: %d\n- Chars: %d",
                lines,
                words,
                chars
        );
    }

    /**
     * Counts words in a string.
     *
     * @param line - line to count words
     * @return number of words in line
     */
    private int countWords(String line) {
        int words = 0;
        for (String s : line.split(" ")) {
            if (!s.isBlank()) {
                words++;
            }
        }
        return words;
    }

    /**
     * Counts chars in a string. Skips whitespaces.
     *
     * @param line - line to count chars
     * @return number of chars in line
     */
    private int countChars(String line) {
        int chars = 0;
        for (char c : line.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                chars++;
            }
        }
        return chars;
    }

    /**
     * Writes string in the file.
     * Rewrites the file if necessary.
     *
     * @param output - line to write in the file
     */
    private void writeOutputFile(String output) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output", StandardCharsets.UTF_8))) {
            writer.write(output);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
