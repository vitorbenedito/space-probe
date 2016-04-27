package com.spaceprobe;

public class SpaceProbe {
	
	private final Position position;
	private Direction direction;
	
	private SpaceProbe(Position position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}
	
	public static SpaceProbe fromInitialPosition(int x, int y, Direction direction){
		return new SpaceProbe( new Position(x,y), direction);
	}
	
	public SpaceProbe turnLeft(){
		
		if(direction.equals(Direction.SOUTH)){
			direction = Direction.EAST;
		}
		
		return this;
	}
	
	public SpaceProbe turnRight(){
		
		if(direction.equals(Direction.SOUTH)){
			direction = Direction.WEST;
		}
		
		return this;
	}
	
	public Position getPosition(){
		return position;
	}
	
	public Direction getDirection(){
		return direction;
	}
	
}
