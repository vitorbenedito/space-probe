package com.spaceprobe;

public enum Direction {

	NORTH(0,1), SOUTH(0,-1), EAST(1,0), WEST(-1,0);
	
	private Integer x;
	private Integer y;

	Direction(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
