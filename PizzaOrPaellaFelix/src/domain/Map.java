package domain;

import java.util.Random;

public class Map {

	private int size;
	private String type;

	public Map(int size, String type) {
		this.size = size;
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
