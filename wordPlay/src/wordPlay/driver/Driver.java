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
		if ((args.length < 1) ) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}
		System.out.println(args[0]);
		WordRotator wordrotator = new WordRotator();
		Results r = wordrotator.rotator(args[0]);
		r.writeToStdout();
		r.writeToFile("output.txt");
		r.writeMetricToFile("metrics.txt");
	}
}
