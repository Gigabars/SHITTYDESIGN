package shitDesign;

import java.util.Scanner;

public class shitDesignGame {
//renders a doggo right now, not a pretty one tho :)
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Print your text here: ");
		String p = s.nextLine();
		shitGameDesignVisuals StartSim = new shitGameDesignVisuals("Visualization of Path Finding", 1000, 1000, p);
		StartSim.start();
	}

}
