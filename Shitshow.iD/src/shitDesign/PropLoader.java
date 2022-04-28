package shitDesign;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class PropLoader {
//Oh god this is the worst way to do this I think I am so sorry.
	private int MIN_SIZE;
	private int MAX_SIZE;
	private int MAX_LETTERS;
	private String temp;
	public void loadProps() throws IOException {
		File configFile = new File("res/config.properties");
		try {
			FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		 
		     temp = props.getProperty("MIN_SIZE");
		     MIN_SIZE = Integer.parseInt(temp);
		     temp = props.getProperty("MAX_SIZE");
		     MAX_SIZE = Integer.parseInt(temp);
		     temp = props.getProperty("MAX_LETTERS");
		     MAX_LETTERS = Integer.parseInt(temp);
		 
		    reader.close();
		} catch (FileNotFoundException ex) {
		   System.out.println("File config.properties doesn't exist.");
		} catch (IOException ex) {
		    System.out.println("IO Error");
		}	
	}
	public int getProp(String value) {
		//This is awful but it works.
		int noData = 50;
		if (value == "MIN_SIZE")
			return MIN_SIZE;
		if (value == "MAX_SIZE")
			return MAX_SIZE;
		if (value == "MAX_LETTERS")
			return MAX_LETTERS;
		else
			return noData;
	}
}