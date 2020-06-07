package wordPlay.util;

import java.io.FileWriter;
import java.io.BufferedWriter;

import java.util.ArrayList;
import wordPlay.handler.WordRotator;
import wordPlay.driver.Driver;
import wordPlay.util.FileDisplayInterface;
import wordPlay.util.StdoutDisplayInterface;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	ArrayList<String> arraylist = new ArrayList<String>();
	public boolean addToList(String value){
		arraylist.add(value);
		return true;
	}

	public void writeToStdout(){
		for (int i = 0; i < arraylist.size(); i++) {
            System.out.print(arraylist.get(i) );
        }
	}

	public int writeToFile(String Doutput){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Doutput));
			for (int i = 0; i < arraylist.size(); i++) {
	            writer.write(arraylist.get(i));
	        }
			writer.close();
		} catch (Exception e) {
			System.err.println(e);
			System.exit(0);
		}
		return 0;
	}

}
