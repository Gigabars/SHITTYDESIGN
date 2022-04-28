package shitDesign.gfx;

import java.io.IOException;

import shitDesign.PropLoader;

public class randomization {
	//selects a random number from 0 to 5 for which of the of that kind of letter we will take
	public static int randomBufferedSelection() {
		int min = 0;
		PropLoader prop = new PropLoader();
		int max = prop.getProp("MAX_LETTERS");
		max--;
		int randomBufferedImage = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return randomBufferedImage;
	}
	//chooses a size from 50 to 200 so that way it has different sizes per letter
	public static int randomSizeSelection() {
		//Sets the random size of the images.
		PropLoader prop = new PropLoader();
		try {
			prop.loadProps();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int min = prop.getProp("MIN_SIZE");
		int max = prop.getProp("MAX_SIZE");
		int randomSizeInt = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return randomSizeInt;
	}
}