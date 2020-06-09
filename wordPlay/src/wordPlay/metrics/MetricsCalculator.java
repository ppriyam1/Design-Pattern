package wordPlay.metrics;

import wordPlay.util.Results;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.text.DecimalFormat;


public class MetricsCalculator{
 ArrayList<Integer> numOfWords = new ArrayList<Integer>();
 ArrayList<Integer> wordLength = new ArrayList<Integer>();
 int wordCount=0;
 /**
 * Method to store metric of each word when it is processed.
 */
 public void addWord(String word){
  wordCount++;
  char[] charArr = word.toCharArray();
  wordLength.add(charArr.length);
 }
 /**
 * method to indicate the end of sentence.
 */
 public void endOfLine(){
  numOfWords.add(wordCount);
  wordCount=0;
 }
 /**
 * Method to calculate average of given array list of integers.
 */
 public String calculateAvg(ArrayList<Integer> arrList){
  float sum= 0;
  for(int i= 0; i < arrList.size(); i++){
   sum = sum + arrList.get(i);
  }
  DecimalFormat df = new DecimalFormat("0.00");
  float result= sum/arrList.size();
  return df.format(result);
 }
  /**
  * Method to write the metrics calculated into a output file.
  */
   public int writeToFile(String Dmetrics){
   try{
    BufferedWriter writer = new BufferedWriter(new FileWriter(Dmetrics));
    writer.write("AVG_NUM_WORDS_PER_SENTENCE = "+(calculateAvg(numOfWords))+"\n");
    writer.write("AVG_WORD_LENGTH = "+(calculateAvg(wordLength)));
    writer.close();
   }
   catch(Exception e){
    System.err.println(e);
    System.exit(0);
   }
   return 0;
   }
  /**
  * Method to write the calculated metrics to the console.
  */
  public void writeToStdout(){
   System.out.println("\n--------- Metrics ---------");
   System.out.println("AVG_NUM_WORDS_PER_SENTENCE = "+(calculateAvg(numOfWords)));
   System.out.println("AVG_WORD_LENGTH = "+(calculateAvg(wordLength)));
  }
}
