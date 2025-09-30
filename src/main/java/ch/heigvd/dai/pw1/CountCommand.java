
package ch.heigvd.dai.pw1;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import java.io.File;
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

        // TODO: Milestones 3/5' Java IO codes

        System.out.println("Counting complete. (Result placeholder)");
        return 0;
    }
}