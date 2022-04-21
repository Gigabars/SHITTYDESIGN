package shitDesign;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import shitDesign.display.display;
import shitDesign.gfx.Assets;

public class shitGameDesignVisuals implements Runnable {

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

//runs once to initialize everything
	private void init() {
		display = new display(title, width, height);
		Assets.init();

	}

	private void tick() {

	}

//render the graphics
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, width, height);
		// DRAWING
		for (int i = 0; i < Assets.currentLetterSize.size(); i++) {
			ArrayList<BufferedImage> currentList = Assets.sizeChange.get(String.valueOf(shitDesignGame.p.charAt(i)));
			BufferedImage currentMem = currentList.get(Assets.currentLetterSelection.get(i));
			if (Assets.sizeIncreaseArray.get(i) + Assets.currentLetterSize.get(i) < 1000) {
				g.drawImage(currentMem, Assets.sizeIncreaseArray.get(i), 0, Assets.currentLetterSize.get(i),
						Assets.currentLetterSize.get(i), null);
			} else if (Assets.sizeIncreaseArray.get(i) + Assets.currentLetterSize.get(i) < 2000) {
				g.drawImage(currentMem, Assets.sizeIncreaseArray.get(i) - 1000, 200,
						Assets.currentLetterSize.get(i), Assets.currentLetterSize.get(i), null);
			} else if (Assets.sizeIncreaseArray.get(i) + Assets.currentLetterSize.get(i) < 3000) {
				g.drawImage(currentMem, Assets.sizeIncreaseArray.get(i) - 2000, 400,
						Assets.currentLetterSize.get(i), Assets.currentLetterSize.get(i), null);
			} else if (Assets.sizeIncreaseArray.get(i) + Assets.currentLetterSize.get(i) < 4000) {
				g.drawImage(currentMem, Assets.sizeIncreaseArray.get(i) - 3000, 600,
						Assets.currentLetterSize.get(i), Assets.currentLetterSize.get(i), null);
			} else if (Assets.sizeIncreaseArray.get(i) + Assets.currentLetterSize.get(i) < 5000) {
				g.drawImage(currentMem, Assets.sizeIncreaseArray.get(i) - 4000, 800,
						Assets.currentLetterSize.get(i), Assets.currentLetterSize.get(i), null);
			} else if (Assets.sizeIncreaseArray.get(i) + Assets.currentLetterSize.get(i) < 6000) {
				g.drawImage(currentMem, Assets.sizeIncreaseArray.get(i) - 5000, 1000,
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

		while (running) {
			tick();
			render();
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
//* UPDATES 7 need to find a way to use events to create lines
// when drawing, y axis is flipped so (0, 0) is at the top left and the y coords go down
// synchronized is used specifically with threads to make sure everything works
// correctly (look into how threads work)
// get good at using awt graphics (its how everything is drawn)