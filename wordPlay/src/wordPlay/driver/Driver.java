package wordPlay.driver;

import wordPlay.util.FileProcessor;

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
		System.out.println("Hello World! Lets get started with the assignment");
		FileProcessor fileprocessor = null;
		String line = "";
		try{
			fileprocessor = new FileProcessor(args[0]);
		  String sr = fileprocessor.poll();// Poll is a linkedlist that returns each word from the file
			int counter = 0;
			boolean gotPeriod=false;
			while(sr != null){
				char [] ch = sr.toCharArray();
				counter++;
				if(ch[ch.length-1] == '.')
				{
					counter++; //to take "." in consideration
					gotPeriod=true;
				}
			int end = ch.length - counter;

			if(end < 0){
				end++;
			}

			String s2="",s1="";
			for(int i = 0; i <= end-1; i++){
				if(ch[i] !=  '.'){
				s1 += ch[i];
			}
			}
			for(int j = end; j <= ch.length-1 ; j++){
				String result = sr.replaceAll("[-+.^:,]","");
				if(ch[j] !=  '.'){
					s2 += ch[j];
				}
			}
			if(gotPeriod){
				s1 += "."; // append "." at the end
				counter=0; // start of new line, hence counter would reinitalize
				gotPeriod=false;
			}
			line = s2 + s1;
			System.out.println(line);
			sr = fileprocessor.poll();
			}
		}
		catch(Exception FileNotFoundException){
 			System.out.println("FileNotFound");
			System.exit(0);
		}


	}
}
