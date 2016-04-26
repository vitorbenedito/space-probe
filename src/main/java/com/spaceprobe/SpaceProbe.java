package com.spaceprobe;

public class SpaceProbe {
	
	private final Position position;
	
	private SpaceProbe(Position position) {
		this.position = position;
	}
	
	public static SpaceProbe fromInitialPosition(int x, int y){
		return new SpaceProbe( new Position(x,y) );
	}
	
	public Position getPosition(){
		return position;
	}
	
}
