package wordPlay.handler;

import wordPlay.util.FileProcessor;

public class WordRotator{

  // Poll is a linkedlist that returns each word from the file
int numOfRotations = 0;

public WordRotator(String Dinput){
  rotator(Dinput);
}

public void rotator(String Dinput){
  try{
  FileProcessor fileprocessor = new FileProcessor(Dinput);
  String word = fileprocessor.poll();
  while(word != null){
    numOfRotations++;
    WordRotator(word, numOfRotations);
    word = fileprocessor.poll();
  }
}catch(Exception e){
  System.out.println("FileNotFoundException");
}
}

public String WordRotator(String word, int numOfRotations){
  boolean isPeriod = false;
  char [] wordArray = word.toCharArray();

  if(wordArray[wordArray.length-1] == '.')
  {
    numOfRotations++; //to take "." in consideration
    isPeriod=true;
  }
  int end = findBreakPoint(wordArray.length, numOfRotations);
  String subString1 = breakString(wordArray, 0, end-1);
  String subString2 = breakString(wordArray, end, wordArray.length - 1);
  if(isPeriod){
    subString1 += "."; // append "." at the end
    numOfRotations = 0; // start of new line, hence counter would reinitalize
    isPeriod = false;
  }
  String result = subString2 + subString1;
  System.out.println(result);
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
    //System.out.print(Integer.toString(end)+"  ");
    end = -end;
    end = stringLength - end;
  }
  return end;
}
}
