package ch.heigvd.dai.pw1;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import java.io.File;


@Command(name   = "pw1-cli", mixinStandardHelpOptions = true,
        version = "pw1-cli 1.0", description = "Processes files to count elements or locate words.",
        subcommands = {
                CountCommand.class, // 1.
                LocateCommand.class // 2.
        })
public class CliApp implements Runnable {

    @Option(names = {"-i", "--input"}, required = true, description = "The input file to process.")
    private File inputFile;

    @Option(names = {"-o", "--output"}, required = true, description = "The output file.")
    private File outputFile;

    // run()
    @Override
    public void run() {
        System.out.println("Run 'pw1-cli --help' for usage instructions.");
    }


    //main
    public static void main(String[] args) {
        int exitCode = new CommandLine(new CliApp()).execute(args);
        System.exit(exitCode);
    }
}