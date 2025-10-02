package ch.heigvd.dai.pw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class CountCommandTest {

    private static CountCommand cmd;
    private static File input;

    @BeforeAll
    public static void init() {
        cmd = new CountCommand();
        try {
            input = File.createTempFile("temp", ".txt");
            writeToTempFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void writeToTempFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(input))) {
            writer.write("a a a\n" +
                    "aaa 22  33\n" +
                    "aaaaaa"
            );
        }
    }

    @Test
    public void shouldBeEqual() {
        String outputString = cmd.readAndCount(input);
        String expected = "Results:\n" +
                "- Lines: 3\n" +
                "- Words: 7\n" +
                "- Chars: 16";

        Assertions.assertEquals(expected, outputString);
    }

    @Test
    public void shouldBeNull() {
        String outputString = cmd.readAndCount(new File("test"));

        Assertions.assertNull(outputString);
    }
}
