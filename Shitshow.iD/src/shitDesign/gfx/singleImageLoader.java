package shitDesign.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class singleImageLoader {
	public static BufferedImage singleImageInput(String singlePath){
	try {
		return ImageIO.read(new File(singlePath));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
}