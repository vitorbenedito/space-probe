package com.spaceprobe;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class NasaTest extends TestCase {

	@Test
	public void testLaunchSpaceProbeWithCoordanates() {
		
		Nasa nasa = new Nasa();
		
		nasa.launchSpaceProbeWithCoordanates(CoordanatesFeature.getCoordanates());
		
		List<SpaceProbe> list = new ArrayList<SpaceProbe>(nasa.getSpaceProbeMap().values());
		
		Position position1 = list.get(0).getPosition();
		Direction direction1 = list.get(0).getDirection();
		
		Position position2 = list.get(1).getPosition();
		Direction direction2 = list.get(1).getDirection();
		
		assertEquals(position1.getX(), 1);
		assertEquals(position1.getY(), 3);
		assertEquals(direction1, Direction.N);
		
		assertEquals(position2.getX(), 5);
		assertEquals(position2.getY(), 1);
		assertEquals(direction2, Direction.E);
		
	}
	

}
