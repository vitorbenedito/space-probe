package com.spaceprobe;

public class SpaceProbe {
	
	private final Position position;
	private Direction direction;
	
	private SpaceProbe(Position position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}
	
	public static SpaceProbe start(int x, int y, Direction direction){
		System.out.println( "Start position x,y: " + x + "," + y );
		System.out.println( "Start direction: " + direction );
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
		
		System.out.println( "Turn to the left: " + direction);

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
		
		System.out.println( "Turn to the right: " + direction);

		return this;

	}
	
	public SpaceProbe move(){
		
		position.setX( position.getX() + direction.getX() );
		position.setY( position.getY() + direction.getY() );
		
		System.out.println( "Move to the direction: " + direction + ", position x,y: " + position.getX() + "," + position.getY() );
		
		return this;
	}
	
	public void sendCommand(String command) {
		
		System.out.println("Command: " + command);
		
		if(command.equals( "L" )){
			turnLeft();
		}else if(command.equals("R")){
			turnRight();
		}else if(command.equals("M")){
			move();
		}
		
		System.out.println(position.getX() + " " + position.getY() + " " + direction);

	}
	
	public Position getPosition(){
		return position;
	}
	
	public Direction getDirection(){
		return direction;
	}
	
}
