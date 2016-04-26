package com.spaceprobe;

import org.junit.Test;

import junit.framework.TestCase;

public class SpaceProbeTest extends TestCase {
	
	private static final int INITIAL_POSITION_X = 1;
	private static final int INITIAL_POSITION_Y = 10;
	
	@Test
	public void testCreateSondaOnInitialPosition(){
		
		SpaceProbe spaceProbe = SpaceProbe.fromInitialPosition(INITIAL_POSITION_X, INITIAL_POSITION_Y);
		assertEquals(spaceProbe.getPosition().getX(), INITIAL_POSITION_X);
		assertEquals(spaceProbe.getPosition().getY(), INITIAL_POSITION_Y);
		
	}

}
