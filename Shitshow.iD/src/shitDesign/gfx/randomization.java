package shitDesign.gfx;

public class randomization {
	public static int randomBufferedSelection() {
		int min = 0;
		int max = 5;
		int randomBufferedImage = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return randomBufferedImage;
	}

	public static int randomSizeSelection() {
		int min = 50;
		int max = 200;
		int randomSizeInt = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return randomSizeInt;
	}
}
