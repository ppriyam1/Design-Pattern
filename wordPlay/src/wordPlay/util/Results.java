package wordPlay.util;

import java.io.FileWriter;
import java.io.BufferedWriter;

import java.util.ArrayList;
import wordPlay.handler.WordRotator;
import wordPlay.driver.Driver;
import wordPlay.util.FileDisplayInterface;
import wordPlay.util.StdoutDisplayInterface;
import wordPlay.metrics.MetricsCalculator;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	ArrayList<String> arraylist = new ArrayList<String>();
	MetricsCalculator metrics;
	/**
  * Method to add rotated words in an array List.
  */
	public void addToList(String value){
		arraylist.add(value);
	}
	/**
  * Method to print the output to the console.
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
	*/
	public void setMetrics( MetricsCalculator m){
		metrics = m;
	}
	/**
  * Method to send user input metric file to the metrics calculator class.
  */
	public void writeMetricToFile(String Dmetric){
		metrics.writeToFile(Dmetric);
	}

}
