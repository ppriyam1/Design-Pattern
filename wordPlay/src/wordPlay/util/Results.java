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
* Method to .
*/
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	ArrayList<String> arraylist = new ArrayList<String>();
	MetricsCalculator metrics;
	public boolean addToList(String value){
		arraylist.add(value);
		return true;
	}
	/**
  * Method to .
  */
	public void writeToStdout(){
		for (int i = 0; i < arraylist.size(); i++){
        System.out.print(arraylist.get(i) );
    	}
		metrics.writeToStdout();
	  }
		/**
	  * Method to .
	  */
	public int writeToFile(String Doutput){
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
			return 0;
		}
		/**
	  * Method to .
	  */
	public void setMetrics( MetricsCalculator m){
		metrics = m;
	}
	/**
  * Method to .
  */
	public void writeMetricToFile(String Dmetric){
		metrics.writeToFile(Dmetric);
	}

}
