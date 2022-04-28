package shitDesign;

import java.util.Scanner;
import java.util.*;

import shitDesign.gfx.ImagesLoading;

public class shitDesignGame {
	// initialization of some variables used in main
	public static String p;

	// main function, program begins here
	public static void main(String[] args) {
		System.out.println("Beginning initial image selection ");
		// uses the image loading method from c-sharpcorner.com to give a prompt to
		// upload an image
		ImagesLoading a = new ImagesLoading();
		a.initialize();
		// finishes uploading the image and gives prompt for what your are to input
		System.out.println("Image has been selected");
		Scanner s = new Scanner(System.in);
		System.out.println("Print your text here: ");
		// uses scanner to get the input
		String tempLine = s.nextLine();
		// removes punctuation
		p = tempLine.replaceAll("[\\W]", "");
		// removes numbers
		p = p.replaceAll("[\\d]", "");
		// sets all to lowercase
		p = p.toLowerCase();
		// sends the name and size of canvas as well as your input to the visuals
		// section
		shitGameDesignVisuals StartSim = new shitGameDesignVisuals("Visualization of Path Finding", 1000, 1000, p);
		StartSim.start();
		s.close();
	}

}