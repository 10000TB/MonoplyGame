package model;

public abstract class Tile {

	private String type;
	private String description;
	private int position;

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setDesc(String description) {
		this.description = description;
	}

	public void setType(String type) {
		this.type = type;
	}

}