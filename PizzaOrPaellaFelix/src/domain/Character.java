package domain;

import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

/**
 * @author Pablo
 *
 */
public class Character {

	private String name;
	private String team;
	private int point;
	
	ImageView imagePlayer;
	private double speedY = 0;
	private double speedX = 0;
	private boolean isDead;
	
	/**
	 * @param name
	 * @param team
	 * @param point
	 */
	public Character(String name, String team, int point) {
		isDead=false;
		this.name = name;
		this.team = team;
		this.point = point;
		Image image;
		if(team.contentEquals("Pizza")) {
			image = new Image(getClass().getClassLoader().getResourceAsStream("pizza.png"));
		}else {//here is paella
			image = new Image(getClass().getClassLoader().getResourceAsStream("paella.png"));
		}
		imagePlayer = new ImageView(image);
		imagePlayer.setFitHeight(20);
		imagePlayer.setPreserveRatio(true);
		Random rm = new Random();
		imagePlayer.setX(rm.nextInt(400));
		imagePlayer.setY(rm.nextInt(400));
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(final String team) {
		this.team = team;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	public ImageView getPlayerImg(){
		return imagePlayer;

	}
	
	public boolean checkDead(){
		return isDead;
	}
	
	/**
	 * @param bol
	 */
	public void makedead(boolean bol){
		isDead = bol;
	}
	
	public double playergetY(){
		return speedY;
	}
	
	public double playergetX(){
		return speedX;
	}
	
	public void speed(KeyCode code, double value, int size) {
		switch (code) {
		case RIGHT:
			speedX=speedX + value;
			if(speedY<0)
				speedY=speedY + value/2;
			else if (speedY>0)
				speedY=speedY - value/2;
			break;
		case LEFT:
			speedX=speedX - value ;
			if(speedY<0)
				speedY=speedY + value/2;
			else if (speedY>0)
				speedY=speedY - value/2;
			break;
		case UP:
			speedY=speedY - value;
			if(speedX<0)
				speedX=speedX + value/2;
			else if (speedX>0)
				speedX=speedX - value/2 ;
			break;
		case DOWN:
			speedY=speedY + value;
			if(speedX<0)
				speedX=speedX + value/2;
			else if (speedX>0)
				speedX=speedX - value/2 ;
			break;
		case EQUALS:
			imagePlayer.setFitHeight(imagePlayer.getFitHeight()+10);
			imagePlayer.setPreserveRatio(true);
			imagePlayer.setSmooth(true);
			crash(size);
			break;
		case MINUS:
			imagePlayer.setFitHeight(imagePlayer.getFitHeight()-10);
			imagePlayer.setPreserveRatio(true);
			imagePlayer.setSmooth(true);
			break;

		default:
			// do nothing
		}
	}
	
	public void eat(Sprite sprite,Scene myScene) {
		if (sprite.getSpriteImg().getBoundsInParent().intersects(imagePlayer.getBoundsInParent())) {
			if(imagePlayer.getFitHeight() > sprite.getSpriteImg().getBoundsInLocal().getHeight()*0.8){
				imagePlayer.setFitHeight(imagePlayer.getFitHeight()+sprite.getSpriteImg().getBoundsInLocal().getHeight()/4);
				imagePlayer.setPreserveRatio(true);
				imagePlayer.setSmooth(true);
				checkoverwallexpand(myScene);
				sprite.setlife(true);
				score(sprite.getPower());
			}
			else{
				//isDead = true;
			}
		}
	}
	
	/**
	 * @param size
	 */
	public void crash(int size) {
		if(imagePlayer.getX() > size - imagePlayer.getBoundsInLocal().getWidth())
			speedX = -1*speedX;
		if(imagePlayer.getX() < 0)
			speedX = -1*speedX;
		if(imagePlayer.getY()> size - imagePlayer.getBoundsInLocal().getHeight())
			speedY = -1*speedY;
		if(imagePlayer.getY() < 0)
			speedY = -1*speedY;
	}
	
	/**
	 * @param size
	 */
	public void move(int size) {
		imagePlayer.setX(imagePlayer.getX() + speedX);
		imagePlayer.setY(imagePlayer.getY() + speedY);
		crash(size);
	}
	
	/**
	 * @return
	 */
	public boolean winOrLose() {
		boolean flag;
		if(isDead) {
			flag= false;
		}else {
			flag= true;
		}
		return flag;
	}
	
	/**
	 * @param points
	 */
	public void score(int points) {
		setPoint(getPoint()+points);
	}
	
	/**
	 * 
	 */
	public void share() {
		
	}
	
	/**
	 * 
	 */
	public void selectMap() {
		
	}
	
	/**
	 * 
	 */
	public void upgrade() {
		Image image;
		if(getTeam().contentEquals("Pizza")) {
			/*if(getPoint() >= 20) {
				image = new Image(getClass().getClassLoader().getResourceAsStream("step_1.png"));
				getPlayerImg().setImage(image);
			}else if(getPoint() >= 40) {
				image = new Image(getClass().getClassLoader().getResourceAsStream("step_2.png"));
				getPlayerImg().setImage(image);
			}else if(getPoint() >= 60) {
				image = new Image(getClass().getClassLoader().getResourceAsStream("step_3.png"));
				getPlayerImg().setImage(image);
			}else if(getPoint() >= 80) {
				image = new Image(getClass().getClassLoader().getResourceAsStream("step_4.png"));
				getPlayerImg().setImage(image);
			}else if(getPoint() >= 100) {
				image = new Image(getClass().getClassLoader().getResourceAsStream("step_5.png"));
				getPlayerImg().setImage(image);
			}*/
			image = new Image(getClass().getClassLoader().getResourceAsStream("step_5.png"));
			getPlayerImg().setImage(image);
		}else {
			/*if(getPoint() >= 20) {
				image = new Image(getClass().getClassLoader().getResourceAsStream("paella_step_1.png"));
				getPlayerImg().setImage(image);
			}else if(getPoint() >= 40) {
				image = new Image(getClass().getClassLoader().getResourceAsStream("paella_step_2.png"));
				getPlayerImg().setImage(image);
			}else if(getPoint() >= 60) {
				image = new Image(getClass().getClassLoader().getResourceAsStream("paella_step_3.png"));
				getPlayerImg().setImage(image);
			}else if(getPoint() >= 80) {
				image = new Image(getClass().getClassLoader().getResourceAsStream("paella_step_4.png"));
				getPlayerImg().setImage(image);
			}else if(getPoint() >= 100) {
				image = new Image(getClass().getClassLoader().getResourceAsStream("paella_step_5.png"));
				getPlayerImg().setImage(image);
			}*/
			image = new Image(getClass().getClassLoader().getResourceAsStream("paella_step_5.png"));
			getPlayerImg().setImage(image);
		}
	}
	
	/**
	 * 
	 */
	public void chooseTeam() {
		
	}
	
	/**
	 * 
	 */
	public void access() {
		
	}
	
	/**
	 * @param myScene
	 */
	private void checkoverwallexpand(Scene myScene) {
		if( imagePlayer.getX()+imagePlayer.getBoundsInLocal().getWidth()>myScene.getWidth())
			imagePlayer.setX(myScene.getWidth()-imagePlayer.getBoundsInLocal().getWidth());
		if( imagePlayer.getY()+imagePlayer.getBoundsInLocal().getHeight()>myScene.getHeight())
			imagePlayer.setY(myScene.getHeight()-imagePlayer.getBoundsInLocal().getHeight());
		if( imagePlayer.getX()+imagePlayer.getBoundsInLocal().getWidth()<0)
			imagePlayer.setX(0);
		if( imagePlayer.getY()+imagePlayer.getBoundsInLocal().getHeight()<0)
			imagePlayer.setY(0);
	}
	
}
