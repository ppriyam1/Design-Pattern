package wordPlay.util;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;

import wordPlay.handler.WordRotator;
import wordPlay.driver.Driver;
import wordPlay.util.FileDisplayInterface;
import wordPlay.util.StdoutDisplayInterface;
import wordPlay.metrics.MetricsCalculator;

/**
* Results is a utility to be used to store the result and perform function such as writeToFile and writeToConsole.
*
* @author Preeti Priyam
*/

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	private ArrayList<String> arraylist = new ArrayList<String>();
	private MetricsCalculator metrics;

	/**
  * Method to add rotated words in an array List.
	*
	* @return no return type.
  */
	public void addToList(String value){
		arraylist.add(value);
	}

	/**
  * Method to print the output to the console.
	*
	* @return no return type.
  */
	public void writeToStdout(){
		System.out.println("--------- Output ---------");
		for (int i = 0; i < arraylist.size(); i++){
      System.out.print(arraylist.get(i));
    }
		metrics.writeToStdout();
	}

	/**
	* Method to write the output into a output file.
	*
	* @return no return type.
	*/
	public void writeToFile(String Doutput){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Doutput));
			for (int i = 0; i < arraylist.size(); i++) {
	     writer.write(arraylist.get(i));
	    }
			writer.close();
			}
			catch(Exception e){
			 System.err.println(e);
			 System.exit(0);
			}
	}

	/**
	* Method to set the metrics instance variable.
	*
	* @return no return type.
	*/
	public void setMetrics( MetricsCalculator m){
		metrics = m;
	}

	/**
  * Method to send user input metric file to the metrics calculator class.
	*
	* @return no return type.
  */
	public void writeMetricToFile(String Dmetric){
		metrics.writeToFile(Dmetric);
	}

}
