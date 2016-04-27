package com.spaceprobe;

public enum Direction {

	NORTH(-1,0), SOUTH(1,0), EAST(0,1), WEST(0,-1);
	
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
