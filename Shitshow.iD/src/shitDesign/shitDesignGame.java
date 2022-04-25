package shitDesign;

import java.util.ArrayList;
import java.util.Scanner;

import shitDesign.gfx.Assets;
import shitDesign.gfx.ImagesLoading;

public class shitDesignGame {
	public static String p;
	static ArrayList<Character> inputLine = new ArrayList<>();
	public static void main(String[] args) {
		System.out.println("Begining initial image selection ");
		ImagesLoading a = new ImagesLoading();  
		a.initialize(); 
		System.out.println("Image has been selected");
		Scanner s = new Scanner(System.in);
		System.out.println("Print your text here: ");
		p = s.nextLine();
		shitGameDesignVisuals StartSim = new shitGameDesignVisuals("Visualization of Path Finding", 1000, 1000, p);
		StartSim.start();
	}

}
  