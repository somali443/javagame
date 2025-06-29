package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp,KeyHandler keyH){
		this.gp = gp;
		this.keyH = keyH;
		setDefaultValues();
		getPlayerImagre();
	}
	public void setDefaultValues() {
		x = 200;
		y = 200;
		speed = 4;
		direction = "Stand";
	}
	public void getPlayerImagre() {
<<<<<<< HEAD
		try {
			Stand =  ImageIO.read(getClass().getResourceAsStream("/player/kalashnikov pendragonpixel.png"));
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/back1.png"));
			up =ImageIO.read(getClass().getResourceAsStream("/player/back.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/back2.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/player/down1.5.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/ngangSangtrai1.png"));
			StandstillLeft = ImageIO.read(getClass().getResourceAsStream("/player/ngangDungYenhuongbentrai.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/ngangSangtrai2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/ngangSangphai1.png"));
			StandstillRight = ImageIO.read(getClass().getResourceAsStream("/player/ngangDungYenhuongbenphai.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/ngangSangphai2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
=======
//		try {
			Stand =  ImageIO.read(getClass().getResourceAsStream("/res/player/kalashnikov pendragonpixel.png"));
			up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/back1.png"));
			up =ImageIO.read(getClass().getResourceAsStream("/res/player/back.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/back2.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/res/player/down1.5.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/down2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/ngangSangtrai1.png"));
			StandstillLeft = ImageIO.read(getClass().getResourceAsStream("/res/player/ngangDungYenhuongbentrai.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/ngangSangtrai2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/ngangSangphai1.png"));
			StandstillRight = ImageIO.read(getClass().getResourceAsStream("/res/player/ngangDungYenhuongbenphai.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/ngangSangphai2.png"));
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
>>>>>>> a14dfad (cap nhat)
	}
	
	public void update() {
		
		if(keyH.upPressed == true||keyH.downPressed == true||keyH.leftPressed==true||keyH.rightPressed==true)
		{	
		
		if(keyH.upPressed == true) {
			direction = "up";
			y -= speed;
		}else if(keyH.downPressed == true) {
			direction = "down";
			y += speed;
		}else if(keyH.leftPressed == true) {
			direction = "left";
			x -= speed;
		}else if(keyH.rightPressed == true) {
			direction = "right";
			x += speed;
		}
		spriteCounter++;
		if (spriteCounter > 20) {
		    spriteNum++;
		    if (spriteNum > 3) {
		        spriteNum = 1;
		    }
		    spriteCounter = 0;
		}
//		else {
//			switch (direction) {
//			case "up":
//				direction = "Standup";
//				break;
//			case "down":
//				direction = "Standdown";
//				break;
//			case "left":
//				direction = "Standleft";
//				break;
//			case "right" :
//				direction = "Standright";
//				break;
//			
//			}
//			spriteNum = 1;
//		}
	}
}

	public void draw(Graphics g2) {
//		g2.setColor(Color.white);
//		g2.fillRect(x,y,gp.tileSize,gp.tileSize);
		BufferedImage image = null;
		
		switch(direction) {
		case "Stand":
			if(spriteNum ==1) {
				image = Stand;
			}
			break;
//		case "Standup":
//			image = up;
//			break;
//		case "Standdown":
//			image = Stand;
//			break;
//		case "Standleft":
//			image = StandstillLeft;
//			
//			break;
//		case "Standright":
//			image = StandstillRight;
//			break;
		case "up":
			if(spriteNum ==1) {
				image = up1;
			}
			else if(spriteNum ==2||spriteNum ==4) {
				image = up;
			}
			else if(spriteNum ==3) {
				image = up2;
			}

			break;
		case "down":
			if(spriteNum ==1) {
				image = down1;
			}
			if(spriteNum ==2) {
				image = down;
			}
			if(spriteNum ==3) {
				image = down2;
			}
			if(spriteNum ==4) {
				image = Stand;
			}
			break;
		case "left":
			if(spriteNum ==1) {
				image = left1;
			}
			if(spriteNum ==2) {
				image = StandstillLeft;
			}
			if(spriteNum ==3) {
				image = left2;
			}
			if(spriteNum ==4) {
				image = StandstillLeft;
			}
			break;
		case "right":
			if(spriteNum ==1) {
				image = right1;
			}
			if(spriteNum ==2) {
				image = StandstillRight;
			}
			if(spriteNum ==3) {
				image = right2;
			}
			if(spriteNum ==4) {
				image = StandstillRight;
			}
			break;
		}
		g2.drawImage(image, x, y,gp.tileSize,gp.tileSize,null);
		
		
	}
}
