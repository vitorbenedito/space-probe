package com.spaceprobe.model;

import org.junit.Test;

import com.spaceprobe.Direction;
import com.spaceprobe.SpaceProbe;

import junit.framework.TestCase;

public class SpaceProbeTest extends TestCase {
	
	private static final int INITIAL_POSITION_X = 1;
	private static final int INITIAL_POSITION_Y = 3;
	
	@Test
	public void testCreateSondaOnInitialPosition(){
		SpaceProbe spaceProbe = SpaceProbe.start(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.N);
		assertEquals(spaceProbe.getPosition().getX(), INITIAL_POSITION_X);
		assertEquals(spaceProbe.getPosition().getY(), INITIAL_POSITION_Y);
	}
	
	@Test
	public void testCreateSondaOnInitialPositionAndInitialDirection(){
		SpaceProbe spaceProbe = SpaceProbe.start(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.S);
		assertEquals(spaceProbe.getPosition().getX(), INITIAL_POSITION_X);
		assertEquals(spaceProbe.getPosition().getY(), INITIAL_POSITION_Y);
		assertEquals(spaceProbe.getDirection(), Direction.S);
	}
	
	@Test
	public void testTurnSondaToTheLeft(){
		SpaceProbe spaceProbe = SpaceProbe.start(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.S)
										  .turnLeft();
		
		assertEquals(spaceProbe.getPosition().getX(), INITIAL_POSITION_X);
		assertEquals(spaceProbe.getPosition().getY(), INITIAL_POSITION_Y);
		assertEquals(spaceProbe.getDirection(), Direction.E);
	}
	
	@Test
	public void testTurnSondaToTheRight(){
		SpaceProbe spaceProbe = SpaceProbe.start(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.S)
										  .turnRight();
		
		assertEquals(spaceProbe.getPosition().getX(), INITIAL_POSITION_X);
		assertEquals(spaceProbe.getPosition().getY(), INITIAL_POSITION_Y);
		assertEquals(spaceProbe.getDirection(), Direction.W);
	}
	
	@Test
	public void testTurnToTheAllDirections(){
		SpaceProbe spaceProbe = SpaceProbe.start(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.S);
		
		assertEquals(spaceProbe.turnRight().getDirection(), Direction.W);
		assertEquals(spaceProbe.turnRight().getDirection(), Direction.N);
		assertEquals(spaceProbe.turnRight().getDirection(), Direction.E);
		assertEquals(spaceProbe.turnRight().getDirection(), Direction.S);
		
		assertEquals(spaceProbe.turnLeft().getDirection(), Direction.E);
		assertEquals(spaceProbe.turnLeft().getDirection(), Direction.N);
		assertEquals(spaceProbe.turnLeft().getDirection(), Direction.W);
		assertEquals(spaceProbe.turnLeft().getDirection(), Direction.S);

	}
	
	@Test
	public void testMoveAheadToSouth(){
		SpaceProbe spaceProbe = SpaceProbe.start(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.S).move();
		
		assertEquals(spaceProbe.getPosition().getX(), INITIAL_POSITION_X);
		assertEquals(spaceProbe.getPosition().getY(), INITIAL_POSITION_Y - 1);
	}
	
	@Test
	public void testMoveAheadToAllDirections(){
		SpaceProbe spaceProbe = SpaceProbe.start(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.S).move();

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
		
		SpaceProbe spaceProbe = SpaceProbe.start(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.N);
		
		spaceProbe.sendCommand("L");
		spaceProbe.sendCommand("R");
		spaceProbe.sendCommand("M");
		
		assertEquals(spaceProbe.getPosition().getX(), 1);
		assertEquals(spaceProbe.getPosition().getY(), 4);
		
	}
	
}
