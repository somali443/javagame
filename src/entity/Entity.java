package entity;

import java.awt.image.BufferedImage;

public class Entity {
	public int x,y;
	public int speed;
	
	public  BufferedImage StandstillLeft,StandstillRight,Stand,up,up1,up2,down1,down,down2,left1,left2,right1,right2;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
}
