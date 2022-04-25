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

public class ImagesLoading implements ActionListener {
	public static String currentImageName;
	String imageName;
	static JFrame fr = new JFrame("Image loading program Using awt");
	Label Label1 = new Label("Choose your image");
	Button Button1 = new Button("select");
	public Image Image1;
	imageLoad Canvas1;
	static FileDialog fd = new FileDialog(fr, "Open", FileDialog.LOAD);

	public void initialize() {
		fr.setSize(500, 500);
		fr.setLocation(200, 200);
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
	public static int currentImageWidth() {
		int imageWidth = currentImageNameMethod().getWidth();
		return imageWidth;
	}
	public static int imageStartingPoint() {
		int startingPoint = (1000-(currentImageWidth()))/2;
		return startingPoint;
	}
	public static int currentImageHeight() {
		int imageHeight = currentImageNameMethod().getHeight();
		return imageHeight;
	}
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
			imageload();
			currentImageNameMethod();
		}
	}
	
}