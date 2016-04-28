package com.spaceprobe;

import java.util.UUID;

import org.apache.log4j.Logger;

public class SpaceProbe {
	
	private static final Logger logger = Logger.getLogger(SpaceProbe.class);
	
	private String id;
	
	private final Position position;
	
	private Direction direction;
	
	private SpaceProbe(Position position, Direction direction, String id) {
		this.position = position;
		this.direction = direction;
		this.id = id;
	}
	
	public static SpaceProbe start(int x, int y, Direction direction){
		logger.debug( "Start position x,y: " + x + "," + y );
		logger.debug( "Start direction: " + direction );
		return new SpaceProbe( new Position(x,y), direction, UUID.randomUUID().toString());
	}
	
	public SpaceProbe turnLeft(){
		
		switch (direction) {
			case N: direction = direction.W; 
						break;
			case W: direction = direction.S; 
						break;
			case S: direction = direction.E; 
						break;
			case E: direction = direction.N; 
						break;
		}
		
		logger.debug( "Turn to the left: " + direction);

		return this;
	}
	
	public SpaceProbe turnRight(){
		
		switch (direction) {
			case N: direction = direction.E; 
						break;
			case E: direction = direction.S; 
						break;
			case S: direction = direction.W; 
						break;
			case W: direction = direction.N; 
						break;
		}
		
		logger.debug( "Turn to the right: " + direction);

		return this;

	}
	
	public SpaceProbe move(){
		
		position.setX( position.getX() + direction.getX() );
		position.setY( position.getY() + direction.getY() );
		
		logger.debug( "Move to the direction: " + direction + ", position x,y: " + position.getX() + "," + position.getY() );
		
		return this;
	}
	
	public String sendCommand(String command) {
		
		logger.debug("Command: " + command);
		
		if(command.equals( "L" )){
			turnLeft();
		}else if(command.equals("R")){
			turnRight();
		}else if(command.equals("M")){
			move();
		}
		
		String actualPosition = position.getX() + " " + position.getY() + " " + direction;
		
		logger.debug(actualPosition);
		
		return actualPosition;

	}
	
	public Position getPosition(){
		return position;
	}
	
	public Direction getDirection(){
		return direction;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
