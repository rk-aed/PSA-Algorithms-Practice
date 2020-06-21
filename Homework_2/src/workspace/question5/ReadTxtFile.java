package workspace.question5;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadTxtFile {
	
	public ArrayList<Student> read(String sourcePath){
		ArrayList<Student> result = new ArrayList<Student>();
		
		
		Path path = Paths.get(sourcePath);
		Scanner scanner;
		try {
			scanner = new Scanner(path);
			//read line by line
			int count = 0;
			while(scanner.hasNextLine()){
			
				 String line = scanner.nextLine();
			//	 System.out.println(line);
				 if(!(count == 0)) {
					 String[] words = line.split(" ");
					 String course = line.substring(line.indexOf(words[3]));
					 Student std = new Student(Integer.parseInt(words[0]), words[1], words[2], course);
					 result.add(std);
			   }
				 
				 
				 count++;
				 
			}
			
			scanner.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	

}
