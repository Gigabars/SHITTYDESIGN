package shitDesign.gfx;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.InputMethodEvent;
//creates the image on the canvas every time it is changed
class imageLoad extends Canvas {
	Image img;

	public imageLoad(Image img) {
		this.img = img;
	}

	public void paint(Graphics g) {
		if (img != null) {
			g.drawImage(img, 100, 100, 400, 400, this);
		}
	}

	public void setImage(Image img) {
		this.img = img;
	}
}
//actual meat and potatoes of image loading
public class ImagesLoading implements ActionListener {
	//creates all the variables that will be used in the prompt for uploading an image
	public static String currentImageName;
	String imageName;
	static JFrame fr = new JFrame("Image loading program Using awt");
	Label Label1 = new Label("Choose your image");
	Button Button1 = new Button("select");
	public Image Image1;
	imageLoad Canvas1;
	static FileDialog fd = new FileDialog(fr, "Open", FileDialog.LOAD);
//creates the initial prompt window
	public void initialize() {
		fr.setSize(1000, 1000);
		fr.setLocation(500, 200);
		fr.setBackground(Color.lightGray);
		fr.setLayout(new FlowLayout());
		fr.add(Label1);
		fr.add(Button1);
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Button1.addActionListener(this);
		Canvas1 = new imageLoad(null);
		Canvas1.setSize(1000, 1000);
		fr.add(Canvas1);
		fr.show();
	}
	//takes file from prompt and if it is able to read the file it returns the file
	public static BufferedImage currentImageNameMethod(){
		currentImageName = (fd.getDirectory() + fd.getFile());
		try {
			BufferedImage imageNameTry = ImageIO.read(new File(currentImageName));
			return imageNameTry;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//image width for scaling in .visuals
	public static int currentImageWidth() {
		int imageWidth = currentImageNameMethod().getWidth();
		return imageWidth;
	}
	//image starting point for scaling in .visuals
	public static int imageStartingPoint() {
		int startingPoint = (1000-(currentImageWidth()))/2;
		return startingPoint;
	}
	//image height for scaling in .visuals
	public static int currentImageHeight() {
		int imageHeight = currentImageNameMethod().getHeight();
		return imageHeight;
	}
	//actual method for the upload button
	void imageload() {
		fd.show();
		if (fd.getFile() == null) {
			Label1.setText("You have not select");
		} else {
			String d = (fd.getDirectory() + fd.getFile());
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image1 = toolkit.getImage(d);
			imageName = fd.getFile();
			Canvas1.setImage(Image1);
			Canvas1.repaint();
		}
	}
	//event spam down here
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	public void actionPerformed(ActionEvent event) {
		Button b = (Button) event.getSource();
		if (b == Button1) {
			//when the button is pressed the image is loaded onto the page and sent back to visuals (back to visuals we go!)
			imageload();
			currentImageNameMethod();
		}
	}
	
}