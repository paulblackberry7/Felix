package domain;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Sprite {

	ImageView spriteImg;
	private int type;  //Number that indicate which type of ingredient it is, for example 1=jam, 2=tomato,...
	private int power;
    public boolean isDead = false;
	
	public Sprite(int type, int power, int x, int y) {
		Image image1 = null;
		switch(type) {
			case 1:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("basil.png"));
				break;
			case 2:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("cheese.png"));
				break;
			case 3:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("corn.png"));
				break;
			case 4:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("garlic.png"));
				break;
			case 5:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("green_bean1.png"));
				break;
			case 6:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("green_bean2.png"));
				break;
			case 7:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("meat.png"));
				break;
			case 8:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("mushrooms.png"));
				break;
			case 9:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("olive.png"));
				break;
			case 10:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("onion.png"));
				break;
			case 11:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("peperoni.png"));
				break;
			case 12:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("pepper.png"));
				break;
			case 13:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("rice.png"));
				break;
			case 14:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("rosemary.png"));
				break;
			case 15:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("salame.png"));
				break;
			case 16:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("sausage.png"));
				break;
			case 17:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("tomato.png"));
				break;
			case 18:
				image1 = new Image(getClass().getClassLoader().getResourceAsStream("yellow.png"));
				break;
		}	
		this.type = type;
		this.power = power;
		spriteImg = new ImageView(image1);
		spriteImg.setFitHeight(20);
		spriteImg.setPreserveRatio(true);
		spriteImg.setX(x);
		spriteImg.setY(y);
	}
	
	public ImageView getSpriteImg(){
		return spriteImg;
	}
	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	public void print(){
		System.out.println(type + " has power " + power);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public void setlife(boolean life) {
		isDead = life;
	}
	
	public boolean getlife() {
		return isDead;
	}
		 	
}
