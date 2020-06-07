package wordPlay.handler;

import wordPlay.util.FileProcessor;
import wordPlay.util.Results;

public class WordRotator{

  // Poll is a linkedlist that returns each word from the file
int numOfRotations = 0;

public Results rotator(String Dinput){
  String wordReversed;
  Results result = new Results();
  try{
  FileProcessor fileprocessor = new FileProcessor(Dinput);
  String word = fileprocessor.poll();
  while(word != null){
    numOfRotations++;
    wordReversed = WordRotator(word);
    result.addToList(wordReversed);
    word = fileprocessor.poll();
  }

}catch(Exception e){
  System.out.println("FileNotFoundException");
}
return result;
}
public char[] removeperiod(String word){
  word.replace(".","");
  char[] temp = word.toCharArray();
  return temp;
}

public String WordRotator(String word){
  boolean isPeriod = false;
  char [] wordArray = word.toCharArray();

  if(wordArray[wordArray.length-1] == '.')
  {
    wordArray = removeperiod(word); //to take "." in consideration
    isPeriod=true;
  }
  int end = findBreakPoint(wordArray.length, numOfRotations);
  String subString1 = breakString(wordArray, 0, end-1);
  String subString2 = breakString(wordArray, end, wordArray.length - 1);
  if(isPeriod == true){
    subString1 += ".\n"; // append "." at the end
    numOfRotations = 0; // start of new line, hence counter would reinitalize
    isPeriod = false;
  }else{
    subString1 += " ";
  }
  String result = subString2 + subString1;
  return result;
  }

public String breakString(char[] charArray, int start, int end){
  String subString = "";
  for(int i = start; i <= end; i++){
    if(charArray[i] !=  '.'){
    subString += charArray[i];
  }
}
  return subString;
}

public int findBreakPoint(int stringLength, int rotations){
  int end = stringLength - rotations;
  while(end < 0){
    end = -end;
    end = stringLength - end;
  }
  return end;
}
}
