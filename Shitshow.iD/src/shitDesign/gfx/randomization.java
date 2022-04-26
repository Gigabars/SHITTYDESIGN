package shitDesign.gfx;

public class randomization {
	//selects a random number from 0 to 5 for which of the of that kind of letter we will take
	public static int randomBufferedSelection() {
		int min = 0;
		int max = 5;
		int randomBufferedImage = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return randomBufferedImage;
	}
	//chooses a size from 50 to 200 so that way it has different sizes per letter
	public static int randomSizeSelection() {
		int min = 50;
		int max = 200;
		int randomSizeInt = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return randomSizeInt;
	}
}