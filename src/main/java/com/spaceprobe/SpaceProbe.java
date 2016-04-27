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
		
		switch (direction) {
			case NORTH: direction = direction.WEST; 
						break;
			case WEST: direction = direction.SOUTH; 
						break;
			case SOUTH: direction = direction.EAST; 
						break;
			case EAST: direction = direction.NORTH; 
						break;
		}

		return this;
	}
	
	public SpaceProbe turnRight(){
		
		switch (direction) {
			case NORTH: direction = direction.EAST; 
						break;
			case EAST: direction = direction.SOUTH; 
						break;
			case SOUTH: direction = direction.WEST; 
						break;
			case WEST: direction = direction.NORTH; 
						break;
		}

		return this;

	}
	
	public SpaceProbe move(){
		
		switch (direction) {
			case NORTH: position.setX( position.getX() - 1 );
						break;
			case EAST:  position.setY( position.getY() + 1 );
						break;
			case SOUTH: position.setX( position.getX() + 1  );
						break;
			case WEST:  position.setY( position.getY() - 1 ); 
						break;
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
