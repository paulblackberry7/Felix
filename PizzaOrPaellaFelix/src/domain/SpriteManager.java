package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Manager class for the sprite circles. Deal with add and removing and keeping 
 * them in order
 * 
 * @author Parit Burintrathikul
 */
public class SpriteManager {

	private  List<Sprite> allSprites = new ArrayList<>();
	private  Set<Sprite> spritestokill = new HashSet<>();

	/** as named
	 * 
	 * @return
	 */
	public  List<Sprite> getAllSprites() {
		return allSprites;
	}

	/**add circles
	 * 
	 * @param sprites
	 */
	public void addSprites(Sprite... sprites) {       
		allSprites.addAll(Arrays.asList(sprites));
	}

	/**get list to remove
	 * 
	 * @return
	 */
	public Set<Sprite> getSpritesToBeRemoved() {
		return spritestokill;
	}

	/**add to list to remove
	 * 
	 * @param sprites
	 */
	public void addSpritesToBeRemoved(Sprite... sprites) {
		if (sprites.length > 1) {
			spritestokill.addAll(Arrays.asList((Sprite[]) sprites));
		} else {
			spritestokill.add(sprites[0]);
		}
	}

	/**remove circles as in list
	 * 
	 */
	public void cleanupSprites() {
		allSprites.removeAll(spritestokill);
		spritestokill.clear();
	}
}
