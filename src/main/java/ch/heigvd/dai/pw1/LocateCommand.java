package ch.heigvd.dai.pw1;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import java.io.File;
import java.util.concurrent.Callable;


@Command(name = "locate",
        description = "Finds all positions of a given word in the input file and writes them to the output file.")
public class LocateCommand implements Callable<Integer> {

    // Input arg
    @Option(names = {"-i", "--input"}, required = true, description = "The input file to search within.")
    private File inputFile;

    // Output
    @Option(names = {"-o", "--output"}, required = true, description = "The output file to write word positions to.")
    private File outputFile;

    // Search word
    @Option(names = {"-w", "--word"}, required = true, description = "The word to search for.")
    private String searchWord;

    @Override
    public Integer call() throws Exception {
        System.out.println("--- Locate Command Started ---");
        System.out.println("Searching for word: '" + searchWord + "'");
        System.out.println("Input File: " + inputFile.getAbsolutePath());
        System.out.println("Output File: " + outputFile.getAbsolutePath());

        // TODO: Milestones 3/5' Java IO codes

        System.out.println("Location complete. (Positions written to output file.)");
        return 0;
    }
}