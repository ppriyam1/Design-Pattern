package wordPlay.driver;

import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import wordPlay.handler.WordRotator;
import wordPlay.metrics.MetricsCalculator;
/**
 * @author Preeti Priyam
 */
public class Driver {
	public static void main(String[] args) {
		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		 if ((args.length != 3) || (args[0].equals("${input}")) || (args[1].equals("${output}")) || (args[2].equals("${metrics}"))) {
 			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
 			System.exit(0);
 		}
		String inputFile = args[0];
		String outputFile = args[1];
		String metricsFile = args[2];
		WordRotator wordrotator = new WordRotator();
		Results result = wordrotator.rotator(inputFile);
		result.writeToStdout();
		result.writeToFile(outputFile);
		result.writeMetricToFile(metricsFile);
	}
}
