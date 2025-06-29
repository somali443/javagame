package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;


public class GamePanel extends JPanel implements Runnable{
	// SCREEN SETTING 
	final int originalTitlesize = 16 ; //16x16 pixels
	final int scale = 3;
	public final int tileSize = originalTitlesize * scale;
	
	final int maxScreenCol = 18;
	final int maxScreenRow = 14;
	final int screenWidth = tileSize * maxScreenCol; // 768 Pixels
	final int screenHeight = tileSize * maxScreenRow; // 576 Pixels
	
	//FPS
	int FPS = 60;
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Player player = new Player(this,keyH);

	// player's default position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void run() {
		
		double drawInterval = 1000000000/FPS;//0.016666 second
		double nextDrawTime = System.nanoTime() + drawInterval;
		int framecount = 0;
		long timer = System.currentTimeMillis();
		
		while(gameThread != null) {
			long currentTime = System.nanoTime();
			// 1update: update information such as character positions
			update();
			
			// 2draw : draw the screen with update information 
			repaint();
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				if(remainingTime < 0) {
					remainingTime = 0;
				}

				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
				
			framecount++;
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("fps: "+ framecount);
				framecount = 0;
				timer +=1000;
			}
			
		}
	}
	
	public void update() {
		player.update();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		player.draw(g2);
		g2.dispose();
	}
	
}
