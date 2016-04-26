package com.spaceprobe;

import org.junit.Test;

import junit.framework.TestCase;

public class SpaceProbeTest extends TestCase {
	
	private static final int INITIAL_POSITION_X = 1;
	private static final int INITIAL_POSITION_Y = 10;
	
	@Test
	public void testCreateSondaOnInitialPosition(){
		SpaceProbe spaceProbe = SpaceProbe.fromInitialPosition(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.NORTH);
		assertEquals(spaceProbe.getPosition().getX(), INITIAL_POSITION_X);
		assertEquals(spaceProbe.getPosition().getY(), INITIAL_POSITION_Y);
	}
	
	@Test
	public void testCreateSondaOnInitialPositionAndInitialDirection(){
		SpaceProbe spaceProbe = SpaceProbe.fromInitialPosition(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.SOUTH);
		assertEquals(spaceProbe.getPosition().getX(), INITIAL_POSITION_X);
		assertEquals(spaceProbe.getPosition().getY(), INITIAL_POSITION_Y);
		assertEquals(spaceProbe.getDirection(), Direction.SOUTH);
	}
	
	@Test
	public void testTurnSondaToTheLeft(){
		SpaceProbe spaceProbe = SpaceProbe.fromInitialPosition(INITIAL_POSITION_X, INITIAL_POSITION_Y, Direction.SOUTH)
										  .turnSpaceProbe(Turn.LEFT);
		
		assertEquals(spaceProbe.getPosition().getX(), INITIAL_POSITION_X);
		assertEquals(spaceProbe.getPosition().getY(), INITIAL_POSITION_Y);
		assertEquals(spaceProbe.getDirection(), Direction.EAST);
	}

}
