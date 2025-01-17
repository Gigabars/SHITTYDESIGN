package shitDesign;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import shitDesign.display.display;
import shitDesign.gfx.Assets;
import shitDesign.gfx.ImagesLoading;

public class shitGameDesignVisuals implements Runnable {
//alot of declared variables here
	private display display;
	public String title;
	public String p;
	public int width, height;
	public int centerWidth;
	public int centerHeight;
	private boolean running = false;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;

//object with parameters for our game window
	public shitGameDesignVisuals(String title, int width, int height, String p) {
		this.width = width;
		this.height = height;
		this.title = title;
		this.p = p;
	}

//runs once to initialize everything. creates the canvas size and all of the assets as their own seperate objects
	private void init() {
		display = new display(title, width, height);
		Assets.init();

	}
//for changing tick speed
	private void tick() {

	}

//render the graphics every tick
	private void render() {
		//buffer strategy is so that we do not get frame issues with rendering as it renders 2 ticks ahead
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, width, height);
		// DRAWING SECTION
		//takes image from ImagesLoading and puts it into graphics drawImage function. Check out ImagesLoading Class next.
		g.drawImage(ImagesLoading.currentImageNameMethod(), ImagesLoading.imageStartingPoint()*2, 100, ImagesLoading.currentImageWidth()/2, ImagesLoading.currentImageHeight()/2, null);
		//creates a for loop to go through array of letters
		for (int i = 0; i < Assets.currentLetterSize.size(); i++) {
			//selects the character in the array at and uses a hashmap in Assets to change it into the corresponding letter
			ArrayList<BufferedImage> currentList = Assets.sizeChange.get(String.valueOf(shitDesignGame.p.charAt(i)));
			//takes the buffered image of the current letter
			BufferedImage currentMem = currentList.get(Assets.currentLetterSelection.get(i));
			//bunch of if statements to test if the letter can fit inside of the screen on the x axis or if it needs to make a new row
			if (Assets.sizeIncreaseArray.get(i) + Assets.currentLetterSize.get(i) < 1000) {
				//creates the image. the image starts at wherever the image before it ends
				g.drawImage(currentMem, Assets.sizeIncreaseArray.get(i), (ImagesLoading.currentImageWidth()/2)+100, Assets.currentLetterSize.get(i),
						Assets.currentLetterSize.get(i), null);
			} else if (Assets.sizeIncreaseArray.get(i) + Assets.currentLetterSize.get(i) < 2000) {
				g.drawImage(currentMem, Assets.sizeIncreaseArray.get(i) - ((ImagesLoading.currentImageWidth()/2)+600), (ImagesLoading.currentImageWidth()/2)+300,
						Assets.currentLetterSize.get(i), Assets.currentLetterSize.get(i), null);
			} else if (Assets.sizeIncreaseArray.get(i) + Assets.currentLetterSize.get(i) < 3000) {
				g.drawImage(currentMem, Assets.sizeIncreaseArray.get(i) - ((ImagesLoading.currentImageWidth()/2)+800), (ImagesLoading.currentImageWidth()/2)+500,
						Assets.currentLetterSize.get(i), Assets.currentLetterSize.get(i), null);
			} else if (Assets.sizeIncreaseArray.get(i) + Assets.currentLetterSize.get(i) < 4000) {
				g.drawImage(currentMem, Assets.sizeIncreaseArray.get(i) - ((ImagesLoading.currentImageWidth()/2)+1000), (ImagesLoading.currentImageWidth()/2)+700,
						Assets.currentLetterSize.get(i), Assets.currentLetterSize.get(i), null);
			} else if (Assets.sizeIncreaseArray.get(i) + Assets.currentLetterSize.get(i) < 5000) {
				g.drawImage(currentMem, Assets.sizeIncreaseArray.get(i) - ((ImagesLoading.currentImageWidth()/2)+1200), (ImagesLoading.currentImageWidth()/2)+900,
						Assets.currentLetterSize.get(i), Assets.currentLetterSize.get(i), null);
			} else if (Assets.sizeIncreaseArray.get(i) + Assets.currentLetterSize.get(i) < 6000) {
				g.drawImage(currentMem, Assets.sizeIncreaseArray.get(i) - ((ImagesLoading.currentImageWidth()/2)+1400), (ImagesLoading.currentImageWidth()/2)+1100,
						Assets.currentLetterSize.get(i), Assets.currentLetterSize.get(i), null);
			}
		}
		// END DRAWING
		bs.show();
		g.dispose();
	}

//1. update variables/positions/objects, 2. render everything, 3. repeat
	public void run() {
		init();
		int fps = 5;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			if (delta >= 1) {
				tick();
				render();
				delta--;
			}
		}
		stop();
	}

//start threads
	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

//stop threads
	public synchronized void stop() {
		if (!running) {
			return;
		}
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void mouseDragged(MouseEvent a) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(MouseEvent a) {
		// TODO Auto-generated method stub

	}

}