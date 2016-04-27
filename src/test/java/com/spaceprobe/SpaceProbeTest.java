package com.spaceprobe;

import org.junit.Test;

import junit.framework.TestCase;

public class SpaceProbeTest extends TestCase {
	
	private static final int INITIAL_POSITION_X = 1;
	private static final int INITIAL_POSITION_Y = 3;
	
	@Test
	public void testCreateSondaOnInitialPosition(){
		SpaceProbe spaceProbe = SpaceProbe.start(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.NORTH);
		assertEquals(spaceProbe.getPosition().getX(), INITIAL_POSITION_X);
		assertEquals(spaceProbe.getPosition().getY(), INITIAL_POSITION_Y);
	}
	
	@Test
	public void testCreateSondaOnInitialPositionAndInitialDirection(){
		SpaceProbe spaceProbe = SpaceProbe.start(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.SOUTH);
		assertEquals(spaceProbe.getPosition().getX(), INITIAL_POSITION_X);
		assertEquals(spaceProbe.getPosition().getY(), INITIAL_POSITION_Y);
		assertEquals(spaceProbe.getDirection(), Direction.SOUTH);
	}
	
	@Test
	public void testTurnSondaToTheLeft(){
		SpaceProbe spaceProbe = SpaceProbe.start(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.SOUTH)
										  .turnLeft();
		
		assertEquals(spaceProbe.getPosition().getX(), INITIAL_POSITION_X);
		assertEquals(spaceProbe.getPosition().getY(), INITIAL_POSITION_Y);
		assertEquals(spaceProbe.getDirection(), Direction.EAST);
	}
	
	@Test
	public void testTurnSondaToTheRight(){
		SpaceProbe spaceProbe = SpaceProbe.start(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.SOUTH)
										  .turnRight();
		
		assertEquals(spaceProbe.getPosition().getX(), INITIAL_POSITION_X);
		assertEquals(spaceProbe.getPosition().getY(), INITIAL_POSITION_Y);
		assertEquals(spaceProbe.getDirection(), Direction.WEST);
	}
	
	@Test
	public void testTurnToTheAllDirections(){
		SpaceProbe spaceProbe = SpaceProbe.start(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.SOUTH);
		
		assertEquals(spaceProbe.turnRight().getDirection(), Direction.WEST);
		assertEquals(spaceProbe.turnRight().getDirection(), Direction.NORTH);
		assertEquals(spaceProbe.turnRight().getDirection(), Direction.EAST);
		assertEquals(spaceProbe.turnRight().getDirection(), Direction.SOUTH);
		
		assertEquals(spaceProbe.turnLeft().getDirection(), Direction.EAST);
		assertEquals(spaceProbe.turnLeft().getDirection(), Direction.NORTH);
		assertEquals(spaceProbe.turnLeft().getDirection(), Direction.WEST);
		assertEquals(spaceProbe.turnLeft().getDirection(), Direction.SOUTH);

	}
	
	@Test
	public void testMoveAheadToSouth(){
		SpaceProbe spaceProbe = SpaceProbe.start(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.SOUTH).move();
		
		assertEquals(spaceProbe.getPosition().getX(), INITIAL_POSITION_X);
		assertEquals(spaceProbe.getPosition().getY(), INITIAL_POSITION_Y - 1);
	}
	
	@Test
	public void testMoveAheadToAllDirections(){
		SpaceProbe spaceProbe = SpaceProbe.start(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.SOUTH).move();

		assertEquals(spaceProbe.getPosition().getX(), 1);
		assertEquals(spaceProbe.getPosition().getY(), 2);
		
		spaceProbe.turnRight().move();
		
		assertEquals(spaceProbe.getPosition().getX(), 0);
		assertEquals(spaceProbe.getPosition().getY(), 2);
		
		spaceProbe.turnRight().move();
		
		assertEquals(spaceProbe.getPosition().getX(), 0);
		assertEquals(spaceProbe.getPosition().getY(), 3);
		
		spaceProbe.turnRight().move();

		assertEquals(spaceProbe.getPosition().getX(), 1);
		assertEquals(spaceProbe.getPosition().getY(), 3);
	}
	
	@Test
	public void testSendCommandToProbe(){
		
		SpaceProbe spaceProbe = SpaceProbe.start(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.NORTH);
		
		spaceProbe.sendCommand("L");
		spaceProbe.sendCommand("R");
		spaceProbe.sendCommand("M");
		
		assertEquals(spaceProbe.getPosition().getX(), 1);
		assertEquals(spaceProbe.getPosition().getY(), 4);
		
	}
	
}
