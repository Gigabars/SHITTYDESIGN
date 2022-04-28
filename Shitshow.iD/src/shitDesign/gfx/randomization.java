package shitDesign.gfx;

import java.io.IOException;

import shitDesign.PropLoader;

public class randomization {
	public static int randomBufferedSelection() {
		int min = 0;
		PropLoader prop = new PropLoader();
		int max = prop.getProp("MAX_LETTERS");
		max--;
		int randomBufferedImage = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return randomBufferedImage;
	}

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
